package com.example.psychologicaltests_knowyourself.activities


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.psychologicaltests_knowyourself.R
import com.example.psychologicaltests_knowyourself.databinding.*
import java.io.IOException


class chooseTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseTestBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inflater()
    }

    override fun onStart() {
        super.onStart()
        setListeners()
    }

    private fun inflater() {
        val testCode = intent.getIntExtra("codesOfTests", 0)
        binding = ActivityChooseTestBinding.inflate(layoutInflater)
        when (testCode) {
            /*  Кодировка тестов
                0 - Тесты про характер
                1 - Тесты про жизнь
                2 - Тесты про карьеру
                3 - Тесты про умственные
                4 - Тесты про семья
                5 - Тесты про психодиагностику */
            0 -> {
                //parse()
                val subtestsTitles = arrayOf(binding.textSubtitle1, binding.textSubtitle2)
                val subtestsDescriptions = arrayOf(binding.textDescription1, binding.textDescription2)
                val subtestsCntOfAnswers = arrayOf(binding.cntOfAnswers1, binding.cntOfAnswers2)
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.drawable.pic1, R.drawable.pic1)
                setViewForChooseTest("Характер", 2, subtestsTitles,
                    subtestsDescriptions, subtestsCntOfAnswers,
                    arrayOfIcons, arrayOfIconsImages)
            }
            1 -> {
                val subtestsTitles = arrayOf(binding.textSubtitle1, binding.textSubtitle2)
                val subtestsDescriptions = arrayOf(binding.textDescription1, binding.textDescription2)
                val subtestsCntOfAnswers = arrayOf(binding.cntOfAnswers1, binding.cntOfAnswers2)
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.drawable.pic1, R.drawable.pic1)
                setViewForChooseTest("Жизнь", 2, subtestsTitles,
                    subtestsDescriptions, subtestsCntOfAnswers,
                    arrayOfIcons, arrayOfIconsImages)
            }
            2 -> {
                val subtestsTitles = arrayOf(binding.textSubtitle1, binding.textSubtitle2)
                val subtestsDescriptions = arrayOf(binding.textDescription1, binding.textDescription2)
                val subtestsCntOfAnswers = arrayOf(binding.cntOfAnswers1, binding.cntOfAnswers2)
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.drawable.pic1, R.drawable.pic1)
                setViewForChooseTest("Карьера", 2, subtestsTitles,
                    subtestsDescriptions, subtestsCntOfAnswers,
                    arrayOfIcons, arrayOfIconsImages)
            }
            3 -> {
                val subtestsTitles = arrayOf(binding.textSubtitle1, binding.textSubtitle2)
                val subtestsDescriptions = arrayOf(binding.textDescription1, binding.textDescription2)
                val subtestsCntOfAnswers = arrayOf(binding.cntOfAnswers1, binding.cntOfAnswers2)
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.drawable.pic1, R.drawable.pic1)
                setViewForChooseTest("Умственные", 2, subtestsTitles,
                    subtestsDescriptions, subtestsCntOfAnswers,
                    arrayOfIcons, arrayOfIconsImages)
            }
            4 -> {
                val subtestsTitles = arrayOf(binding.textSubtitle1, binding.textSubtitle2)
                val subtestsDescriptions = arrayOf(binding.textDescription1, binding.textDescription2)
                val subtestsCntOfAnswers = arrayOf(binding.cntOfAnswers1, binding.cntOfAnswers2)
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.drawable.pic1, R.drawable.pic1)
                setViewForChooseTest("Семья", 2, subtestsTitles,
                    subtestsDescriptions, subtestsCntOfAnswers,
                    arrayOfIcons, arrayOfIconsImages)
            }
            5 -> {
                val subtestsTitles = arrayOf(binding.textSubtitle1, binding.textSubtitle2)
                val subtestsDescriptions = arrayOf(binding.textDescription1, binding.textDescription2)
                val subtestsCntOfAnswers = arrayOf(binding.cntOfAnswers1, binding.cntOfAnswers2)
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.drawable.pic1, R.drawable.pic1)
                setViewForChooseTest("Психодиагностика", 2, subtestsTitles,
                    subtestsDescriptions, subtestsCntOfAnswers,
                    arrayOfIcons, arrayOfIconsImages)
            }
        }
        setContentView(binding.root)
    }

    private fun setViewForChooseTest(
        title: String, countOfTests: Int,
        subtestsTitles: Array<TextView>,
        subtestsDescriptions: Array<TextView>,
        subtestsCntOfAnswers: Array<TextView>,
        subtestsIcons: Array<ImageView>,
        iconsImages: Array<Int>,
    ) {
        binding.textTitle.text = title
        fillChooseTest(getFilesNamesWithTestsComponents(), countOfTests,
            subtestsTitles, subtestsDescriptions, subtestsCntOfAnswers, subtestsIcons, iconsImages)
    }

    private fun getFilesNamesWithTestsComponents(): Array<String> {
        var result: Array<String> = emptyArray()
        when (intent.getIntExtra("codesOfTests", 0)) {
            0 -> {
                result = arrayOf("character_test_detail.xml", "character_test2_detail.xml")
            }
            1 -> {
                result = arrayOf("character_test_detail.xml", "character_test_detail.xml")
            }
            2 -> {
                result = arrayOf("career_test_detail.xml", "career_test2_detail.xml")
            }
            3 -> {
                result = arrayOf("mental_test_detail.xml", "character_test_detail.xml")
            }
            4 -> {
                result = arrayOf("family_test_detail.xml", "character_test_detail.xml")
            }
            5 -> {
                result = arrayOf("psychodiagnostics_test_detail.xml", "psychodiagnostics_test2_detail.xml")
            }
        }
        return result
    }

    @SuppressLint("SetTextI18n")
    private fun fillChooseTest(
        fileNameOfTestComponents: Array<String>,
        countOfTests: Int, title: Array<TextView>,
        description: Array<TextView>,
        cntOfQuestions: Array<TextView>,
        icon: Array<ImageView>,
        iconImage: Array<Int>,
    ) {
        // заполняем активити поочередно, начиная с первого подтеста и заканчивая последним подтестом
        var testQuestion = parseSubtitlesDescriptionsAndCntOfQuestions(fileNameOfTestComponents[0])!!
        title[0].text = testQuestion.title
        description[0].text = testQuestion.description
        cntOfQuestions[0].text = binding.cntOfAnswers1.text.substring(0..15) + testQuestion.countQuestions
        try {
            icon[0].setImageResource(iconImage[0])
        } catch (ex: IOException) {
            return
        }
        for (i in 1 until countOfTests) {
                testQuestion = parseSubtitlesDescriptionsAndCntOfQuestions(fileNameOfTestComponents[i])!!
                title[i].text = testQuestion.title
                description[i].text = testQuestion.description
                cntOfQuestions[i].text = binding.cntOfAnswers1.text.substring(0..15) + testQuestion.countQuestions
                try {
                    icon[i].setImageResource(iconImage[i])
                } catch (ex: IOException) {
                    return
                }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun parseSubtitlesDescriptionsAndCntOfQuestions(fileNameOfTestComponents: String): TestInfo? {
        return tryToParseForChooseTest(fileNameOfTestComponents)
    }

    private fun tryToParseForChooseTest(fileNameFromAssets: String): TestInfo? {
        var result: TestInfo? = null
        try {
            val parser = XmlPullParserHandler()
            val istream = assets.open(fileNameFromAssets)
            val testQuestion = parser.parseForChooseTest(istream)
            result = testQuestion
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return result
    }

    private fun setListeners() {
        val testCode = intent.getIntExtra("codesOfTests", 0)
        when (testCode) {
            /*  Кодировка тестов
                0 - Тесты про характер
                1 - Тесты про жизнь
                2 - Тесты про карьеру
                3 - Тесты про умственные
                4 - Тесты про семья
                5 - Тесты про психодиагностику */
            0 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}1")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}2")
                    startActivity(intent)
                }
            }
            1 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}1")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}2")
                    startActivity(intent)
                }
            }
            2 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}1")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}2")
                    startActivity(intent)
                }
            }
            3 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}1")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}2")
                    startActivity(intent)
                }
            }
            4 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}1")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}2")
                    startActivity(intent)
                }
            }
            5 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}1")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}2")
                    startActivity(intent)
                }
            }
        }
    }
}