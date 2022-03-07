package com.sargedev.coppeltechtestapp.view.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.sargedev.coppeltechtestapp.Heropedia.R
import com.sargedev.coppeltechtestapp.Heropedia.databinding.FragmentStartBinding


class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)


        binding.startBtn.setOnClickListener {

            binding.mainUi.visibility = View.INVISIBLE
            binding.loadingView.isVisible = true
            Handler(Looper.getMainLooper()).postDelayed({
                Navigation.findNavController(binding.startBtn)
                    .navigate(R.id.action_tittleFragment_to_mainFragment)
            }, 3000)

        }
        return binding.root
    }

}