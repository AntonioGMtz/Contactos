package com.example.contactos

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = arrayOf(ContactosEntity::class),version = 1)
abstract class ContactosDatabase : RoomDatabase() {

    //Configurando el dao

    abstract fun contactoDao() : ContactosDao


}