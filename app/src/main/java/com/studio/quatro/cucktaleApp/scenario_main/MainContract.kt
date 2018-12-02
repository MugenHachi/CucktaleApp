package com.studio.quatro.cucktaleApp.scenario_main

import com.studio.quatro.cucktaleApp.entities.Drink

interface MainContract {

    interface View {
        fun showMessage(msg: String)
        fun showList(drinks: List<Drink>)

    }

    interface Presenter {

        fun onLoadList()

    }
}