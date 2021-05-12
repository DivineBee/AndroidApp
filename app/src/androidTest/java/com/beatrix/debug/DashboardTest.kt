package com.beatrix.debug

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.beatrix.debug.views.MainActivity

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DashboardTest {
    @Test
    fun testMainActivity() {
        // check if the right activity is displayed
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.mainLayout)).check(matches(isDisplayed()))
    }

    @Test
    fun testVisibilityOfComponents() {
        // check the visibility of layout components
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.buttonExpenses)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonWallet)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonAnalysis)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonCurrency)).check(matches(isDisplayed()))
        onView(withId(R.id.textMoney)).check(matches(isDisplayed()))
    }

    @Test
    fun testIsDisplayed() {
        // check if the title is correct
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.textMoney)).check(matches(withText("MONEY MANAGER")))
    }
}