package com.example.psychologicaltests_knowyourself.Activites

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.psychologicaltests_knowyourself.databinding.*
import java.io.IOException

class TestActivity : AppCompatActivity() {

    private val testResultIsReady = 100
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

            //                              Кодировка тестов
            //  0* - Тесты про характер           |      * - номер теста
            //  1* - Тесты про жизнь              |
            //  2* - Тесты про карьеру            |
            //  3* - Тесты про умственные         |
            //  4* - Тесты про семья              |
            //  5* - Тесты про секс               |
            //  6* - Тесты про психодиагностику   |

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
                lateTestFilling("character_test_detail.xml")
            }
            "52" -> {
                lateTestFilling("character_test_detail.xml")
            }
            "61" -> {
                lateTestFilling("psychodiagnostics_test_detail.xml")
            }
            "62" -> {
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

    private fun assignValueToCountOfAnswersAndQuestions(testQuestion: TestQuestion) {
        this@TestActivity.countOfAnswers = testQuestion.countAnswers
        this@TestActivity.countOfQuestions = testQuestion.countQuestions
    }

    @SuppressLint("SetTextI18n")
    private fun fillTitle(testQuestion: TestQuestion) {
        binding.textTitle.text = testQuestion.title
    }

    @SuppressLint("SetTextI18n")
    private fun fillQuestionAndAnswersAndCurrentTableOfProgress(testQuestion: TestQuestion) {
        binding.textQuestion.text = testQuestion.question
        binding.textNumberQuestion.text = "$numberOfCurrentQuestion/${this@TestActivity.countOfQuestions}"
        when (countOfAnswers) {
            2 -> {
                binding.option1.text = testQuestion.listOfAnswers[0]
                binding.option2.text = testQuestion.listOfAnswers[1]
            }
            3 -> {
                binding.option1.text = testQuestion.listOfAnswers[0]
                binding.option2.text = testQuestion.listOfAnswers[1]
                binding.option3.text = testQuestion.listOfAnswers[2]
            }
            4 -> {
                binding.option1.text = testQuestion.listOfAnswers[0]
                binding.option2.text = testQuestion.listOfAnswers[1]
                binding.option3.text = testQuestion.listOfAnswers[2]
                binding.option4.text = testQuestion.listOfAnswers[3]
            }
            5 -> {
                binding.option1.text = testQuestion.listOfAnswers[0]
                binding.option2.text = testQuestion.listOfAnswers[1]
                binding.option3.text = testQuestion.listOfAnswers[2]
                binding.option4.text = testQuestion.listOfAnswers[3]
                binding.option5.text = testQuestion.listOfAnswers[4]
            }
            else -> {
                binding.option1.text = testQuestion.listOfAnswers[0]
                binding.option2.text = testQuestion.listOfAnswers[1]
                binding.option3.text = testQuestion.listOfAnswers[2]
                binding.option4.text = testQuestion.listOfAnswers[3]
                binding.option5.text = testQuestion.listOfAnswers[4]
                binding.option6.text = testQuestion.listOfAnswers[5]
            }
        }
    }

    private fun countAnswers() {
        when (countOfAnswers) {
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

    @SuppressLint("SetTextI18n")
    private fun setListeners() {
        binding.imageBack.setOnClickListener {
            onBackPressed()
        }
        binding.option1.setOnClickListener {
            loadQuestionOrShowResult()
        }
        binding.option2.setOnClickListener {
            loadQuestionOrShowResult()
        }
        binding.option3.setOnClickListener {
            loadQuestionOrShowResult()
        }
        binding.option4.setOnClickListener {
            loadQuestionOrShowResult()
        }
        binding.option5.setOnClickListener {
            loadQuestionOrShowResult()
        }
        binding.option6.setOnClickListener {
            loadQuestionOrShowResult()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun loadQuestionOrShowResult() {
        if (numberOfCurrentQuestion >= countOfQuestions) {
            setResult(testResultIsReady)
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
//            "61" -> {
//            }
//            "62" -> {
//            }
//        }
//        return result
//    }

//    private fun test01SumScore(): Int {
//
//    }
}