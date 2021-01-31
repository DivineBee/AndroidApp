package com.beatrix.mobileapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"
private const val TEXT_CONTENTS = "TextContent"

class MainActivity : AppCompatActivity() {
    private var plainDescr: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = getIntent()
        var values: String = ""

        val lucky = if (intent.getStringExtra("luckyNumber") == null) ""
        else intent.getStringExtra("luckyNumber")

        luckyNumber.text = lucky.toString()
    }

    fun onOkButtonClick(view: View) {
        Log.d(TAG, "onClick: called")

        val dateNumber = birthNumber.text.toString().toInt()

        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        intent.putExtra("Number", dateNumber)
        startActivity(intent)
    }

    override fun onStart() {
        Log.d(TAG, "onStart: called")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState: called")
        super.onRestoreInstanceState(savedInstanceState)
//        val savedString = savedInstanceState?.getString(TEXT_CONTENTS, "")
//        textView?.text = savedString
        plainDescr?.text = savedInstanceState?.getString(TEXT_CONTENTS, "")
    }

    override fun onResume() {
        Log.d(TAG, "onResume: called")
        super.onResume()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: called")
        super.onDestroy()
    }

    override fun onPause() {
        Log.d(TAG, "onPause: called")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState: called")
        super.onSaveInstanceState(outState)
        outState?.putString(TEXT_CONTENTS, plainDescr?.text.toString())
    }

    override fun onStop() {
        Log.d(TAG, "onStop: called")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart: called")
        super.onRestart()
    }
}