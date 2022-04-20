package com.example.roomwithviewmodel.DataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User Table")
data class UserData(
    @PrimaryKey(autoGenerate = true)
    var seriol_no:Int,

    @ColumnInfo(name = "First Name")
    var fname:String,

    @ColumnInfo(name = "Last Name")
    var lname:String,

    @ColumnInfo(name = "Phone no")
    var phone:String,
)
