package com.solomaticydl.astronomy.ui.picturelist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.NetworkImageView
import com.solomaticydl.astronomy.databinding.ItemPictureBinding
import com.solomaticydl.astronomy.model.AstronomyModel
import com.solomaticydl.astronomy.utils.ImageLoader

class PictureListAdapter : ListAdapter<AstronomyModel, PictureListAdapter.ViewHolder>(PictureListDiffCallback()) {

    internal var clickListener: (AstronomyModel) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPictureBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), clickListener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        binding: ItemPictureBinding,
        private val clickListener: (AstronomyModel) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        private val titleTv: TextView = binding.tvTitle
        private val photoIv: NetworkImageView = binding.ivPhoto

        fun bind(astronomyModel: AstronomyModel) {
            itemView.setOnClickListener {
                clickListener.invoke(astronomyModel)
            }
            titleTv.text = astronomyModel.title
            ImageLoader.loadImageFromUrl(photoIv, astronomyModel.url)
        }
    }

    class PictureListDiffCallback: DiffUtil.ItemCallback<AstronomyModel>() {

        override fun areItemsTheSame(oldItem: AstronomyModel, newItem: AstronomyModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: AstronomyModel, newItem: AstronomyModel): Boolean {
            return oldItem == newItem
        }
    }
}