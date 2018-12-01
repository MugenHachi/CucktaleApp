package com.studio.quatro.cucktaleApp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drinks:ArrayList<Drink> = ArrayList()

        for(i in 1..100) {
            val drink = Drink(
                    id = i,
                    name = "Drink #$i",
                    instructions = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    glass = "Nick and Nora",
                    ingredient1 = "igr",
                    ingredient2 = "igr",
                    ingredient3 = "igr",
                    ingredient4 = "igr",
                    ingredient5 = "igr",
                    ingredient6 = "igr",
                    ingredient7 = "igr",
                    ingredient8 = "igr",
                    ingredient9 = "igr",
                    ingredient10 = "igr",
                    ingredient11 = "igr",
                    ingredient12 = "igr",
                    ingredient13 = "igr",
                    ingredient14 = "igr",
                    ingredient15 = "igr",
                    measure1 = "msr",
                    measure2 = "msr",
                    measure3 = "msr",
                    measure4 = "msr",
                    measure5 = "msr",
                    measure6 = "msr",
                    measure7 = "msr",
                    measure8 = "msr",
                    measure9 = "msr",
                    measure10 = "msr",
                    measure11 = "msr",
                    measure12 = "msr",
                    measure13 = "msr",
                    measure14 = "msr",
                    measure15 = "msr",
                    alcoholic = "yeah",
                    category = "nice",
                    thumb = "https:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/x03td31521761009.jpg"

            )
            drinks.add(drink)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DrinkAdapter(this, drinks)
    }


}
