package com.nitratz.apexcompanion.ui

import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.nitratz.apexcompanion.R
import com.nitratz.apexcompanion.models.Legend
import android.text.method.ScrollingMovementMethod
import android.view.MenuItem




class LegendDetailActivity : AppCompatActivity() {

    private lateinit var mTvLegendTitle: TextView
    private lateinit var mIvLegendImage: ImageView
    private lateinit var mTvLegendDesc: TextView

    private lateinit var mLegend: Legend

    companion object {
        const val LEGEND_OBJECT = "legend_object"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.legend_detail_activity)

        mLegend = intent.getSerializableExtra(LEGEND_OBJECT) as Legend
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = mLegend.mName

        mIvLegendImage = findViewById(R.id.legend_image)
        mTvLegendTitle = findViewById(R.id.tv_title_legend)
        mTvLegendDesc = findViewById(R.id.tv_desc_legend)

        mTvLegendDesc.movementMethod = ScrollingMovementMethod()

        mTvLegendTitle.text = mLegend.mName
        mTvLegendDesc.text = mLegend.mDescription
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

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> ActivityCompat.finishAfterTransition(this)
        }
        return super.onOptionsItemSelected(item)
    }
}