package com.example.footballapps.customview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.footballapps.R


class CustomStateView : ConstraintLayout {

    lateinit var tvMessage: TextView
    lateinit var progres: ProgressBar
    lateinit var tvTryAgain: TextView
    lateinit var view: View

    lateinit var message: String

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init(attributeSet)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(attrs)
    }

    private fun init(set: AttributeSet?) {

        if (set == null) {
            return
        }

        val ta = context.obtainStyledAttributes(set, R.styleable.CustomStateView)

        ta.recycle()

        declareView()
    }

    private fun declareView() {
        view = View.inflate(context, R.layout.custom_view, this)
        tvMessage = view.findViewById(R.id.tvMessage)
        tvTryAgain = view.findViewById(R.id.tvTryAgain)
        progres = view.findViewById(R.id.progressBar)

        tvTryAgain.setOnClickListener {
            isClickable = true
        }

        showLoading()
    }

    fun hideLoading () {
        tvTryAgain.visibility = View.GONE
        tvMessage.visibility = View.GONE
        progres.visibility = View.GONE
    }

    fun showLoading () {
        tvTryAgain.visibility = View.VISIBLE
        progres.visibility = View.GONE
        tvMessage.visibility = View.GONE
    }

    fun showErrorMessage () {
        tvTryAgain.visibility = View.VISIBLE
        progres.visibility = View.GONE
        tvMessage.visibility = View.VISIBLE
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true

        invalidate()
        return true
    }
}