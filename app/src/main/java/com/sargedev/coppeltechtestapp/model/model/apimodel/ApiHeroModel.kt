package com.sargedev.coppeltechtestapp.model.model.apimodel

data class ApiHeroModel(
    val appearance: Appearance,
    val biography: Biography,
    val connections: Connections,
    val id: String,
    val image: Image,
    val name: String,
    val powerstats: PowerStats,
    val response: String,
    val work: Work
)