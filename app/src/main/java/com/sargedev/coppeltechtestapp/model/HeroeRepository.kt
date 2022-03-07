package com.sargedev.coppeltechtestapp.model


import com.sargedev.coppeltechtestapp.model.model.apimodel.ApiHeroModel
import com.sargedev.coppeltechtestapp.model.apiservice.HeroesService

class HeroeRepository {

    private val api = HeroesService()

    suspend fun getHeroById(id: Int): ApiHeroModel? {
        return api.getHeroesById(id)
    }
}