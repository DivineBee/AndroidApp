package com.beatrix.debug.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.beatrix.debug.ExchangeActivity
import com.beatrix.debug.MainActivity
import com.beatrix.debug.R
import com.beatrix.debug.SecondActivity
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val buttonExpenses = view.findViewById<Button>(R.id.buttonExpenses)
        val buttonCurrency = view.findViewById<Button>(R.id.buttonCurrency)

        buttonExpenses.setOnClickListener{
            val intent = Intent(activity, SecondActivity::class.java)
            startActivity(intent)
        }

        buttonCurrency.setOnClickListener{
            val intent = Intent(activity, ExchangeActivity::class.java)
            startActivity(intent)
        }
        // Inflate the layout for this fragment
        return view
    }

}