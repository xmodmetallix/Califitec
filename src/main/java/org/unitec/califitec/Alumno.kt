package org.unitec.califitec

import com.fasterxml.jackson.annotation.JsonIgnoreProperties


@JsonIgnoreProperties(ignoreUnknown = true)
class Alumno {
    var cuenta:String?=null
    var nombre:String?=null
    var materias:ArrayList<Materia>?=null
    var email:String?=null
    var autenticado:Boolean?=null
}