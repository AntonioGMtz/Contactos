package com.example.contactos

import androidx.room.*

@Dao
interface ContactosDao {

    @Query("SELECT * FROM ContactosEntity")
    fun getAllStores(): MutableList<ContactosEntity>

    @Insert
    fun addStore(contactosEntity: ContactosEntity) : Long

    @Update
    fun updateStore(contactosEntity: ContactosEntity)

    @Delete
    fun deleteStore(contactosEntity: ContactosEntity)

    @Query("SELECT * FROM ContactosEntity where id = :id ")
    fun getStoreById(id:Long): ContactosEntity
}