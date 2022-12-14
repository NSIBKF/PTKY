package com.example.psychologicaltests_knowyourself.activities

import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class XmlPullParserHandler {
    private var testInfo: TestInfo? = null
    private var text: String? = null
    // доработать парсер для имен файлов с компонентами и сам файл
/*
    fun parseNameOfFilesWithTestsComponents(inputStream: InputStream): TestQuestion {
        try {
            val factory = XmlPullParserFactory.newInstance()
            // we set mode that says what we'll going to read XML files
            factory.isNamespaceAware = true
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            testQuestion = TestQuestion()
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name
                when (eventType) {
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> if (tagName.equals("cnt_questions", ignoreCase = true)) {
                        testQuestion!!.countQuestions = text!!.toInt()
                    } else if (tagName.equals("title", ignoreCase = true)) {
                        testQuestion!!.title = text
                    } else if (tagName.equals("description", ignoreCase = true)) {
                        testQuestion!!.description = text
                        break
                    }
                }
                eventType = parser.next()
            }
        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return testQuestion!!
    }

 */

    fun parseForChooseTest(inputStream: InputStream): TestInfo {
        try {
            val factory = XmlPullParserFactory.newInstance()
            // we set mode that says what we'll going to read XML files
            factory.isNamespaceAware = true
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            testInfo = TestInfo()
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name
                when (eventType) {
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> if (tagName.equals("cnt_questions", ignoreCase = true)) {
                            testInfo!!.countQuestions = text!!.toInt()
                        } else if (tagName.equals("title", ignoreCase = true)) {
                            testInfo!!.title = text
                        } else if (tagName.equals("description", ignoreCase = true)) {
                            testInfo!!.description = text
                            break
                        }
                    }
                eventType = parser.next()
            }
        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return testInfo!!
    }

    fun parseForTest(inputStream: InputStream, questionId: Int): TestInfo {
        try {
            var optionId = 0
            var answerInd = 0
            val factory = XmlPullParserFactory.newInstance()
            // we set mode that says what we'll going to read XML files
            factory.isNamespaceAware = true
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            testInfo = TestInfo()
            /* сделать так, чтобы индекс ответа не был ключевым условием */
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name
                when (eventType) {
                    XmlPullParser.START_TAG -> if (tagName.equals("option", ignoreCase = true)) {
                        ++optionId
                    }
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> if (optionId == questionId) {
                        if (tagName.equals("question$questionId", ignoreCase = true)) {
                            // add employee object to list
                            testInfo!!.question = text
                        } else if (tagName.equals("answer", ignoreCase = true)) {
                            testInfo!!.listOfAnswers.add(answerInd, text!!)
                            ++answerInd
                        }
                    } else if (optionId == 0) {
                        if (tagName.equals("cnt_answers", ignoreCase = true)) {
                            testInfo!!.countAnswers = text!!.toInt()
                        } else if (tagName.equals("cnt_questions", ignoreCase = true)) {
                            testInfo!!.countQuestions = text!!.toInt()
                        } else if (tagName.equals("title", ignoreCase = true)) {
                            testInfo!!.title = text
                        }
                    } else if (tagName.equals("option", ignoreCase = true) && optionId == questionId) {
                        break
                    }
                }
                eventType = parser.next()
            }
        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return testInfo!!
    }
}