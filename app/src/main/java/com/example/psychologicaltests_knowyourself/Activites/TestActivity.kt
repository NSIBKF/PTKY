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
            }

            //_____________________________________________________________________________________________________________



            //_______________________________Отрисовка тестов с Жизнью_____________________________________________________

            1 -> {
                bindingLife = ActivityTestLifeBinding.inflate(layoutInflater)
                setContentView(bindingLife.root)
                builderOfSubtest()
            }

            //-------------------------------------------------------------------------------------------------------------



            //______________________________Отрисовка тестов с Карьерой_____________________________________________________

            2 -> {
                bindingCareer = ActivityTestCareerBinding.inflate(layoutInflater)
                setContentView(bindingCareer.root)
                builderOfSubtest()
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
                Log.e("TAG", "Test_6_when")
            }

            //________________________________________________________________________________________________________________
        }
    }


    @SuppressLint("SetTextI18n")
    private fun builderOfSubtest() {
        val subtestCode = intent.getStringExtra("codesOfSubtests")
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
                countOptionsCharacter()
            }
            "02" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingCharacter.textTitle.text = "Характер топ"
                bindingCharacter.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptionsCharacter()
            }
            "11" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingLife.textTitle.text = "Тест 1 по теме жизнь"
                bindingLife.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptionsLife()
            }
            "12" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingLife.textTitle.text = "Тест 2 по теме жизнь"
                bindingLife.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptionsLife()
            }
            "21" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingCareer.textTitle.text = "Опросник уровня удовлетворенности работой"
                bindingCareer.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptionsCareer()
            }
            "22" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingCareer.textTitle.text = "Тест на трудоголизм. Диагностика уровня занятости и зависимости от работы."
                bindingCareer.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptionsCareer()
            }
            "31" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingMental.textTitle.text = "Тест 1 по теме умственные"
                bindingMental.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptionsMental()
            }
            "32" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingMental.textTitle.text = "Тест 2 по теме умственные"
                bindingMental.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptionsMental()
            }
            "41" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingFamily.textTitle.text = "Тест 1 по теме семья"
                bindingFamily.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptionsFamily()
            }
            "42" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingFamily.textTitle.text = "Тест 2 по теме семья"
                bindingFamily.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptionsFamily()
            }
            "51" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingSex.textTitle.text = "Тест 1 по теме секс"
                bindingSex.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptionsSex()
            }
            "52" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingSex.textTitle.text = "Тест 2 по теме секс"
                bindingSex.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptionsSex()
            }
            "61" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingPsychodiagnostics.textTitle.text = "Тест 1 по теме психодиагностика"
                bindingPsychodiagnostics.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptionsPsychodiagnostics()
            }
            "62" -> {
                val countQuestions = 45
                countOfOptions = 4
                bindingPsychodiagnostics.textTitle.text = "Тест 2 по теме психодиагностика"
                bindingPsychodiagnostics.textNumberQuestion.text = "$numberOfCurrentTest/$countQuestions"
                countOptionsPsychodiagnostics()
            }
        }
    }

    private fun countOptionsCharacter() {
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

    private fun countOptionsLife() {
        when (countOfOptions) {
            2 -> {
                bindingLife.option3.visibility = View.GONE
                bindingLife.option4.visibility = View.GONE
                bindingLife.option5.visibility = View.GONE
                bindingLife.option6.visibility = View.GONE
            }
            3 -> {
                bindingLife.option4.visibility = View.GONE
                bindingLife.option5.visibility = View.GONE
                bindingLife.option6.visibility = View.GONE
            }
            4 -> {
                bindingLife.option5.visibility = View.GONE
                bindingLife.option6.visibility = View.GONE
            }
            5 -> {
                bindingLife.option6.visibility = View.GONE
            }
        }
    }

    private fun countOptionsCareer() {
        when (countOfOptions) {
            2 -> {
                bindingCareer.option3.visibility = View.GONE
                bindingCareer.option4.visibility = View.GONE
                bindingCareer.option5.visibility = View.GONE
                bindingCareer.option6.visibility = View.GONE
            }
            3 -> {
                bindingCareer.option4.visibility = View.GONE
                bindingCareer.option5.visibility = View.GONE
                bindingCareer.option6.visibility = View.GONE
            }
            4 -> {
                bindingCareer.option5.visibility = View.GONE
                bindingCareer.option6.visibility = View.GONE
            }
            5 -> {
                bindingCareer.option6.visibility = View.GONE
            }
        }
    }

    private fun countOptionsMental() {
        when (countOfOptions) {
            2 -> {
                bindingMental.option3.visibility = View.GONE
                bindingMental.option4.visibility = View.GONE
                bindingMental.option5.visibility = View.GONE
                bindingMental.option6.visibility = View.GONE
            }
            3 -> {
                bindingMental.option4.visibility = View.GONE
                bindingMental.option5.visibility = View.GONE
                bindingMental.option6.visibility = View.GONE
            }
            4 -> {
                bindingMental.option5.visibility = View.GONE
                bindingMental.option6.visibility = View.GONE
            }
            5 -> {
                bindingMental.option6.visibility = View.GONE
            }
        }
    }

    private fun countOptionsFamily() {
        when (countOfOptions) {
            2 -> {
                bindingFamily.option3.visibility = View.GONE
                bindingFamily.option4.visibility = View.GONE
                bindingFamily.option5.visibility = View.GONE
                bindingFamily.option6.visibility = View.GONE
            }
            3 -> {
                bindingFamily.option4.visibility = View.GONE
                bindingFamily.option5.visibility = View.GONE
                bindingFamily.option6.visibility = View.GONE
            }
            4 -> {
                bindingFamily.option5.visibility = View.GONE
                bindingFamily.option6.visibility = View.GONE
            }
            5 -> {
                bindingFamily.option6.visibility = View.GONE
            }
        }
    }

    private fun countOptionsSex() {
        when (countOfOptions) {
            2 -> {
                bindingSex.option3.visibility = View.GONE
                bindingSex.option4.visibility = View.GONE
                bindingSex.option5.visibility = View.GONE
                bindingSex.option6.visibility = View.GONE
            }
            3 -> {
                bindingSex.option4.visibility = View.GONE
                bindingSex.option5.visibility = View.GONE
                bindingSex.option6.visibility = View.GONE
            }
            4 -> {
                bindingSex.option5.visibility = View.GONE
                bindingSex.option6.visibility = View.GONE
            }
            5 -> {
                bindingSex.option6.visibility = View.GONE
            }
        }
    }

    private fun countOptionsPsychodiagnostics() {
        when (countOfOptions) {
            2 -> {
                bindingPsychodiagnostics.option3.visibility = View.GONE
                bindingPsychodiagnostics.option4.visibility = View.GONE
                bindingPsychodiagnostics.option5.visibility = View.GONE
                bindingPsychodiagnostics.option6.visibility = View.GONE
            }
            3 -> {
                bindingPsychodiagnostics.option4.visibility = View.GONE
                bindingPsychodiagnostics.option5.visibility = View.GONE
                bindingPsychodiagnostics.option6.visibility = View.GONE
            }
            4 -> {
                bindingPsychodiagnostics.option5.visibility = View.GONE
                bindingPsychodiagnostics.option6.visibility = View.GONE
            }
            5 -> {
                bindingPsychodiagnostics.option6.visibility = View.GONE
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
                //Тест нового активити
//                bindingCharacter.option1.setOnClickListener {
//                    startActivity(Intent(this, ResultActivity::class.java))
//                }
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