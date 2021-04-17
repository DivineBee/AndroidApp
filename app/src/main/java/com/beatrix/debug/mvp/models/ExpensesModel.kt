package com.beatrix.debug.mvp.models

import com.beatrix.debug.utils.Expenses
import com.beatrix.debug.R
import com.beatrix.debug.mvp.contract.ExpensesContractInterface

class ExpensesModel: ExpensesContractInterface.Model {

    lateinit var expensesList: ArrayList<Expenses>

    override fun addExpenses(){
        expensesList.add(Expenses("FOOD", 300.50, "Bought food for a week", R.drawable.food))
        expensesList.add(Expenses("CLOTHES", 900.24, "New dress and a belt", R.drawable.clothes))
        expensesList.add(Expenses("BEAUTY", 340.00, "Vichy cream", R.drawable.beauty))
        expensesList.add(Expenses("BILLS", 140.50, "Paid for water and gas", R.drawable.bills))
        expensesList.add(Expenses("CAR", 500.00, "Fueled the car", R.drawable.car))
        expensesList.add(Expenses("DETERGENTS", 235.45, "Detergents for clothes", R.drawable.detergents))
    }

}