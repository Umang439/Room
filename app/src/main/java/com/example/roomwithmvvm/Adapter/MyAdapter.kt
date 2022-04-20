package com.example.roomwithmvvm.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomwithmvvm.databinding.RoomRecycleLayoutBinding
import com.example.roomwithviewmodel.DataBase.UserData

class MyAdapter(val userList: List<UserData>): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=RoomRecycleLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}

class MyViewHolder(val binding: RoomRecycleLayoutBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(userData: UserData){
        binding.tvName.text=userData.fname
        binding.tvLname.text=userData.lname
        binding.tvPhone.text=userData.phone


    }

}