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
import com.makeramen.roundedimageview.RoundedImageView

class CatImagesAdapter(val requireContext: Context, val listOngoing: ArrayList<OngoModel>) : RecyclerView.Adapter<CatImagesAdapter.ongoViewHolder>() {
    inner class ongoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView=itemView.findViewById<RoundedImageView>(R.id.catImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ongoViewHolder {
        return ongoViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_poster,parent,false)
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