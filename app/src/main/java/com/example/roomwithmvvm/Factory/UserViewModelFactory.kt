package com.example.roomwithmvvm.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomwithmvvm.Repository.UserRepository
import com.example.roomwithmvvm.viewModel.UserViewModel
import java.lang.IllegalArgumentException

class UserViewModelFactory(val userRepository: UserRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)){
            return UserViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Viewmodel not found")    }
}