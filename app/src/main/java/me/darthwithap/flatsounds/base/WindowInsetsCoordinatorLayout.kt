package me.darthwithap.flatsounds.base

import android.content.Context
import android.util.AttributeSet
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat

class WindowInsetsCoordinatorLayout @JvmOverloads constructor(
  context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CoordinatorLayout(context, attrs, defStyleAttr) {

  init {
    ViewCompat.setOnApplyWindowInsetsListener(this) { _, insets ->
      insets
    }
  }
}