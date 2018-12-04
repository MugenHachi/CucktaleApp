package com.studio.quatro.cucktaleApp.scenario_main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.studio.quatro.cucktaleApp.entities.Drink
import com.studio.quatro.cucktaleApp.R

class MainActivity : AppCompatActivity(), MainContract.View, DrinkListFragment.OnFragmentInteractionListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter : MainContract.Presenter = MainPresenter(this)
        presenter.onLoadList()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun showList(drinks: List<Drink>) {

        val drinkListFragment = DrinkListFragment.newInstance(drinks as ArrayList<Drink>)

        supportFragmentManager.beginTransaction()
                .replace(R.id.fmMaster, drinkListFragment)
                .commit()



    }

    override fun showDetail(drinks: List<Drink>) {
        val drinkDetailFragment = DrinkDetailFragment.newInstance(drinks.first())

        supportFragmentManager.beginTransaction()
                .replace(R.id.fmMaster, drinkDetailFragment)
                .addToBackStack(null)
                .commit()
    }



    override fun onFragmentInteraction(query: String?, index: Int?) {
        val presenter : MainContract.Presenter = MainPresenter(this)
        if(query == DrinkListFragment.GET_DETAIL) {
            presenter.onLoadDrink(index.toString())
        } else if (query == DrinkListFragment.GET_RANDOM) {
            presenter.onRandomDrink()
        }


    }


}
