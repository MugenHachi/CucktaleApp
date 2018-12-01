package com.studio.quatro.cucktaleApp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import kotlinx.android.synthetic.main.item_drink.view.*

class DrinkAdapter(val context: Context, val drinks: ArrayList<Drink>) : RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {

    var itemClickListener: ((index: Int) -> Unit)? = null

    fun setOnItemClickListener(click: ((index: Int) -> Unit)) {
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
            itemView.drinkName.text = drink.name

            GlideApp.with(context)
                    .load(itemView.drinkImg)
                    .transform(RoundedCornersTransformation(30, 10))
                    .into(itemView.drinkImg)

            if (itemClickListener != null) {
                itemView.setOnClickListener {
                    itemClickListener.invoke(adapterPosition)
                }
            }
        }


    }






}
