package com.example.psychologicaltests_knowyourself.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.psychologicaltests_knowyourself.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    /*  Кодировка тестов
      0 - Тесты про характер
      1 - Тесты про жизнь
      2 - Тесты про карьеру
      3 - Тесты про умственные
      4 - Тесты про семья
      5 - Тесты про психодиагностику */
    private val codesOfTests = arrayOf(0, 1, 2, 3, 4, 5)

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
        binding.psychodiagnosticsBtn.setOnClickListener {
            comeToActivity(5)
        }
    }

    private fun comeToActivity(testCode: Int) {
        val intent = Intent(this, chooseTestActivity::class.java)
        intent.putExtra("codesOfTests",codesOfTests[testCode])
        startActivity(intent)
    }

}