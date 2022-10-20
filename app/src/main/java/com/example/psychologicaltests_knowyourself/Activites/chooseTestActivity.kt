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

            //________________________________Отрисовка тестов с Характером_______________________________________________

            0 -> {
                //parse()
                val arrayOfTexts = arrayOf(binding.textTest1, binding.textTest2)
                val arrayOfTextsStrings = arrayOf("Характер", "Пять черт характера")
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.mipmap.ic_launcher, R.drawable.ic_test2_of_character)
                setViewForChooseTest("Характер", 2, arrayOfTexts,
                arrayOfTextsStrings, arrayOfIcons, arrayOfIconsImages)
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Отрисовка тестов с Жизнью_____________________________________________________

            1 -> {
                val arrayOfTexts = arrayOf(binding.textTest1, binding.textTest2)
                val arrayOfTextsStrings = arrayOf("Характер", "Пять черт характера")
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.mipmap.ic_launcher, R.drawable.ic_test2_of_character)
                setViewForChooseTest("Жизнь", 2, arrayOfTexts,
                    arrayOfTextsStrings, arrayOfIcons, arrayOfIconsImages)
            }

            //-------------------------------------------------------------------------------------------------------------



            //______________________________Отрисовка тестов с Карьерой_____________________________________________________

            2 -> {
                val arrayOfTexts = arrayOf(binding.textTest1, binding.textTest2)
                val arrayOfTextsStrings = arrayOf("Характер", "Пять черт характера")
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.mipmap.ic_launcher, R.drawable.ic_test2_of_character)
                setViewForChooseTest("Карьера", 2, arrayOfTexts,
                    arrayOfTextsStrings, arrayOfIcons, arrayOfIconsImages)
            }

            //-------------------------------------------------------------------------------------------------------------




            //______________________________Отрисовка тестов с Умственными_________________________________________________

            3 -> {
                val arrayOfTexts = arrayOf(binding.textTest1, binding.textTest2)
                val arrayOfTextsStrings = arrayOf("Характер", "Пять черт характера")
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.mipmap.ic_launcher, R.drawable.ic_test2_of_character)
                setViewForChooseTest("Умственные", 2, arrayOfTexts,
                    arrayOfTextsStrings, arrayOfIcons, arrayOfIconsImages)
            }

            //-------------------------------------------------------------------------------------------------------------




            //______________________________Отрисовка тестов с Семьей_____________________________________________________

            4 -> {
                val arrayOfTexts = arrayOf(binding.textTest1, binding.textTest2)
                val arrayOfTextsStrings = arrayOf("Характер", "Пять черт характера")
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.mipmap.ic_launcher, R.drawable.ic_test2_of_character)
                setViewForChooseTest("Семья", 2, arrayOfTexts,
                    arrayOfTextsStrings, arrayOfIcons, arrayOfIconsImages)
            }

            //-------------------------------------------------------------------------------------------------------------




            //______________________________Отрисовка тестов с Сексом_____________________________________________________

            5 -> {
                val arrayOfTexts = arrayOf(binding.textTest1, binding.textTest2)
                val arrayOfTextsStrings = arrayOf("Характер", "Пять черт характера")
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.mipmap.ic_launcher, R.drawable.ic_test2_of_character)
                setViewForChooseTest("Секс", 2, arrayOfTexts,
                    arrayOfTextsStrings, arrayOfIcons, arrayOfIconsImages)
            }

            //-------------------------------------------------------------------------------------------------------------




            //______________________________Отрисовка тестов с Психодиагностикой____________________________________________

            6 -> {
                val arrayOfTexts = arrayOf(binding.textTest1, binding.textTest2)
                val arrayOfTextsStrings = arrayOf("Характер", "Пять черт характера")
                val arrayOfIcons = arrayOf(binding.imageTest1, binding.imageTest2)
                val arrayOfIconsImages = arrayOf(R.mipmap.ic_launcher, R.drawable.ic_test2_of_character)
                setViewForChooseTest("Психодиагностика", 2, arrayOfTexts,
                    arrayOfTextsStrings, arrayOfIcons, arrayOfIconsImages)
            }

            //________________________________________________________________________________________________________________
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

            //_______________________________Нажатия клавишь в Характере_____________________________________________________

            0 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "01")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "02")
                    startActivity(intent)
                }
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Нажатие клавишь в Жизни_____________________________________________________

            1 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "01")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "02")
                    startActivity(intent)
                }
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Нажатие клавишь в Карьере_____________________________________________________

            2 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "01")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "02")
                    startActivity(intent)
                }
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Нажатие клавишь в Умственном_____________________________________________________

            3 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "01")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "02")
                    startActivity(intent)
                }
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Нажатие клавишь в Семье_____________________________________________________

            4 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "01")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "02")
                    startActivity(intent)
                }
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Нажатие клавишь в Сексе_____________________________________________________

            5 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "01")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "02")
                    startActivity(intent)
                }
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Нажатие клавишь в Псизодиагностики___________________________________________

            6 -> {
                binding.imageBack.setOnClickListener {
                    onBackPressed()
                }
                binding.test1.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "01")
                    startActivity(intent)
                }
                binding.test2.setOnClickListener {
                    val intent = Intent(this, TestDescriptionActivity::class.java)
                    intent.putExtra("codesOfSubtests", "02")
                    startActivity(intent)
                }
            }

            //_____________________________________________________________________________________________________________
        }
    }
}