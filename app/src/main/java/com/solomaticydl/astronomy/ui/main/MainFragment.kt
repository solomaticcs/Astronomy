package com.solomaticydl.astronomy.ui.main

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.solomaticydl.astronomy.databinding.FragmentMainBinding
import com.solomaticydl.astronomy.ui.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnOpenPictureList.setOnClickListener {
            val action = MainFragmentDirections
                .actionMainFragmentToPictureListFragment()
            view.findNavController().navigate(action)
        }
    }
}