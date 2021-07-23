package com.solomaticydl.astronomy.ui.picturelist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.solomaticydl.astronomy.databinding.FragmentPictureListBinding
import com.solomaticydl.astronomy.state.UiState
import com.solomaticydl.astronomy.ui.base.BaseFragment
import com.solomaticydl.astronomy.viewmodel.PictureListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

class PictureListFragment : BaseFragment<FragmentPictureListBinding>(FragmentPictureListBinding::inflate) {

    private val viewModel: PictureListViewModel by viewModels()

    private val pictureListAdapter: PictureListAdapter by lazy {
        PictureListAdapter()
    }

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.requestAstronomyData()
        }
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 4)
            adapter = pictureListAdapter
        }
        pictureListAdapter.clickListener = {
            val action = PictureListFragmentDirections
                .actionPictureListFragmentToDetailFragment(it)
            view.findNavController().navigate(action)
        }
        viewModel.resultLiveData.observe(viewLifecycleOwner) { uiState ->
            when (uiState) {
                is UiState.InProgress -> {
                    binding.swipeRefresh.isRefreshing = true
                }
                is UiState.Success -> {
                    uiState.extractData?.let {
                        pictureListAdapter.submitList(it)
                    }
                    binding.swipeRefresh.isRefreshing = false
                }
                is UiState.Error -> {
                    binding.swipeRefresh.isRefreshing = false
                }
            }
        }
        viewModel.requestAstronomyData()
    }
}