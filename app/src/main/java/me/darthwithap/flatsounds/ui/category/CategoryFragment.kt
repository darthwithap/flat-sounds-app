package me.darthwithap.flatsounds.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import me.darthwithap.flatsounds.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

  private lateinit var viewModel: CategoryViewModel
  private lateinit var binding: FragmentCategoryBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentCategoryBinding.inflate(layoutInflater, container, false)
    viewModel = ViewModelProvider(this)[CategoryViewModel::class.java]
    return binding.root
  }

}