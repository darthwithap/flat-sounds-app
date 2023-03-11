package me.darthwithap.flatsounds.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import me.darthwithap.flatsounds.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

  private lateinit var viewModel: HomeViewModel
  private var binding: FragmentHomeBinding? = null
  private lateinit var adapter: HomeAdapter

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
    viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    viewModel.updateCategoryList()
    adapter = HomeAdapter()

    adapter.setOnCategorySelected(object : HomeAdapter.OnCategoryItemClickListener {
      override fun onCategoryItemClickListener(position: Int) {
        onCategorySelected(position)
      }

    })
    binding?.rvHome?.layoutManager =
      LinearLayoutManager(context)
    binding?.rvHome?.adapter = adapter

    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.categoryList.observe(viewLifecycleOwner) {
      adapter.submitList(it)
    }
  }

  private fun onCategorySelected(position: Int) {
    TODO("Not yet implemented")
  }

  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }
}