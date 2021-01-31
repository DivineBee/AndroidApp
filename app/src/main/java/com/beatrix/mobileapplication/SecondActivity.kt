package com.beatrix.mobileapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_second.*

private const val TAG = "MainActivity"
private const val TEXT_CONTENTS = "TextContent"

class SecondActivity : AppCompatActivity() {
    private var secondDescr: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate 2: called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = getIntent()
        val dateNumber = intent.getIntExtra("Number", 0)

        if (dateNumber != null) {
            val temp = dateNumber * 100
            starNumber.text = (temp..3200).random().toString()
        }
        //starNumber.text = dateNumber.toString()
    }

    fun onBackPressed(view: View) {
        Log.d(TAG, "onBack: called")
        var luckyNumber = "Your lucky number is: ${starNumber.text.toString()}"

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("luckyNumber", luckyNumber)
        startActivity(intent)
    }

    override fun onStart() {
        Log.d(TAG, "onStart 2: called")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState 2: called")
        super.onRestoreInstanceState(savedInstanceState)
        secondDescr?.text = savedInstanceState?.getString(TEXT_CONTENTS, "")
    }

    override fun onResume() {
        Log.d(TAG, "onResume 2: called")
        super.onResume()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy 2: called")
        super.onDestroy()
    }

    override fun onPause() {
        Log.d(TAG, "onPause 2: called")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState 2: called")
        super.onSaveInstanceState(outState)
        outState?.putString(TEXT_CONTENTS, secondDescr?.text.toString())
    }

    override fun onStop() {
        Log.d(TAG, "onStop 2: called")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart 2: called")
        super.onRestart()
    }
}