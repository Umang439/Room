package com.example.roomwithmvvm.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomwithmvvm.Adapter.MyAdapter
import com.example.roomwithmvvm.Factory.UserViewModelFactory
import com.example.roomwithmvvm.R
import com.example.roomwithmvvm.Repository.UserRepository
import com.example.roomwithmvvm.databinding.ActivityMainBinding
import com.example.roomwithmvvm.viewModel.UserViewModel
import com.example.roomwithviewmodel.DataBase.UserDatabase

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recycleview.layoutManager=LinearLayoutManager(this)

        val dao=UserDatabase.getInstance(this).dao
        val userRepository=UserRepository(dao)
        val factory = UserViewModelFactory(userRepository)

        userViewModel=ViewModelProvider(this,factory)[UserViewModel::class.java]

        binding.userViewModel=userViewModel
        binding.lifecycleOwner=this

        displayList()

    }

    private fun displayList() {
        userViewModel.usersList.observe(this, {
            binding.recycleview.adapter=MyAdapter(it.reversed())
        })

    }
}