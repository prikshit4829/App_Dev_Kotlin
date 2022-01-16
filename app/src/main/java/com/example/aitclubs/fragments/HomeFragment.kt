package com.example.aitclubs.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aitclubs.Adapter.CatAdapter
import com.example.aitclubs.Adapter.OngoAdapter
import com.example.aitclubs.Model.OngoModel
import com.example.aitclubs.Model.catModel
import com.example.aitclubs.databinding.FragmentHomeBinding
import com.google.firebase.firestore.FirebaseFirestore



class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var db:FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(layoutInflater,container,false)

        db= FirebaseFirestore.getInstance()

        db.collection("upcoming").addSnapshotListener { value, error ->
            val listOngoing = arrayListOf<OngoModel>()
            val data = value?.toObjects(OngoModel::class.java)
            listOngoing.addAll(data!!)

            binding.rcvOngo.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,true)
            binding.rcvOngo.adapter=OngoAdapter(requireContext(),listOngoing)
        }



        db.collection("clubs").addSnapshotListener { value, error ->
        val listOfCategory= arrayListOf<catModel>()
         val data=value?.toObjects(catModel::class.java)
         listOfCategory.addAll(data!!)

         binding.rcvCat.layoutManager=GridLayoutManager(requireContext(),2)
         binding.rcvCat.adapter=CatAdapter(requireContext(),listOfCategory)

        }

        return binding.root
    }


}