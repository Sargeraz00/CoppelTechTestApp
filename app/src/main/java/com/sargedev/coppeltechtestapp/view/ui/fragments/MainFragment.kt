package com.sargedev.coppeltechtestapp.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sargedev.coppeltechtestapp.Heropedia.R
import com.sargedev.coppeltechtestapp.Heropedia.databinding.FragmentMainBinding
import com.sargedev.coppeltechtestapp.model.model.apimodel.ApiHeroModel
import com.sargedev.coppeltechtestapp.view.adapter.SuperHeroeAdapter
import com.sargedev.coppeltechtestapp.view.ui.MainActivity.Companion.currentHero
import com.sargedev.coppeltechtestapp.view.ui.MainActivity.Companion.firstscrolling
import com.sargedev.coppeltechtestapp.view.ui.MainActivity.Companion.scrolling
import com.sargedev.coppeltechtestapp.view.ui.viewmodel.HeroViewModel


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: SuperHeroeAdapter
    private val heroViewModel: HeroViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() = Unit
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        initRecyclerView()
        heroViewModel.heroModel.observe(viewLifecycleOwner) {
            adapter.setHeroList(it)
        }

        checkIsBottomScroll()

        return binding.root
    }

    private fun checkIsBottomScroll() {
        binding.mainRV.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    updateIndex()
                }
            }
        })
    }

    private fun updateIndex() {
        firstscrolling = scrolling + 1
        scrolling += 20
        heroViewModel.onCreate()
    }

    private fun initRecyclerView() {
        binding.mainRV.layoutManager = LinearLayoutManager(activity)
        adapter = SuperHeroeAdapter() { hero ->
            onClickItem(
                hero
            )
        }
        binding.mainRV.adapter = adapter
    }

    private fun onClickItem(heroModel: ApiHeroModel) {
        currentHero = heroModel
        Navigation.findNavController(binding.mainRV)
            .navigate(R.id.action_mainFragment_to_detailFragment)
    }
}