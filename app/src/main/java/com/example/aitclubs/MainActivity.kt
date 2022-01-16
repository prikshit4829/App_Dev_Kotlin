package com.example.aitclubs

import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aitclubs.databinding.ActivityMainBinding
import com.example.aitclubs.fragments.HomeFragment
import com.example.aitclubs.fragments.LikeFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.icHome.setOnClickListener{
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
            replaceFragment(HomeFragment())
        }
         binding.icLike.setOnClickListener {
        Toast.makeText(this, "liked", Toast.LENGTH_SHORT).show()
        replaceFragment(LikeFragment())
        }
    }
    fun replaceFragment(fragment:Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentReplace, fragment)
        transaction.commit()
    }
}