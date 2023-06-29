package com.example.basededatos
class Nombre {
    var id: Int = 0 //declara una variable id que será tipo entero

    var NombreUsuario: String? = null //declara una variable String
    var ApellidoUsuario: String? = null //declara una variable String
    var EdadUsuario: Int? = null //declara una variable String

    // indicar que a la variable es posible asignarle valores nulos
    constructor(id: Int, nombre: String,apellido: String,edad:Int) { //constructor de la clase

        this.id = id
        this.NombreUsuario = nombre
        this.ApellidoUsuario =apellido
        this.EdadUsuario = edad

    }
    constructor(nombre: String,apellido: String,edad:Int) { //sobrecarga del constructor de la
        class Nombre
        this.NombreUsuario = nombre
        this.ApellidoUsuario =apellido
        this.EdadUsuario = edad

    }
}
