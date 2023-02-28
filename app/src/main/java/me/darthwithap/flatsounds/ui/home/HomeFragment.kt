package me.darthwithap.flatsounds.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import me.darthwithap.flatsounds.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

  companion object {
    fun newInstance() = HomeFragment()
  }

  private lateinit var viewModel: HomeViewModel
  private lateinit var binding: FragmentHomeBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
    viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    return binding.root
  }

}