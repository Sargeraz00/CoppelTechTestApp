package com.sargedev.coppeltechtestapp.model.apiservice

import com.sargedev.coppeltechtestapp.model.model.apimodel.ApiHeroModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface HeroApiClient {
    @GET("{id}")
    suspend fun getHeroesById(@Path("id") id: Int): Response<ApiHeroModel>

}