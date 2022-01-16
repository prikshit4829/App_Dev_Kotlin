package com.example.aitclubs.fragments

import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aitclubs.R
import com.example.aitclubs.databinding.FragmentLikeBinding
import java.io.File

class LikeFragment : Fragment() {

  lateinit var binding:FragmentLikeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLikeBinding.inflate(layoutInflater,container,false)

//        val allFiles:Array<File>
//        val imageList= arrayListOf<String>()
//
//        val targetPath=Environment.getExternalStorageDirectory().absolutePath+"/Images/Amoled Wallpaper"
//
//        val targetFile=File(targetPath)
//        allFiles= targetFile.listFiles()!!
//
//        for (data in allFiles){
//            imageList.add(data.absolutePath)
//        }

        return binding.root
    }


}