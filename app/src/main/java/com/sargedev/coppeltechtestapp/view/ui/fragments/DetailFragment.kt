package com.sargedev.coppeltechtestapp.view.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sargedev.coppeltechtestapp.Heropedia.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sargedev.coppeltechtestapp.Heropedia.databinding.FragmentDetailBinding
import com.sargedev.coppeltechtestapp.view.ui.MainActivity.Companion.currentHero


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        setupHeroInfo()
        return binding.root
    }

    private fun setupHeroInfo() {
        setupHeroImg()
        setupHeroesStats()
        setupBio()
        setupAppearance()
        setupOccupation()
        setupConnections()
    }

    @SuppressLint("SetTextI18n")
    private fun setupConnections() {
        binding.affiliationTV.text =
            getString(R.string.group_affiliation_text) + currentHero!!.connections.groupAffiliation
        binding.relativesTV.text = getString(R.string.relatives_text) + currentHero!!.connections.relatives
    }

    @SuppressLint("SetTextI18n")
    private fun setupOccupation() {
        binding.occupationTV.text = getString(R.string.ocupation_text) + currentHero!!.work.occupation
        binding.baseTV.text = getString(R.string.base_text) + currentHero!!.work.base
    }

    private fun setupHeroImg() {
        Glide.with(binding.heroeImg.context)
            .load(currentHero!!.image.url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(binding.heroeImg)

        binding.heroeName.text = currentHero!!.name
    }

    @SuppressLint("SetTextI18n")
    private fun setupAppearance() {
        binding.genderTV.text = getString(R.string.gender_text) + currentHero!!.appearance.gender
        binding.raceTV.text = getString(R.string.race_text) + currentHero!!.appearance.race
        binding.heightTV.text = getString(R.string.height_text) + currentHero!!.appearance.height.toString()
        binding.weightTV.text = getString(R.string.weight_text) + currentHero!!.appearance.weight.toString()
        binding.eyeColorTV.text = getString(R.string.eyeColor_text) + currentHero!!.appearance.eyeColor
        binding.hairColorTV.text = getString(R.string.hairColor_text) + currentHero!!.appearance.hairColor
    }

    @SuppressLint("SetTextI18n")
    private fun setupBio() {
        binding.fullNameTV.text = getString(R.string.name_text) + currentHero!!.biography.fullName
        binding.alteregoTV.text = getString(R.string.alterEgo_text) + currentHero!!.biography.alterEgos
//        binding.aliasTV.text = currentHero!!.biography.alias.toString()
//            .substring(1, currentHero!!.biography.alias.toString().length - 1)
        binding.placeOfBirthTV.text = getString(R.string.birthPlace_text) + currentHero!!.biography.placeOfBirth
        binding.firstAppearTV.text = getString(R.string.first_appearance_text) + currentHero!!.biography.firstAppearance
        binding.publisherTv.text = getString(R.string.publisher_text) + currentHero!!.biography.publisher
        binding.alignmentTV.text = getString(R.string.alingment_text) + currentHero!!.biography.alignment
    }

    private fun setupHeroesStats() {
        binding.strength.text = currentHero?.powerstats?.strength
        binding.durability.text = currentHero?.powerstats?.durability
        binding.speed.text = currentHero?.powerstats?.speed
        binding.power.text = currentHero?.powerstats?.power
        binding.combat.text = currentHero?.powerstats?.combat
        binding.intelligence.text = currentHero?.powerstats?.intelligence
    }
}