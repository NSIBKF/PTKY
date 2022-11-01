package com.example.psychologicaltests_knowyourself.Activites


import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.psychologicaltests_knowyourself.R
import com.example.psychologicaltests_knowyourself.databinding.*
import de.hdodenhof.circleimageview.CircleImageView
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
                val arrayOfTexts = arrayOf(binding.textTest1, binding.textTest2)
                val arrayOfTextsStrings = arrayOf("Характер", "Пять черт характера")
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.mipmap.ic_launcher, R.drawable.ic_test2_of_character)
                setViewForChooseTest("Характер", 2, arrayOfTexts,
                arrayOfTextsStrings, arrayOfIcons, arrayOfIconsImages)
            }
            1 -> {
                val arrayOfTexts = arrayOf(binding.textTest1, binding.textTest2)
                val arrayOfTextsStrings = arrayOf("Характер", "Пять черт характера")
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.mipmap.ic_launcher, R.drawable.ic_test2_of_character)
                setViewForChooseTest("Жизнь", 2, arrayOfTexts,
                    arrayOfTextsStrings, arrayOfIcons, arrayOfIconsImages)
            }
            2 -> {
                val arrayOfTexts = arrayOf(binding.textTest1, binding.textTest2)
                val arrayOfTextsStrings = arrayOf("Характер", "Пять черт характера")
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.mipmap.ic_launcher, R.drawable.ic_test2_of_character)
                setViewForChooseTest("Карьера", 2, arrayOfTexts,
                    arrayOfTextsStrings, arrayOfIcons, arrayOfIconsImages)
            }
            3 -> {
                val arrayOfTexts = arrayOf(binding.textTest1, binding.textTest2)
                val arrayOfTextsStrings = arrayOf("Характер", "Пять черт характера")
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.mipmap.ic_launcher, R.drawable.ic_test2_of_character)
                setViewForChooseTest("Умственные", 2, arrayOfTexts,
                    arrayOfTextsStrings, arrayOfIcons, arrayOfIconsImages)
            }
            4 -> {
                val arrayOfTexts = arrayOf(binding.textTest1, binding.textTest2)
                val arrayOfTextsStrings = arrayOf("Характер", "Пять черт характера")
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.mipmap.ic_launcher, R.drawable.ic_test2_of_character)
                setViewForChooseTest("Семья", 2, arrayOfTexts,
                    arrayOfTextsStrings, arrayOfIcons, arrayOfIconsImages)
            }
            5 -> {
                val arrayOfTexts = arrayOf(binding.textTest1, binding.textTest2)
                val arrayOfTextsStrings = arrayOf("Характер", "Пять черт характера")
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.mipmap.ic_launcher, R.drawable.ic_test2_of_character)
                setViewForChooseTest("Психодиагностика", 2, arrayOfTexts,
                    arrayOfTextsStrings, arrayOfIcons, arrayOfIconsImages)
            }
        }
        setContentView(binding.root)
    }

    private fun setViewForChooseTest(
        title: String, countOfTests: Int,
        arrayOfTexts: Array<TextView>,
        arrayOfTextsStrings: Array<String>,
        arrayOfIcons: Array<CircleImageView>,
        arrayOfIconsImages: Array<Int>
    ) {
        binding.textTitle.text = title
        for (i in 0 until countOfTests) {
            arrayOfTexts[i].text = arrayOfTextsStrings[i]
            try {
                arrayOfIcons[i].setImageResource(arrayOfIconsImages[i])
            } catch (ex: IOException) {
                return
            }
        }
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
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}1")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}2")
                    startActivity(intent)
                }
            }
            1 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}1")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}2")
                    startActivity(intent)
                }
            }
            2 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}1")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}2")
                    startActivity(intent)
                }
            }
            3 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}1")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}2")
                    startActivity(intent)
                }
            }
            4 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}1")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}2")
                    startActivity(intent)
                }
            }
            5 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}1")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "${testCode}2")
                    startActivity(intent)
                }
            }
        }
    }
}