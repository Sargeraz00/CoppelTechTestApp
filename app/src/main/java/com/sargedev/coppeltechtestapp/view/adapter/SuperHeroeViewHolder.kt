package com.sargedev.coppeltechtestapp.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sargedev.coppeltechtestapp.Heropedia.databinding.HeroItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sargedev.coppeltechtestapp.model.model.apimodel.ApiHeroModel

class SuperHeroeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = HeroItemBinding.bind(view)

    fun render(heroModel: ApiHeroModel, onClickListener: (ApiHeroModel) -> Unit) {
        binding.heroNameTV.text = heroModel.name
        binding.publisherTV.text = heroModel.biography.publisher
        Glide.with(binding.imgCard.context)
            .load(heroModel.image.url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(binding.imgCard)

        itemView.setOnClickListener {
            onClickListener(heroModel) }
    }
}