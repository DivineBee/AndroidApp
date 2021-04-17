package com.beatrix.debug.mvp.presenters

import com.beatrix.debug.mvp.contract.ExpensesContractInterface
import com.beatrix.debug.mvp.models.ExpensesModel

class ExpensesPresenter(_view: ExpensesContractInterface.View):
    ExpensesContractInterface.Presenter {
    private var view: ExpensesContractInterface.View = _view
    private var model: ExpensesContractInterface.Model = ExpensesModel()

    init {
        view.initView()
    }

    override fun addExpenses() {
        model.addExpenses()
        view.updateViewData()
    }
}