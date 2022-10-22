package com.example.psychologicaltests_knowyourself.Activites

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.psychologicaltests_knowyourself.databinding.*
import java.io.IOException

class TestDescriptionActivity : AppCompatActivity() {
    private val testResultIsReady = 100

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
            if (result.resultCode == testResultIsReady) {
                finish()
            }
        }
    }

    private fun inflater() {
        binding = ActivityTestDescriptionBinding.inflate(layoutInflater)
        builderOfSubtestDescription()
        setContentView(binding.root)
    }

    private fun builderOfSubtestDescription() {
            when (intent.getStringExtra("codesOfSubtests")) {
                "01" -> {
                    testDescriptionFilling("character_test_detail.xml")
                }
                "02" -> {
                    testDescriptionFilling("character_test_detail.xml")
                }
                "11" -> {
                    testDescriptionFilling("character_test_detail.xml")
                }
                "12" -> {
                    testDescriptionFilling("character_test_detail.xml")
                }
                "21" -> {
                    testDescriptionFilling("career_test_detail.xml")
                }
                "22" -> {
                    testDescriptionFilling("character_test_detail.xml")
                }
                "31" -> {
                    testDescriptionFilling("character_test_detail.xml")
                }
                "32" -> {
                    testDescriptionFilling("character_test_detail.xml")
                }
                "41" -> {
                    testDescriptionFilling("family_test_detail.xml")
                }
                "42" -> {
                    testDescriptionFilling("character_test_detail.xml")
                }
                "51" -> {
                    testDescriptionFilling("character_test_detail.xml")
                }
                "52" -> {
                    testDescriptionFilling("character_test_detail.xml")
                }
                "61" -> {
                    testDescriptionFilling("psychodiagnostics_test_detail.xml")
                }
                "62" -> {
                    testDescriptionFilling("character_test_detail.xml")
                }
            }
    }

    @SuppressLint("SetTextI18n")
    private fun testDescriptionFilling(fileNameOfTestComponents: String) {
        tryToParseForTestDescriptionAndFillDescription(fileNameOfTestComponents)
    }

    private fun tryToParseForTestDescriptionAndFillDescription(fileNameFromAssets: String) {
        try {
            val parser = XmlPullParserHandler()
            val istream = assets.open(fileNameFromAssets)
            val testQuestion = parser.parseForTestDescription(istream)
            fillTitleAndDescription(testQuestion)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun fillTitleAndDescription(testQuestion: TestQuestion) {
        binding.textTitle.text = testQuestion.title
        binding.textDescription.text = testQuestion.description
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