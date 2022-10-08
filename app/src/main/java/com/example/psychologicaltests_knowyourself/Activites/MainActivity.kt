package com.example.psychologicaltests_knowyourself.Activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import com.example.psychologicaltests_knowyourself.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val codesOfTests = arrayOf(0, 1, 2, 3, 4, 5, 6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        setListeners()
    }
    
    private fun setListeners() {
        binding.characterBtn.setOnClickListener { 
            comeToActivity(0)
        }
        binding.lifeBtn.setOnClickListener {
            comeToActivity(1)
        }
        binding.careerBtn.setOnClickListener {
            comeToActivity(2)
        }
        binding.mentalBtn.setOnClickListener {
            comeToActivity(3)
        }
        binding.familyBtn.setOnClickListener {
            comeToActivity(4)
        }
        binding.sexBtn.setOnClickListener {
            comeToActivity(5)
        }
        binding.psychodiagnosticsBtn.setOnClickListener {
            comeToActivity(6)
        }
    }

    private fun comeToActivity(testCode: Int) {
        val intent = Intent(this, chooseTestActivity::class.java)
        intent.putExtra("codesOfTests",codesOfTests[testCode])
        startActivity(intent)
    }

}