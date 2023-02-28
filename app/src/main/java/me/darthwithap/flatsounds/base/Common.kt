package me.darthwithap.flatsounds.base

import android.view.View

fun View.setGone() {
  if (visibility != View.GONE)
    visibility = View.GONE
}

fun View.setVisible() {
  if (visibility != View.VISIBLE)
    visibility = View.VISIBLE
}