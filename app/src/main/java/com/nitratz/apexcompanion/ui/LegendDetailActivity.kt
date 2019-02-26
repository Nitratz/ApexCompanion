package com.nitratz.apexcompanion.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.nitratz.apexcompanion.R
import com.nitratz.apexcompanion.models.Legend

class LegendDetailActivity : AppCompatActivity() {

    private lateinit var mTvLegendTitle: TextView
    private lateinit var mIvLegendImage: ImageView

    private lateinit var mLegend: Legend

    companion object {
        val LEGEND_OBJECT = "legend_object"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.legend_detail_activity)

        mIvLegendImage = findViewById(R.id.legend_image)
        mTvLegendTitle = findViewById(R.id.tv_title_legend)

        mLegend = intent.getSerializableExtra(LEGEND_OBJECT) as Legend
        setImageByLegendId()
    }

    private fun setImageByLegendId() {
        when (mLegend.mId) {
            0 -> mIvLegendImage.setImageResource(R.drawable.legends_wraith)
            1 -> mIvLegendImage.setImageResource(R.drawable.legends_bangalore)
            2 -> mIvLegendImage.setImageResource(R.drawable.legends_bloodhound)
            3 -> mIvLegendImage.setImageResource(R.drawable.legends_lifeline)
            4 -> mIvLegendImage.setImageResource(R.drawable.legends_gibraltar)
            5 -> mIvLegendImage.setImageResource(R.drawable.legends_pathfinder)
            6 -> mIvLegendImage.setImageResource(R.drawable.legends_mirage)
            7 -> mIvLegendImage.setImageResource(R.drawable.legends_caustic)
        }
    }
}