package com.beatrix.debug

import com.beatrix.debug.models.ExchangeViewModel
import com.beatrix.debug.repo.ExchangeRepository
import com.beatrix.debug.utils.DispatcherProvider
import com.beatrix.debug.utils.Expenses
import org.hamcrest.core.Is.`is`
import org.junit.Test

import org.junit.Assert.*

class PresenterUnitTest {

    lateinit var exchangeModel: ExchangeViewModel
    lateinit var repository: ExchangeRepository
    lateinit var dispatchers: DispatcherProvider

    lateinit var expensesList: ArrayList<Expenses>

    @Test
    fun isOutputCorrect() {
        //exchangeModel = ExchangeViewModel(repository, dispatchers).convert("34.7", "EUR", "USD")
        val result = exchangeModel.convert("34.7", "EUR", "USD")
        assertEquals("45.6", result)
    }

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

    @Test
    fun compareTwoDifferentItemsPassedToRecyclerView(){
        expensesList = ArrayList()

        fun addExpenses(){
            expensesList.add(Expenses("34.54", 0.0, "Bought food for a week", R.drawable.food))
            expensesList.add(Expenses("36.54", 432.54, "Bought food for a month", R.drawable.food))
        }

        addExpenses()
        assertNotEquals(expensesList.get(0), `is`(expensesList.get(1)))
    }
}