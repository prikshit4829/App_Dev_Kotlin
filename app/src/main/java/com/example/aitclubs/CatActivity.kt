package com.example.aitclubs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.aitclubs.Adapter.CatAdapter
import com.example.aitclubs.Adapter.CatImagesAdapter
import com.example.aitclubs.Model.OngoModel
import com.example.aitclubs.Model.catModel
import com.example.aitclubs.databinding.ActivityCatBinding
import com.google.firebase.firestore.FirebaseFirestore

class CatActivity : AppCompatActivity() {
    lateinit var binding: ActivityCatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db= FirebaseFirestore.getInstance()
        val uid = intent.getStringExtra("uid")
        val name = intent.getStringExtra("name")

        db.collection("clubs").document(uid!!).collection("events").addSnapshotListener { value, error ->

            val listOfCatPoster = arrayListOf<OngoModel>()
            val data = value?.toObjects(OngoModel::class.java)
            listOfCatPoster.addAll(data!!)

            binding.catTitle.text=name.toString()
            binding.catCount.text="${listOfCatPoster.size.toString()} event available"

            binding.catRcv.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            binding.catRcv.adapter=CatImagesAdapter(this,listOfCatPoster)

        }

    }
}