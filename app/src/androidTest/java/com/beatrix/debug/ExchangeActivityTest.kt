package com.beatrix.debug

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.beatrix.debug.views.ExchangeActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class ExchangeActivityTest {
    @get: Rule
     val activityRule = ActivityScenarioRule(ExchangeActivity::class.java)

    @Test
    fun testIsActivityInView() {
        Espresso.onView(ViewMatchers.withId(R.id.exchange))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}