package com.example.aitclubs.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aitclubs.CatActivity
import com.example.aitclubs.Model.catModel
import com.example.aitclubs.R

class CatAdapter(val requireContext: Context, val listOfCat: ArrayList<catModel>) : RecyclerView.Adapter<CatAdapter.ongoViewHolder>() {

    inner class ongoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView=itemView.findViewById<ImageView>(R.id.cat_image)
        val name=itemView.findViewById<TextView>(R.id.cat_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ongoViewHolder {
        return ongoViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_cat,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ongoViewHolder, position: Int) {
        holder.name.text=listOfCat[position].name
        Glide.with(requireContext).load(listOfCat[position].link).into(holder.imageView)
        holder.itemView.setOnClickListener {
            val intent= Intent(requireContext,CatActivity::class.java)
            intent.putExtra("uid",listOfCat[position].id)
            intent.putExtra("uid",listOfCat[position].name)
            requireContext.startActivity(intent)
        }
    }

    override fun getItemCount()=listOfCat.size
}