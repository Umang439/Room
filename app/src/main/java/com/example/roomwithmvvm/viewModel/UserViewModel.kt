package com.example.roomwithmvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomwithmvvm.Repository.UserRepository

import com.example.roomwithviewmodel.DataBase.UserData

import kotlinx.coroutines.launch

class UserViewModel(val userRepository: UserRepository): ViewModel() {
     var firstName= MutableLiveData<String?>()
     var lastName= MutableLiveData<String?>()
     var phone_no= MutableLiveData<String?>()

     var save= MutableLiveData<String>()
     var delete= MutableLiveData<String>()

     init {
         save.value="save"
          delete.value="clear"
     }

    fun saveData(){
        val fname=firstName.value!!
        val lname=lastName.value!!
        val phone=phone_no.value!!
        insert(UserData(0,fname,lname,phone))

        firstName.value=null
        lastName.value=null
        phone_no.value=null


    }

    fun deleteData(){

    }


     fun insert(userData: UserData){
          viewModelScope.launch {
              userRepository.insert(userData)
          }
     }

    fun deleteAll(){
        viewModelScope.launch {
            userRepository.deleteAll()
        }
    }

    val usersList = userRepository.getAll
}