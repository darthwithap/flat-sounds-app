package me.darthwithap.flatsounds.ui.mediacontroller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import me.darthwithap.flatsounds.databinding.FragmentMediaControllerBinding

class MediaControllerFragment : Fragment() {

  private lateinit var viewModel: MediaControllerViewModel
  private lateinit var binding: FragmentMediaControllerBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentMediaControllerBinding.inflate(layoutInflater, container, false)
    viewModel = ViewModelProvider(this)[MediaControllerViewModel::class.java]
    return binding.root
  }

}