package com.example.contactos

import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey

//Tratarla como entidad
@Entity(tableName  = "ContactosEntity")
data class ContactosEntity (@PrimaryKey(autoGenerate = true) var id : Long = 0,
                            var nombre : String,
                            var aPaterno : String = "",
                            var aMaterno : String = "",
                            var edad : String = "",
                            var direccion : String ="",
                            var colonia : String = "",
                            var estado : String = "",
                            var poblacion : String = "",
                            var postal : String = "",
                            var Email : String = "",
                            var telefono : String = ""){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ContactosEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

}