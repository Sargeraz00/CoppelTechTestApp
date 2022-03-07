package com.sargedev.coppeltechtestapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sargedev.coppeltechtestapp.Heropedia.R
import com.sargedev.coppeltechtestapp.model.model.apimodel.ApiHeroModel

class SuperHeroeAdapter(private val onClickListener: (ApiHeroModel) -> Unit) :
    RecyclerView.Adapter<SuperHeroeViewHolder>() {

    var superHeroList: MutableList<ApiHeroModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroeViewHolder(layoutInflater.inflate(R.layout.hero_item, parent, false))
    }

    override fun onBindViewHolder(holder: SuperHeroeViewHolder, position: Int) {
        val item = superHeroList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = superHeroList.size

    fun setHeroList(heroModel: MutableList<ApiHeroModel>) {
        superHeroList = heroModel
        notifyDataSetChanged()
    }
}