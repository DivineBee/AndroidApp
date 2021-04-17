package com.beatrix.debug.mvp.contract

interface ExpensesContractInterface {

    interface View {
        fun initView()
        fun updateViewData()
    }

    interface Presenter {
        fun addExpenses()
    }

    interface Model {
        fun addExpenses()
    }
}