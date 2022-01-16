package com.example.aitclubs.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aitclubs.FinalPoster
import com.example.aitclubs.Model.OngoModel
import com.example.aitclubs.R

class OngoAdapter(val requireContext: Context,val listOngoing: ArrayList<OngoModel>) : RecyclerView.Adapter<OngoAdapter.ongoViewHolder>() {
    inner class ongoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView=itemView.findViewById<ImageView>(R.id.ongo_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ongoViewHolder {
        return ongoViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_ongo,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ongoViewHolder, position: Int) {
    holder.imageView
        Glide.with(requireContext).load(listOngoing[position].link).into(holder.imageView)
        holder.itemView.setOnClickListener {
           val intent= Intent(requireContext,FinalPoster::class.java)
           intent.putExtra("link",listOngoing[position].link)
            requireContext.startActivity(intent)
        }
    }

    override fun getItemCount()=listOngoing.size
}