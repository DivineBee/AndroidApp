package com.beatrix.mobileapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.beatrix.debug.*
import com.beatrix.debug.databinding.ActivitySecondBinding
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), OnExpensesDetailsClickListener {

    lateinit var binding: ActivitySecondBinding
    lateinit var expensesList: ArrayList<Expenses>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        expensesList = ArrayList()
        addExpenses()

        expensesRecycler.layoutManager = LinearLayoutManager(this)
        expensesRecycler.addItemDecoration(DividerItemDecoration(this, 1))
        expensesRecycler.adapter = ExpensesAdapter(expensesList, this)
    }

    fun addExpenses(){
        expensesList.add(Expenses("FOOD", 300.50, "Bought food for a week", R.drawable.food))
        expensesList.add(Expenses("CLOTHES", 900.24, "New dress and a belt", R.drawable.clothes))
        expensesList.add(Expenses("BEAUTY", 340.00, "Vichy cream", R.drawable.beauty))
        expensesList.add(Expenses("BILLS", 140.50, "Paid for water and gas", R.drawable.bills))
        expensesList.add(Expenses("CAR", 500.00, "Fueled the car", R.drawable.car))
        expensesList.add(Expenses("DETERGENTS", 235.45, "Detergents for clothes", R.drawable.detergents))
    }

    override fun onItemClick(item: Expenses, position: Int) {
        var intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("AMOUNT", item.amount.toString())
        intent.putExtra("CATEGORY", item.category)
        intent.putExtra("CATEGLOGO", item.categoryImage.toString())
        intent.putExtra("DESCRIPTION", item.description)
        startActivity(intent)
    }
}