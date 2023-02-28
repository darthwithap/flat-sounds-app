package me.darthwithap.flatsounds.base

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("goneIfNull")
fun setGoneIfNull(view: View, data: Any?) {
  view.visibility = if (data != null) View.VISIBLE else View.GONE
}

@BindingAdapter("goneIf")
fun setGoneIf(view: View, gone: Boolean) {
  view.visibility = if (gone) View.GONE else View.VISIBLE
}

@BindingAdapter("visibleIf")
fun setVisibleIf(view: View, visible: Boolean) {
  view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("invisibleIf")
fun setInvisibleIf(view: View, invisible: Boolean) {
  view.visibility = if (invisible) View.INVISIBLE else View.VISIBLE
}

@BindingAdapter("goneIfEmpty")
fun setGoneIf(view: View, seq: CharSequence?) {
  if (seq.isNullOrEmpty()) view.setGone() else view.setVisible()
}