package com.beatrix.debug.mvp.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.beatrix.debug.R
import com.beatrix.debug.databinding.ActivityMainBinding
import com.beatrix.debug.mvp.views.fragments.DashboardFragment
import com.beatrix.debug.mvp.views.fragments.InfoFragment
import com.beatrix.debug.mvp.views.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val dashboardFragment = DashboardFragment()
    private val infoFragment = InfoFragment()
    private val settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        replaceFragment(dashboardFragment)

        bottomNavigationBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_dashboard -> replaceFragment(dashboardFragment)
                R.id.ic_settings -> replaceFragment(settingsFragment)
                R.id.ic_info -> replaceFragment(infoFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
}