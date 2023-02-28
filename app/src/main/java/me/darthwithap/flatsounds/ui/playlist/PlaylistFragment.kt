package me.darthwithap.flatsounds.ui.playlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import me.darthwithap.flatsounds.databinding.FragmentPlaylistBinding

class PlaylistFragment : Fragment() {

  companion object {
    fun newInstance() = PlaylistFragment()
  }

  private lateinit var viewModel: PlaylistViewModel
  private lateinit var binding: FragmentPlaylistBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentPlaylistBinding.inflate(layoutInflater, container, false)
    viewModel = ViewModelProvider(this)[PlaylistViewModel::class.java]
    return binding.root
  }

}