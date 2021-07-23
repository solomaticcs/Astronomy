package com.solomaticydl.astronomy.ui.detail

import android.os.Bundle
import android.view.View
import com.solomaticydl.astronomy.databinding.FragmentDetailBinding
import com.solomaticydl.astronomy.ui.base.BaseFragment
import com.solomaticydl.astronomy.utils.ImageLoader

class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { arguments ->
            val astronomyModel =
                DetailFragmentArgs.fromBundle(arguments).astronomyModel ?: return@let
            binding.tvDate.text = astronomyModel.date
            ImageLoader.loadImageFromUrl(binding.ivPhoto, astronomyModel.hdUrl)
            binding.tvTitle.text = astronomyModel.title
            binding.tvCopyright.text = astronomyModel.copyright
            binding.tvDescription.text = astronomyModel.description
        }
    }
}