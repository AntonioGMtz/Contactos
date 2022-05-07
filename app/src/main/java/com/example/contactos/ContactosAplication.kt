package com.example.contactos

import android.app.Application
import androidx.room.Room

class ContactosAplication : Application() {
    //Patron singlenton pars acceder desde cualquier pate de la app a la BDD
    companion object{
        lateinit var database: ContactosDatabase
    }

    override fun onCreate() {
        super.onCreate()


        //Creacion de un RoomDatabse de una databse no persistente
        database = Room.databaseBuilder(this,
            ContactosDatabase::class.java,
            "StoreDatabase")
            .fallbackToDestructiveMigration() //Destruye los datos guardados cada que exista una modificacion en la BDD
            .build()
    }
}