package com.example.psychologicaltests_knowyourself.Activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.psychologicaltests_knowyourself.databinding.*
import java.io.IOException

class TestDescriptionActivity : AppCompatActivity() {
    private val resultIsReady = 100

    private lateinit var binding: ActivityTestDescriptionBinding
    private var testLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ifResultIsReadyFinish()
        inflater()
    }

    override fun onStart() {
        super.onStart()
        setListeners()
    }

    private fun ifResultIsReadyFinish() {
        /* conditions for any ways of using result codes from TestActivity */
        testLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result: ActivityResult ->
            if (result.resultCode == resultIsReady) {
                finish()
            }
        }
    }

    private fun inflater() {
        binding = ActivityTestDescriptionBinding.inflate(layoutInflater)
        fillDescription()
        setContentView(binding.root)
    }

    private fun fillDescription() {
        val subtestCode = intent.getStringExtra("codesOfSubtests")
        var testQuestion = TestQuestion()
        try {
            val parser = XmlPullParserHandler()
            val istream = assets.open("character_test_detail.xml")
            testQuestion = parser.parseForTestDescription(istream)
        } catch (e: IOException) {
            e.printStackTrace()
        }
            when (subtestCode) {

                //________________________________Отрисовка тестов с Характером_______________________________________________

                "01" -> {
                    binding.textTitle.text = "Пять черт характера"
                    binding.textDescription.text = testQuestion.description
                }
                "02" -> {
                    binding.textTitle.text = "Характер топ"
                    binding.textDescription.text = "ОПИСАНИЕ"
                }

                //_____________________________________________________________________________________________________________



                //_______________________________Отрисовка тестов с Жизнью_____________________________________________________

                "11" -> {
                    binding.textTitle.text = "Тест 1 по теме жизнь"
                    binding.textDescription.text = "ОПИСАНИЕ"
                }
                "12" -> {
                    binding.textTitle.text = "Тест 2 по теме жизнь"
                    binding.textDescription.text = "ОПИСАНИЕ"
                }

                //-------------------------------------------------------------------------------------------------------------



                //______________________________Отрисовка тестов с Карьерой_____________________________________________________

                "21" -> {
                    binding.textTitle.text = "Опросник уровня удовлетворенности работой"
                    binding.textDescription.text = "ОПИСАНИЕ"
                }
                "22" -> {
                    binding.textTitle.text = "Тест на трудоголизм. Диагностика уровня занятости и зависимости от работы"
                    binding.textDescription.text = "ОПИСАНИЕ"
                }

                //-------------------------------------------------------------------------------------------------------------




                //______________________________Отрисовка тестов с Умственными_________________________________________________

                "31" -> {
                    binding.textTitle.text = "Тест 1 по теме умственные"
                    binding.textDescription.text = "ОПИСАНИЕ"
                }
                "32" -> {
                    binding.textTitle.text = "Тест 2 по теме умственные"
                    binding.textDescription.text = "ОПИСАНИЕ"
                }

                //-------------------------------------------------------------------------------------------------------------




                //______________________________Отрисовка тестов с Семьей_____________________________________________________

                "41" -> {
                    binding.textTitle.text = "Тест 1 по теме семья"
                    binding.textDescription.text = "ОПИСАНИЕ"
                }
                "42" -> {
                    binding.textTitle.text = "Тест 2 по теме семья"
                    binding.textDescription.text = "ОПИСАНИЕ"
                }

                //-------------------------------------------------------------------------------------------------------------




                //______________________________Отрисовка тестов с Сексом_____________________________________________________

                "51" -> {
                    binding.textTitle.text = "Тест 1 по теме секс"
                    binding.textDescription.text = "ОПИСАНИЕ"
                }
                "52" -> {
                    binding.textTitle.text = "Тест 2 по теме секс"
                    binding.textDescription.text = "ОПИСАНИЕ"
                }

                //-------------------------------------------------------------------------------------------------------------




                //______________________________Отрисовка тестов с Психодиагностикой____________________________________________

                "61" -> {
                    binding.textTitle.text = "Тест 1 по теме психодиагностика"
                    binding.textDescription.text = "ОПИСАНИЕ"
                }
                "62" -> {
                    binding.textTitle.text = "Тест 2 по теме психодиагностика"
                    binding.textDescription.text = "ОПИСАНИЕ"
                }

                //________________________________________________________________________________________________________________
            }
    }

    private fun setListeners() {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.startTest.setOnClickListener {
                    comeToTestActivity()
                }
            }

    private fun comeToTestActivity() {
        val subtestCode = intent.getStringExtra("codesOfSubtests")
        val intent = Intent(this, TestActivity::class.java)
        intent.putExtra("codesOfSubtests", subtestCode)
        testLauncher?.launch(intent)
    }

}