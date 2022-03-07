package com.sargedev.coppeltechtestapp.model.apiservice


import com.sargedev.coppeltechtestapp.`interface`.RetrofitInstance
import com.sargedev.coppeltechtestapp.model.model.apimodel.ApiHeroModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class HeroesService {

    private val retrofit = RetrofitInstance.getRetrofit()
    private val client = retrofit.create(HeroApiClient::class.java)

    suspend fun getHeroesById(id: Int): ApiHeroModel? {
        return withContext(Dispatchers.IO) {
            try {
                val response = client.getHeroesById(id)
                if (response.isSuccessful && response.body()?.id != null) {
                    response.body()
                } else {
                    null
                }
            }catch (exception: Exception){
                return@withContext null
            }


        }

    }
}