package com.sargedev.coppeltechtestapp.get

import com.sargedev.coppeltechtestapp.model.HeroeRepository
import com.sargedev.coppeltechtestapp.model.model.apimodel.ApiHeroModel

class GetHeroesUC {

    private val repository = HeroeRepository()

    suspend  fun getHeroById(id: Int): ApiHeroModel? {
        return repository.getHeroById(id)
    }
}