package com.studio.quatro.cucktaleApp.scenario_main

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.studio.quatro.cucktaleApp.entities.Drink
import com.studio.quatro.cucktaleApp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

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

        val adapter = DrinkAdapter(this, drinks)
        adapter.setOnItemClickListener { position ->
            Toast.makeText(this, "item $position", Toast.LENGTH_SHORT)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }


}
