package com.studio.quatro.cucktaleApp.scenario_main

import com.studio.quatro.cucktaleApp.entities.Drink

interface MainContract {

    interface View {
        fun showMessage(msg: String)
        fun showList(drinks: List<Drink>)
        fun showDetail(drinks: List<Drink>)
        fun showLoading()
        fun hideLoading()

    }

    interface Presenter {

        fun onLoadList()
        fun onLoadDrink(index: String)
        fun onRandomDrink()

    }
}