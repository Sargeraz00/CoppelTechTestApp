package com.sargedev.coppeltechtestapp.view.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sargedev.coppeltechtestapp.Heropedia.databinding.ActivityMainBinding
import com.sargedev.coppeltechtestapp.model.model.apimodel.ApiHeroModel
import com.sargedev.coppeltechtestapp.view.ui.viewmodel.HeroViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val heroViewModel: HeroViewModel by viewModels()

    companion object {
        var currentHero: ApiHeroModel? = null
        var scrolling = 50
        var firstscrolling = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        heroViewModel.onCreate()

    }
}