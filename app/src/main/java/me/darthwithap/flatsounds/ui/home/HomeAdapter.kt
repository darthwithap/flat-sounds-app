package me.darthwithap.flatsounds.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.darthwithap.flatsounds.databinding.ListItemTypeBinding

class HomeAdapter : ListAdapter<String, HomeAdapter.HomeViewHolder>(
  object : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
      return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
      return oldItem == newItem
    }

  }
) {

  private var clickListener: OnCategoryItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
    val binding = ListItemTypeBinding.inflate(
      LayoutInflater.from(parent.context),
      parent,
      false
    )
    return HomeViewHolder(binding.root)
  }

  override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
    holder.bind(getItem(position))
  }


  inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ListItemTypeBinding = ListItemTypeBinding.bind(itemView)

    fun bind(type: String) {
      binding.tvCategory.text = type
      binding.root.setOnClickListener {
        clickListener?.onCategoryItemClickListener(layoutPosition)
      }
    }
  }

  interface OnCategoryItemClickListener {
    fun onCategoryItemClickListener(position: Int)
  }

  fun setOnCategorySelected(listener: OnCategoryItemClickListener) {
    clickListener = listener
  }
}
