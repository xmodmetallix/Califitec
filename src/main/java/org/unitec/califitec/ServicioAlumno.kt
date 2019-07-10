package org.unitec.califitec

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ServicioAlumno {


    @POST("api/alumno")
    fun guardar(@Body alumno:Alumno): Call<Status>

    @POST("api/alumno/autenticar")
    fun autenticar(@Body alumno:Alumno):Call<Alumno>

    @GET("api/alumno/{cuenta}")
    fun buscarPorCuenta(@Path("cuenta") cuenta:String?):Call<Alumno>

    @GET("api/alumno")
    fun buscarTodos():Call<ArrayList<Alumno>>
}