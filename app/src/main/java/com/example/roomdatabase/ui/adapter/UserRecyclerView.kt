package com.example.roomdatabase.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.R
import com.example.roomdatabase.model.entity.User

class UserRecyclerView : RecyclerView.Adapter<UserRecyclerView.UserViewHolder>() {

    var userlist : List<User> = emptyList()

    fun setList(userlist:List<User>){
        this.userlist = userlist
        notifyDataSetChanged()
    }

    class UserViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
         var iv_userimage : ImageView = itemView.findViewById(R.id.iv_item)
        var iv_userame : TextView = itemView.findViewById(R.id.tv_item_username)
        var iv_message : TextView = itemView.findViewById(R.id.tv_item_message)

        fun bind(user: User){
            iv_userimage.setImageResource(user.imageId)
            iv_userame.text = user.name
            iv_message.text = user.message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.items_list,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var user: User = userlist.get(position)
        holder.bind(user)
      }

    override fun getItemCount(): Int {
        return userlist.size
    }
}