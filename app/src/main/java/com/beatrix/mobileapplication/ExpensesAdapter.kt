package com.beatrix.mobileapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.expenses_list_layout.view.*

class ExpensesAdapter (var items : ArrayList<Expenses>, var clickListener: OnExpensesDetailsClickListener) : RecyclerView.Adapter<ExpensesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesViewHolder {
        var expensesViewHolder: ExpensesViewHolder =
            ExpensesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.expenses_list_layout, parent, false))
        return expensesViewHolder
    }

    override fun onBindViewHolder(holder: ExpensesViewHolder, position: Int) {
//        holder.amountExpenses.text = items.get(position).amount.toString()
//        holder.expensesDescription?.text = items.get(position).description
//        holder.category.text = items.get(position).category
//        holder.expensesLogo.setImageResource(items.get(position).categoryImage)
        holder.initialize(items.get(position), clickListener)
    }

    override fun getItemCount(): Int {
       return items.size
    }
}


class ExpensesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var amountExpenses = itemView.amountExpenses
    var expensesDescription = itemView.expensesDescription
    var category = itemView.category
    var expensesLogo = itemView.expensesLogo

    fun initialize(item: Expenses, action: OnExpensesDetailsClickListener){
        amountExpenses.text = item.amount.toString()
        expensesDescription.text = item.description
        category.text = item.category
        expensesLogo.setImageResource(item.categoryImage)

        itemView.setOnClickListener{
            action.onItemClick(item, adapterPosition)
        }
    }
}

interface OnExpensesDetailsClickListener{
    fun onItemClick(item: Expenses, position: Int)
}