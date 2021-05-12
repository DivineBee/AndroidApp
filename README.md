# LAB 5

University: Technical University of Moldova  
Specialty: Software Engineering  
Group: FAF-182
Object: Mobile Application Programming  
Teacher: Alexandr Vdovicenco  
Student: Vizant Beatrice  
## Technologies and language used:  
* Android   
* Kotlin   
* Retrofit  
* Dagger-Hilt  
* Data-binding  
* JUnit & Espresso

## Explanation:  
During this laboratory work, we had to implement tests in order to see if the application behaves as expected. First thing was documenting myself about types of tests, why and how they are used and also about what dependencies are needed in order to run the tests. In an Android project we have 3 packages with the same name but with different rules.  
First is the package where all the code is written. The remaining two are related to tests. One is responsible for the local unit tests (tests that run on local machine), these tests minimize execution time when tests have no Android framework dependencies or when we can mock them. The other one is instrumented test, this runs on hardware device or emulator and gives access to information such as Context of the app, and lets us to control the app from the test code. Tests written as instrumented once allows to automate user interaction or funtional UI.  
I started by implementing instrumented tests, I made 5 tests regarding it. One of them is _NavigationTest_ through which I tested the navigation from the dashboard to the available buttons which opens up new activity. Because the Dashboard is a fragment and the windows which appear after clicking on a button are activities, I had to document myself about how to do it right and have the test pass seamless. The other UI tests are about visibility and display check for 2 of existing activities _DashboardTest_ & _ExchangeActivityTest_. Example of implemented UI tests are shown below:  
```kotlin
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
```  
The next type of tests were the unit tests, which role I described earlier. I made 4 of them. Some are responsible for testing the recycler view and what's add to that, other one is responsible for the checking of currency conversion and the last one is about checking the correct rates. Example of unit test:  
```kotlin
@Test
    fun sameItemsPassedToRecyclerView(){
        expensesList = ArrayList()

        fun addExpenses(){
            expensesList.add(Expenses("34.54", 0.0, "Bought food for a week", R.drawable.food))
            expensesList.add(Expenses("34.54", 0.0, "Bought food for a week", R.drawable.food))
        }

        addExpenses()
        assertThat(expensesList.get(0), `is`(expensesList.get(1)))
    }
```  
## Passed Tests Proofs


## Status  
_FINISHED_
