package com.example.psychologicaltests_knowyourself.Activites

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.psychologicaltests_knowyourself.databinding.*

class TestActivity : AppCompatActivity() {

    private var countOfOptions: Int = 2
    private var numberOfCurrentTest = 1

    private lateinit var bindingCharacter: ActivityTestCharacterBinding
    private lateinit var bindingLife: ActivityTestLifeBinding
    private lateinit var bindingCareer: ActivityTestCareerBinding
    private lateinit var bindingMental: ActivityTestMentalBinding
    private lateinit var bindingFamily: ActivityTestFamilyBinding
    private lateinit var bindingSex: ActivityTestSexBinding
    private lateinit var bindingPsychodiagnostics: ActivityTestPsychodiagnosticsBinding

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
        when (testCode) {

            //________________________________Отрисовка тестов с Характером_______________________________________________

            0 -> {bindingCharacter = ActivityTestCharacterBinding.inflate(layoutInflater)
                setContentView(bindingCharacter.root)
                builderOfSubtest()
                Log.e("TAG", "0 when")
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Отрисовка тестов с Жизнью_____________________________________________________

            1 -> {
                bindingLife = ActivityTestLifeBinding.inflate(layoutInflater)
                setContentView(bindingLife.root)
                builderOfSubtest()
                Log.e("TAG", "1 when")
            }

            //-------------------------------------------------------------------------------------------------------------



            //______________________________Отрисовка тестов с Карьерой_____________________________________________________

            2 -> {
                bindingCareer = ActivityTestCareerBinding.inflate(layoutInflater)
                setContentView(bindingCareer.root)
                builderOfSubtest()
                Log.e("TAG", "2 when")
            }

            //-------------------------------------------------------------------------------------------------------------




            //______________________________Отрисовка тестов с Умственными_________________________________________________

            3 -> {
                bindingMental = ActivityTestMentalBinding.inflate(layoutInflater)
                setContentView(bindingMental.root)
                builderOfSubtest()
            }

            //-------------------------------------------------------------------------------------------------------------




            //______________________________Отрисовка тестов с Семьей_____________________________________________________

            4 -> {
                bindingFamily = ActivityTestFamilyBinding.inflate(layoutInflater)
                setContentView(bindingFamily.root)
                builderOfSubtest()
            }

            //-------------------------------------------------------------------------------------------------------------




            //______________________________Отрисовка тестов с Сексом_____________________________________________________

            5 -> {
                bindingSex = ActivityTestSexBinding.inflate(layoutInflater)
                setContentView(bindingSex.root)
                builderOfSubtest()
            }

            //-------------------------------------------------------------------------------------------------------------




            //______________________________Отрисовка тестов с Психодиагностикой____________________________________________

            6 -> {
                bindingPsychodiagnostics = ActivityTestPsychodiagnosticsBinding.inflate(layoutInflater)
                setContentView(bindingPsychodiagnostics.root)
                builderOfSubtest()
            }

            //________________________________________________________________________________________________________________
        }
    }


    @SuppressLint("SetTextI18n")
    private fun builderOfSubtest() {
        val subtestCode = intent.getStringExtra("codesOfSubtests")
        Log.e("TAG", subtestCode.toString())
        when (subtestCode) {

            //                              Кодировка тестов
            //  0* - Тесты про характер           |      * - номер теста
            //  1* - Тесты про жизнь              |
            //  2* - Тесты про карьеру            |
            //  3* - Тесты про умственные         |
            //  4* - Тесты про семья              |
            //  5* - Тесты про секс               |
            //  6* - Тесты про психодиагностику   |

            "01" -> {
                val countQuestions = 30
                countOfOptions = 3
                bindingCharacter.textTitle.text = "Пять черт характера"
                bindingCharacter.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptions()
            }
            "02" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingCharacter.textTitle.text = "Характер топ"
                bindingCharacter.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptions()
            }
            "11" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingLife.textTitle.text = "Тест 1 по теме жизнь"
                bindingLife.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptions()
                Log.e("TAG", "11 when")
            }
            "12" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingLife.textTitle.text = "Тест 2 по теме жизнь"
                bindingLife.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptions()
            }
            "21" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingCareer.textTitle.text = "Опросник уровня удовлетворенности работой"
                bindingCareer.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptions()
            }
            "22" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingCareer.textTitle.text = "Тест на трудоголизм. Диагностика уровня занятости и зависимости от работы."
                bindingCareer.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptions()
            }
            "31" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingMental.textTitle.text = "Тест 1 по теме умственные"
                bindingMental.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptions()
            }
        }
    }

    private fun countOptions() {
        when (countOfOptions) {
            2 -> {
                bindingCharacter.option3.visibility = View.GONE
                bindingCharacter.option4.visibility = View.GONE
                bindingCharacter.option5.visibility = View.GONE
                bindingCharacter.option6.visibility = View.GONE
            }
            3 -> {
                bindingCharacter.option4.visibility = View.GONE
                bindingCharacter.option5.visibility = View.GONE
                bindingCharacter.option6.visibility = View.GONE
            }
            4 -> {
                bindingCharacter.option5.visibility = View.GONE
                bindingCharacter.option6.visibility = View.GONE
            }
            5 -> {
                bindingCharacter.option6.visibility = View.GONE
            }
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
                bindingLife.imageBack.setOnClickListener {
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
                bindingMental.imageBack.setOnClickListener {
                    onBackPressed()
                }
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Нажатие клавишь в Семье_____________________________________________________

            4 -> {
                bindingFamily.imageBack.setOnClickListener {
                    onBackPressed()
                }
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Нажатие клавишь в Сексе_____________________________________________________

            5 -> {
                bindingSex.imageBack.setOnClickListener {
                    onBackPressed()
                }
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Нажатие клавишь в Псизодиагностики___________________________________________

            6 -> {
                bindingPsychodiagnostics.imageBack.setOnClickListener {
                    onBackPressed()
                }
            }

            //_____________________________________________________________________________________________________________
        }
    }
}