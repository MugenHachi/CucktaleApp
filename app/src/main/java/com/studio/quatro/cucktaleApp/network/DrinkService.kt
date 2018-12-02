package com.studio.quatro.cucktaleApp.network

import com.studio.quatro.cucktaleApp.entities.DrinkList
import retrofit2.Call
import retrofit2.http.GET

interface DrinkService {


    @GET("filter.php?a=Alcoholic")
    fun getAlcoholicDrinks(): Call<DrinkList>


}