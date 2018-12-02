package com.studio.quatro.cucktaleApp.scenario_main

import com.studio.quatro.cucktaleApp.entities.DrinkList
import com.studio.quatro.cucktaleApp.network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view: MainContract.View) : MainContract.Presenter {

    override fun onLoadList() {
        val drinkService = RetrofitInicializer().createDrinkService()

        val call = drinkService.getAlcoholicDrinks()

        call.enqueue(object : Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.showMessage("Connection failed.")
            }

            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                if(response.body() != null) {
                    view.showList(response.body()!!.drinks)
                } else {
                    view.showMessage("No drinks found")
                }
            }
        })


    }
}