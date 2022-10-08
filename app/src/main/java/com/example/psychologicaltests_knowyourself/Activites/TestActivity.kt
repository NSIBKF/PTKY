package com.example.psychologicaltests_knowyourself.Activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.psychologicaltests_knowyourself.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    lateinit var binding : ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        setListeners()

    }

    private fun setListeners() {
        binding.imageBack.setOnClickListener {
            onBackPressed()
        }
    }
}