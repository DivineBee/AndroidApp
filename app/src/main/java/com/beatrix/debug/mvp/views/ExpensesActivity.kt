package com.beatrix.debug.mvp.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.beatrix.debug.*
import com.beatrix.debug.databinding.ActivityExpensesBinding
import com.beatrix.debug.mvp.contract.ExpensesContractInterface
import com.beatrix.debug.mvp.presenters.ExpensesPresenter
import com.beatrix.debug.utils.Expenses
import com.beatrix.debug.utils.ExpensesAdapter
import com.beatrix.debug.utils.OnExpensesDetailsClickListener
import kotlinx.android.synthetic.main.activity_expenses.*

class ExpensesActivity : AppCompatActivity(), OnExpensesDetailsClickListener,
    ExpensesContractInterface.View {

    lateinit var binding: ActivityExpensesBinding
    lateinit var expensesList: ArrayList<Expenses>

    private var presenter: ExpensesPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_expenses)

        presenter = ExpensesPresenter(this)

        expensesRecycler.layoutManager = LinearLayoutManager(this)
        expensesRecycler.addItemDecoration(DividerItemDecoration(this, 1))
        expensesRecycler.adapter = ExpensesAdapter(expensesList, this)
    }

    override fun initView() {
        presenter?.addExpenses()
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