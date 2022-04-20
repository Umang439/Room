package com.example.roomwithviewmodel.DataBase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert
    suspend fun insert(userData: UserData):Long

    @Update
    suspend fun update(userData: UserData)

    @Delete
    suspend fun delete(userData: UserData)

    @Query("DELETE FROM `user table`")
    suspend fun deleteAll()

    @Query("SELECT * FROM `user table` ")
    fun getAll():LiveData<List<UserData>>

}