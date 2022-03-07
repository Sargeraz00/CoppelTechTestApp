package com.sargedev.coppeltechtestapp.model.model.apimodel

data class ApiHeroModel(
    val appearance: Appearance,
    val biography: Biography,
    val connections: Connections,
    val id: String,
    val image: Image,
    val name: String,
    val powerStats: Powerstats,
    val response: String,
    val work: Work
)