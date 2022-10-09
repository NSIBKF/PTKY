package com.example.psychologicaltests_knowyourself.Activites

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.psychologicaltests_knowyourself.databinding.*

class TestActivity : AppCompatActivity() {

    private var countOfOptions: Int = 2
    private var numberOfCurrentTest = 1

    private lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inflater()
    }

    override fun onStart() {
        super.onStart()
        setListeners()

    }

    private fun inflater() {
            binding = ActivityTestBinding.inflate(layoutInflater)
                setContentView(binding.root)
                builderOfSubtest()
    }


    @SuppressLint("SetTextI18n")
    private fun builderOfSubtest() {
        when (intent.getStringExtra("codesOfSubtests")) {

            //                              Кодировка тестов
            //  0* - Тесты про характер           |      * - номер теста
            //  1* - Тесты про жизнь              |
            //  2* - Тесты про карьеру            |
            //  3* - Тесты про умственные         |
            //  4* - Тесты про семья              |
            //  5* - Тесты про секс               |
            //  6* - Тесты про психодиагностику   |

            "01" -> {
                lateFillingTest(30, 3, "Пять черт характера")
            }
            "02" -> {
                lateFillingTest(45, 4, "Характер топ")
            }
            "11" -> {
                lateFillingTest(45, 4, "Тест 1 по теме жизнь")
            }
            "12" -> {
                lateFillingTest(45, 4, "Тест 2 по теме жизнь")
            }
            "21" -> {
                lateFillingTest(45, 4, "Опросник уровня удовлетворенности работой")
            }
            "22" -> {
                lateFillingTest(45, 6, "Тест на трудоголизм. Диагностика уровня занятости и зависимости от работы")
            }
            "31" -> {
                lateFillingTest(45, 3, "Тест 1 по теме умственные")
            }
            "32" -> {
                lateFillingTest(45, 3, "Тест 2 по теме умственные")
            }
            "41" -> {
                lateFillingTest(45, 3, "Тест 1 по теме семья")
            }
            "42" -> {
                lateFillingTest(45, 3, "Тест 2 по теме семья")
            }
            "51" -> {
                lateFillingTest(45, 3, "Тест 1 по теме секс")
            }
            "52" -> {
                lateFillingTest(45, 3, "Тест 2 по теме секс")
            }
            "61" -> {
                lateFillingTest(45, 3, "Тест 1 по теме психодиагностика")
            }
            "62" -> {
                lateFillingTest(45, 3, "Тест 2 по теме психодиагностика")
            }
        }
    }

    private fun lateFillingTest(countQuestions: Int, countOfOptions: Int, title: String) {
        this@TestActivity.countOfOptions = countOfOptions
        binding.textTitle.text = title
        binding.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
        countOptions()
    }

    private fun countOptions() {
        when (countOfOptions) {
            2 -> {
                binding.option3.visibility = View.GONE
                binding.option4.visibility = View.GONE
                binding.option5.visibility = View.GONE
                binding.option6.visibility = View.GONE
                binding.option3.isEnabled = false
                binding.option4.isEnabled = false
                binding.option5.isEnabled = false
                binding.option6.isEnabled = false
            }
            3 -> {
                binding.option4.visibility = View.GONE
                binding.option5.visibility = View.GONE
                binding.option6.visibility = View.GONE
                binding.option4.isEnabled = false
                binding.option5.isEnabled = false
                binding.option6.isEnabled = false
            }
            4 -> {
                binding.option5.visibility = View.GONE
                binding.option6.visibility = View.GONE
                binding.option5.isEnabled = false
                binding.option6.isEnabled = false
            }
            5 -> {
                binding.option6.visibility = View.GONE
                binding.option6.isEnabled = false
            }
        }
    }

    private fun setListeners() {
        binding.imageBack.setOnClickListener {
            onBackPressed()
        }
        binding.option1.setOnClickListener {
            startActivity(Intent(this, ResultActivity::class.java))
        }
    }
}