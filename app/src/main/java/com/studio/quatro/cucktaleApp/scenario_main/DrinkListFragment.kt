package com.studio.quatro.cucktaleApp.scenario_main


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.studio.quatro.cucktaleApp.R
import com.studio.quatro.cucktaleApp.entities.Drink
import com.studio.quatro.cucktaleApp.utils.Utils
import kotlinx.android.synthetic.main.fragment_drink_list.*
import java.lang.NullPointerException
import java.lang.RuntimeException


class DrinkListFragment : Fragment() {

    companion object {

        private val ARG_LIST = "arg_list"
        public val GET_DETAIL = "detail"
        public val GET_RANDOM = "random"

        fun newInstance(drinks: ArrayList<Drink>) =
                DrinkListFragment().apply {
                    arguments = Bundle().apply {
                        putSerializable(ARG_LIST, drinks)
                    }
                }
    }


    var listener : OnFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drink_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val drinks = getDrinkList()

        activity?.let { context ->
            val adapter = DrinkAdapter(context, drinks)
            adapter.setOnItemClickListener { position ->
                listener?.onFragmentInteraction(GET_DETAIL, drinks[position].idDrink)
            }

            recyclerView.layoutManager = GridLayoutManager(context, Utils.calculateNoOfColumns(context))
            recyclerView.adapter = adapter

            btnRandomDrink.setOnClickListener {
                listener?.onFragmentInteraction(GET_RANDOM)
            }
        }




    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if(context is DrinkListFragment.OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + "must implement DrinkListFragment.OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()

        listener = null
    }

    fun getDrinkList(): ArrayList<Drink>{
        val drinks = arguments?.getSerializable(ARG_LIST) as ArrayList<Drink>?
        if(drinks == null){
            throw NullPointerException("Articles list can not be null")
        }

        return drinks
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(random:String? = GET_DETAIL, index: Int? = null)
    }


}
