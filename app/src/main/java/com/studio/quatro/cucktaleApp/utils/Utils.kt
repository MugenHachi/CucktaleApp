package com.studio.quatro.cucktaleApp.utils

import android.content.Context


class Utils {

    //https://stackoverflow.com/questions/33575731/gridlayoutmanager-how-to-auto-fit-columns
    companion object {

        fun calculateNoOfColumns(context: Context): Int {
            val displayMetrics = context.resources.displayMetrics
            val dpWidth = displayMetrics.widthPixels / displayMetrics.density
            return (dpWidth / 120).toInt()
        }

    }



}