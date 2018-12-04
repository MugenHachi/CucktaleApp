package com.studio.quatro.cucktaleApp.scenario_main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.studio.quatro.cucktaleApp.entities.Drink
import com.studio.quatro.cucktaleApp.R
import com.studio.quatro.cucktaleApp.utils.GlideApp
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import kotlinx.android.synthetic.main.item_drink.view.*

class DrinkAdapter(val context: Context, val drinks: List<Drink>) : RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {

    var itemClickListener: ((index: Int) -> Unit)? = null

    fun setOnItemClickListener(click: ((index: Int) -> Unit)){
        this.itemClickListener = click
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_drink, parent, false)
        return ViewHolder(view)


    }

    override fun getItemCount() = drinks.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindView(context, drinks[position], itemClickListener)

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context, drink: Drink, itemClickListener: ((index: Int) -> Unit)?) {
            itemView.drinkName.text = drink.strDrink

            GlideApp.with(context)
                    .load(drink.strDrinkThumb)
                    .centerCrop()
                    .into(itemView.drinkImg)

            if(itemClickListener != null) {
                itemView.setOnClickListener {
                    itemClickListener.invoke(adapterPosition)
                }
            }
        }


    }






}
