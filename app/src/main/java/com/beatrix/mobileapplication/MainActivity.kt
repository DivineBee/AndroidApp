package com.beatrix.mobileapplication

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.beatrix.debug.fragments.DashboardFragment
import com.beatrix.debug.fragments.InfoFragment
import com.beatrix.debug.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.annotations.NotNull

class MainActivity : AppCompatActivity() {

    private val dashboardFragment = DashboardFragment()
    private val infoFragment = InfoFragment()
    private val settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(dashboardFragment)

        bottomNavigationBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_dashboard -> replaceFragment(dashboardFragment)
                R.id.ic_settings -> replaceFragment(settingsFragment)
                R.id.ic_info -> replaceFragment(infoFragment)
            }
            true
        }

       /* val buttonExpenses = findViewById<Button>(R.id.buttonExpenses)
        val buttonCurrency = findViewById<Button>(R.id.buttonCurrency)

        buttonExpenses.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            // val intent = Intent(parent , SecondActivity::class.java)
            startActivity(intent)
        }

        buttonCurrency.setOnClickListener {
            val intent = Intent(this, ExchangeActivity::class.java)
            startActivity(intent)
        }*/
    }

    private fun replaceFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, fragment)
                commit()
            }
}