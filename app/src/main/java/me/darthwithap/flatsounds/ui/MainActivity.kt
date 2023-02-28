package me.darthwithap.flatsounds.ui

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import me.darthwithap.flatsounds.R

class MainActivity : AppCompatActivity() {
  companion object {
    private const val TAG = "MainActivity"
  }

  //UI Components

  //Vars

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

  @Deprecated("Deprecated in Java")
  override fun onBackPressed() {
    super.onBackPressed()
    window.clearFlags(
      WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
    )
  }
}