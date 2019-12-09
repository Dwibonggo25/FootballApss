package com.example.footballapps.ui.favorite

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.DynamicDrawableSpan
import android.view.View
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.example.footballapps.R
import com.example.footballapps.base.BaseFragment
import com.example.footballapps.databinding.FragmentFavoriteBinding

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, FavoriteViewmodel>() {
    override fun getLayoutResourceId(): Int = R.layout.fragment_favorite

    override fun getViewModelClass(): Class<FavoriteViewmodel> = FavoriteViewmodel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun onDeleteClicked () {
        val progressDrawable = CircularProgressDrawable(activity!!).apply {
            setStyle(CircularProgressDrawable.LARGE)
            setColorSchemeColors(Color.WHITE)

            //bounds definition is required to show drawable correctly
            val size = (centerRadius + strokeWidth).toInt() * 2
            setBounds(0, 0, size, size)
        }

        // create a drawable span using our progress drawable
        val drawableSpan = object : DynamicDrawableSpan() {
            override fun getDrawable() = progressDrawable
        }

        // create a SpannableString like "Loading [our_progress_bar]"
        val spannableString = SpannableString("Loading ").apply {
            setSpan(drawableSpan, length - 1, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        progressDrawable.start()

        val callback = object : Drawable.Callback {
            override fun unscheduleDrawable(who: Drawable, what: Runnable) {
            }

            override fun invalidateDrawable(who: Drawable) {
                binding.btnDelete.invalidate()
            }

            override fun scheduleDrawable(who: Drawable, what: Runnable, `when`: Long) {
            }
        }
        progressDrawable.callback = callback

        binding.btnDelete.text = spannableString
    }

}
