package com.example.psychologicaltests_knowyourself.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.psychologicaltests_knowyourself.databinding.*
import java.io.IOException

class TestActivity : AppCompatActivity() {

    private var countOfAnswers: Int = 2
    private var countOfQuestions: Int = 1
    private var numberOfCurrentQuestion = 1
    private var score = 0
    private lateinit var fileNameOfTestComponents: String

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

            /*                          Кодировка тестов
              0* - Тесты про характер           |      * - номер теста
              1* - Тесты про жизнь              |
              2* - Тесты про карьеру            |
              3* - Тесты про умственные         |
              4* - Тесты про семья              |
              5* - Тесты про психодиагностику   |                       */

            "01" -> {
                lateTestFilling("character_test_detail.xml")
            }
            "02" -> {
                lateTestFilling("character_test2_detail.xml")
            }
            "11" -> {
                lateTestFilling("character_test_detail.xml")
            }
            "12" -> {
                lateTestFilling("character_test_detail.xml")
            }
            "21" -> {
                lateTestFilling("career_test_detail.xml")
            }
            "22" -> {
                lateTestFilling("career_test2_detail.xml")
            }
            "31" -> {
                lateTestFilling("mental_test_detail.xml")
            }
            "32" -> {
                lateTestFilling("character_test_detail.xml")
            }
            "41" -> {
                lateTestFilling("family_test_detail.xml")
            }
            "42" -> {
                lateTestFilling("character_test_detail.xml")
            }
            "51" -> {
                lateTestFilling("psychodiagnostics_test_detail.xml")
            }
            "52" -> {
                lateTestFilling("psychodiagnostics_test2_detail.xml")
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun lateTestFilling(fileNameFromAssets: String) {
        this@TestActivity.fileNameOfTestComponents = fileNameFromAssets
        tryToParseForTestAndFillTest()
        countAnswers()
    }

    private fun tryToParseForTestAndFillTest() {
        try {
            val parser = XmlPullParserHandler()
            val istream = assets.open(fileNameOfTestComponents)
            val testQuestion = parser.parseForTest(istream, 1)
            assignValueToCountOfAnswersAndQuestions(testQuestion)
            fillTitle(testQuestion)
            fillQuestionAndAnswersAndCurrentTableOfProgress(testQuestion)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun assignValueToCountOfAnswersAndQuestions(testInfo: TestInfo) {
        this@TestActivity.countOfAnswers = testInfo.countAnswers
        this@TestActivity.countOfQuestions = testInfo.countQuestions
    }

    @SuppressLint("SetTextI18n")
    private fun fillTitle(testInfo: TestInfo) {
        binding.textTitle.text = testInfo.title
    }

    @SuppressLint("SetTextI18n")
    private fun fillQuestionAndAnswersAndCurrentTableOfProgress(testInfo: TestInfo) {
        binding.textQuestion.text = testInfo.question
        binding.textNumberQuestion.text = "$numberOfCurrentQuestion/${this@TestActivity.countOfQuestions}"
        when (countOfAnswers) {
            2 -> {
                binding.option1.text = testInfo.listOfAnswers[0]
                binding.option2.text = testInfo.listOfAnswers[1]
            }
            3 -> {
                binding.option1.text = testInfo.listOfAnswers[0]
                binding.option2.text = testInfo.listOfAnswers[1]
                binding.option3.text = testInfo.listOfAnswers[2]
            }
            4 -> {
                binding.option1.text = testInfo.listOfAnswers[0]
                binding.option2.text = testInfo.listOfAnswers[1]
                binding.option3.text = testInfo.listOfAnswers[2]
                binding.option4.text = testInfo.listOfAnswers[3]
            }
            5 -> {
                binding.option1.text = testInfo.listOfAnswers[0]
                binding.option2.text = testInfo.listOfAnswers[1]
                binding.option3.text = testInfo.listOfAnswers[2]
                binding.option4.text = testInfo.listOfAnswers[3]
                binding.option5.text = testInfo.listOfAnswers[4]
            }
            else -> {
                binding.option1.text = testInfo.listOfAnswers[0]
                binding.option2.text = testInfo.listOfAnswers[1]
                binding.option3.text = testInfo.listOfAnswers[2]
                binding.option4.text = testInfo.listOfAnswers[3]
                binding.option5.text = testInfo.listOfAnswers[4]
                binding.option6.text = testInfo.listOfAnswers[5]
            }
        }
    }

    private fun countAnswers() {
        when (countOfAnswers) {
            2 -> {
                binding.option3Frame.visibility = View.GONE
                binding.option4Frame.visibility = View.GONE
                binding.option5Frame.visibility = View.GONE
                binding.option6Frame.visibility = View.GONE
                binding.option3Frame.isEnabled = false
                binding.option4Frame.isEnabled = false
                binding.option5Frame.isEnabled = false
                binding.option6Frame.isEnabled = false
            }
            3 -> {
                binding.option4Frame.visibility = View.GONE
                binding.option5Frame.visibility = View.GONE
                binding.option6Frame.visibility = View.GONE
                binding.option4Frame.isEnabled = false
                binding.option5Frame.isEnabled = false
                binding.option6Frame.isEnabled = false
            }
            4 -> {
                binding.option5Frame.visibility = View.GONE
                binding.option6Frame.visibility = View.GONE
                binding.option5Frame.isEnabled = false
                binding.option6Frame.isEnabled = false
            }
            5 -> {
                binding.option6Frame.visibility = View.GONE
                binding.option6Frame.isEnabled = false
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setListeners() {
        binding.imageBack.setOnClickListener {
            onBackPressed()
        }
        binding.option1Frame.setOnClickListener {
            loadQuestionOrShowResult()
        }
        binding.option2Frame.setOnClickListener {
            loadQuestionOrShowResult()
        }
        binding.option3Frame.setOnClickListener {
            loadQuestionOrShowResult()
        }
        binding.option4Frame.setOnClickListener {
            loadQuestionOrShowResult()
        }
        binding.option5Frame.setOnClickListener {
            loadQuestionOrShowResult()
        }
        binding.option6Frame.setOnClickListener {
            loadQuestionOrShowResult()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun loadQuestionOrShowResult() {
        if (numberOfCurrentQuestion >= countOfQuestions) {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("title", binding.textTitle.text)
            startActivity(intent)
            finish()
        } else {
            ++numberOfCurrentQuestion
            try {
                val parser = XmlPullParserHandler()
                val istream = assets.open(fileNameOfTestComponents)
                val testQuestion = parser.parseForTest(istream, numberOfCurrentQuestion)
                fillQuestionAndAnswersAndCurrentTableOfProgress(testQuestion)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

//    private fun countScore(): Int {
//        var result: Int
//        when (intent.getStringExtra("codesOfSubtests")) {
//            "01" -> {
//                result = test01SumScore()
//            }
//            "02" -> {
//            }
//            "11" -> {
//            }
//            "12" -> {
//            }
//            "21" -> {
//            }
//            "22" -> {
//            }
//            "31" -> {
//            }
//            "32" -> {
//            }
//            "41" -> {
//            }
//            "42" -> {
//            }
//            "51" -> {
//            }
//            "52" -> {
//            }
//        }
//        return result
//    }

//    private fun test01SumScore(): Int {
//
//    }
}