package com.sargedev.coppeltechtestapp.`interface`

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.superheroapi.com/api.php/490326199270841/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}