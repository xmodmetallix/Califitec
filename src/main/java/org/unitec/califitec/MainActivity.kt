package org.unitec.califitec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.mobsandgeeks.saripaar.ValidationError
import com.mobsandgeeks.saripaar.Validator
import com.mobsandgeeks.saripaar.annotation.Email
import com.mobsandgeeks.saripaar.annotation.NotEmpty
import com.mobsandgeeks.saripaar.annotation.Password
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Validator.ValidationListener {
    @NotEmpty(message = "El E-mail es requerido")
    @Email(message = "correo inválido")
    private var login: TextInputEditText?=null

    @NotEmpty(message = "La contraseña es requerida")
    @Password(min = 6, scheme = Password.Scheme.ALPHA_NUMERIC, message = "password no valido")
    private var password: TextInputEditText? = null

    override fun onValidationFailed(errors: MutableList<ValidationError>?) {
        //Aqui van las acciones  a tomar en caso de validaciones erroneas
        var mensa ="men"

        for (error in errors!!) {
            val view = error.view

            mensa=error.getCollatedErrorMessage(applicationContext)
            Toast.makeText(applicationContext,mensa,Toast.LENGTH_LONG).show()
        }
    }

    override fun onValidationSucceeded() {
        //Aqui van acciones a tomar si la validación fue exitosa, por ejemplo navegacion a otro activity
        //hola
        TareaAutenticarAlumno(this,this).execute()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var validator = Validator(this);
        validator.setValidationListener(this);
        login= txtEmail
        password= txtPassword

        button.setOnClickListener {
            validator.validate();
        }
    }
}
