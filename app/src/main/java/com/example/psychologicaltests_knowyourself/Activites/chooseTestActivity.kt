package com.example.psychologicaltests_knowyourself.Activites


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.psychologicaltests_knowyourself.databinding.*

class chooseTestActivity : AppCompatActivity() {

    private lateinit var bindingCharacter : ActivityChooseTestCharacterBinding
    private lateinit var bindingLife : ActivityChooseTestLifeBinding
    private lateinit var bindingCareer : ActivityChooseTestOfCareerBinding
    private lateinit var bindingMental : ActivityChooseTestOfMentalBinding
    private lateinit var bindingFamily : ActivityChooseTestOfFamilyBinding
    private lateinit var bindingSex : ActivityChooseTestSexBinding
    private lateinit var bindingPsychodiagnostics : ActivityChooseTestOfPsychodiagnosticsBinding


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
        when(testCode){

            //________________________________Отрисовка тестов с Характером_______________________________________________

            0 -> {bindingCharacter = ActivityChooseTestCharacterBinding.inflate(layoutInflater)
                setContentView(bindingCharacter.root)
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Отрисовка тестов с Жизнью_____________________________________________________

            1 -> {
                bindingLife = ActivityChooseTestLifeBinding.inflate(layoutInflater)
                setContentView(bindingLife.root)
            }

            //-------------------------------------------------------------------------------------------------------------



            //______________________________Отрисовка тестов с Карьерой_____________________________________________________

            2 -> {
                bindingCareer = ActivityChooseTestOfCareerBinding.inflate(layoutInflater)
                setContentView(bindingCareer.root)
            }

            //-------------------------------------------------------------------------------------------------------------




            //______________________________Отрисовка тестов с Умственными_________________________________________________

            3 -> {
                bindingMental = ActivityChooseTestOfMentalBinding.inflate(layoutInflater)
                setContentView(bindingMental.root)
            }

            //-------------------------------------------------------------------------------------------------------------




            //______________________________Отрисовка тестов с Семьей_____________________________________________________

            4 -> {
                bindingFamily = ActivityChooseTestOfFamilyBinding.inflate(layoutInflater)
                setContentView(bindingFamily.root)
            }

            //-------------------------------------------------------------------------------------------------------------




            //______________________________Отрисовка тестов с Сексом_____________________________________________________

            5 -> {
                bindingSex = ActivityChooseTestSexBinding.inflate(layoutInflater)
                setContentView(bindingSex.root)
            }

            //-------------------------------------------------------------------------------------------------------------




            //______________________________Отрисовка тестов с Психодиагностикой____________________________________________

            6 -> {
                bindingPsychodiagnostics = ActivityChooseTestOfPsychodiagnosticsBinding.inflate(layoutInflater)
                setContentView(bindingPsychodiagnostics.root)
            }

            //________________________________________________________________________________________________________________
        }
    }

    private fun setListeners() {
        val testCode = intent.getIntExtra("codesOfTests", 0)
        when (testCode) {

            //_______________________________Нажатия клавишь в Характере_____________________________________________________

            0 -> {
                bindingCharacter.imageBack.setOnClickListener {
                    onBackPressed()
                }
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Нажатие клавишь в Жизни_____________________________________________________

            1 -> {
                bindingLife . imageBack . setOnClickListener {
                    onBackPressed()
                }
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Нажатие клавишь в Карьере_____________________________________________________

            2 -> {
                bindingCareer.imageBack.setOnClickListener {
                    onBackPressed()
                }
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Нажатие клавишь в Умственном_____________________________________________________

            3 -> {
                bindingMental . imageBack . setOnClickListener {
                    onBackPressed()
                }
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Нажатие клавишь в Семье_____________________________________________________

            4 -> {
                bindingFamily . imageBack . setOnClickListener {
                    onBackPressed()
                }
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Нажатие клавишь в Сексе_____________________________________________________

            5 -> {
                bindingSex . imageBack . setOnClickListener {
                    onBackPressed()
                }
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Нажатие клавишь в Псизодиагностики___________________________________________

            6 -> {
                bindingPsychodiagnostics . imageBack . setOnClickListener {
                    onBackPressed()
                }
            }

            //_____________________________________________________________________________________________________________
        }
    }
}