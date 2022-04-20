package com.example.roomwithviewmodel.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserData::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract val dao:UserDao

    companion object{
        private val INSTANCE: UserDatabase? =null
        fun getInstance(context: Context):UserDatabase{
            var instance= INSTANCE
            if (instance==null)
            {
                instance=Room.databaseBuilder(context,UserDatabase::class.java,"User Database")
                    .build()
            }
            return instance
        }
    }
}