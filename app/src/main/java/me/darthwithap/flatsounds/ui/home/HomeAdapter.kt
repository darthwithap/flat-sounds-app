package me.darthwithap.flatsounds.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.darthwithap.flatsounds.databinding.ListItemCategoryBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

  private lateinit var types: ArrayList<String>
  private var clickListener: OnCategoryItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {


    val binding = ListItemCategoryBinding.inflate(
      LayoutInflater.from(parent.context),
      parent, false
    )
    return HomeViewHolder(binding.root)
  }

  override fun getItemCount(): Int {
    return types.size
  }

  override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
    holder.bind(position)
  }


  inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(position: Int) {
      ListItemCategoryBinding.bind(itemView).apply {
        categoryStr = types[position]
        root.setOnClickListener {
          clickListener?.onCategoryItemClickListener(position)
        }
      }
    }

  }

  interface OnCategoryItemClickListener {
    fun onCategoryItemClickListener(position: Int)
  }

  fun setOnCategoryItemClickListener(listener: OnCategoryItemClickListener) {
    clickListener = listener
  }
}
