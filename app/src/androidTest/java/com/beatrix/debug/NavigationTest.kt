package com.beatrix.debug

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.beatrix.debug.views.MainActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class NavigationTest {

    @Test
    fun testDashboardNavigation() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        // Navigate to expenses
        onView(withId(R.id.buttonExpenses)).perform(click())
        // Check if it opens correct activity
        onView(withId(R.id.expenses)).check(matches(isDisplayed()))
        // return back to dashboard
        pressBack()
        // Check if we are back at dashboard activity
        onView(withId(R.id.dashboardLayout)).check(matches(isDisplayed()))
        // Navigate to exchange
        onView(withId(R.id.buttonCurrency)).perform(click())
        // Check if it opens correct activity
        onView(withId(R.id.exchange)).check(matches(isDisplayed()))

    }
}