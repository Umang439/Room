package com.example.roomwithmvvm.Repository

import com.example.roomwithviewmodel.DataBase.UserDao
import com.example.roomwithviewmodel.DataBase.UserData

class UserRepository(val dao: UserDao) {
   suspend fun insert(userData: UserData){
        dao.insert(userData)
    }
    suspend fun update(userData: UserData){
        dao.update(userData)
    }
    suspend fun delete(userData: UserData){
        dao.delete(userData)
    }
    suspend fun deleteAll() {
        dao.deleteAll()
    }
    val getAll=dao.getAll()
}