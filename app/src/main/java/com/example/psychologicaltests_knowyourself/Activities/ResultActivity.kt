package com.example.psychologicaltests_knowyourself.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.psychologicaltests_knowyourself.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        binding.textTitle.text = intent.getStringExtra("title")
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        setListeners()
    }

    private fun setListeners() {
        binding.backToTests.setOnClickListener {
            onBackPressed()
        }
    }
}