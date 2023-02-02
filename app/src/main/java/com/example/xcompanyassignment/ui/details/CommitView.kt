package com.example.xcompanyassignment.ui.details

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.example.xcompanyassignment.R
import com.example.xcompanyassignment.ui.makeVisibleOrGone

internal class CommitView
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr) {

    private val commitsNumber: TextView
    private val month: TextView
    private val bar: ImageView
    private val maxBarHeight = resources.getDimension(R.dimen.commits_view_height)

    init {
        View.inflate(context, R.layout.view_commit, this)
        commitsNumber = findViewById(R.id.commits_number)
        month = findViewById(R.id.month)
        bar = findViewById(R.id.bar)
    }

    fun setData(commitsAmount: Int, proportion: Float, month: String) {
        commitsNumber.text =
            resources.getQuantityString(R.plurals.commits, commitsAmount, commitsAmount)
        this.month.text = month
        setAnimation(proportion)
    }

    private fun setAnimation(proportion: Float) {
        val endHeight = proportion * maxBarHeight

        val valueAnimator = ValueAnimator.ofInt(bar.height, endHeight.toInt())
        valueAnimator.duration = 1000
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.addUpdateListener { animation: ValueAnimator ->
            val height = animation.animatedValue as Int
            val layoutParams = bar.layoutParams
            layoutParams.height = height
            bar.layoutParams = layoutParams
        }
        bar.makeVisibleOrGone(true)
        valueAnimator.start()
    }
}