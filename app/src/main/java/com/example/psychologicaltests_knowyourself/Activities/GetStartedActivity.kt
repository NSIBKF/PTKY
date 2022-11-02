package com.example.psychologicaltests_knowyourself.Activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.psychologicaltests_knowyourself.databinding.ActivityGetStartedActivityBinding


class GetStartedActivity : AppCompatActivity() {

    lateinit var binding: ActivityGetStartedActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        binding.getStartedBtn.setOnClickListener {
            val intent : Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}