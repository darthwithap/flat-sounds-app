package me.darthwithap.flatsounds.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import me.darthwithap.flatsounds.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

  private lateinit var binding: FragmentSplashBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    //Hacky fix to show the SplashScreen for sometime
    //TODO: Include viewModel in SplashScreen to account for Stage of the app and direct to a proper destination accordingly
    Handler(Looper.getMainLooper()).postDelayed(
      {
        findNavController().apply {
          navigate("flatsounds://home".toUri())
        }
      }, 2000
    )
  }
}