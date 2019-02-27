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
import android.widget.ScrollView
import com.bumptech.glide.Glide


class LegendDetailActivity : AppCompatActivity() {

    // Legend
    private lateinit var mTvLegendTitle: TextView
    private lateinit var mIvLegendImage: ImageView
    private lateinit var mTvLegendDesc: TextView
    // Abilities
    private lateinit var mTvTitleAbilityPassive: TextView
    private lateinit var mIvAbilityPassive: ImageView
    private lateinit var mTvTitleAbilityTactical: TextView
    private lateinit var mIvAbilityTactical: ImageView
    private lateinit var mTvTitleAbibilityUltimate: TextView
    private lateinit var mIvAbilityUltimate: ImageView

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
        mTvTitleAbilityPassive = findViewById(R.id.tv_passive)
        mTvTitleAbilityTactical = findViewById(R.id.tv_tactical)
        mTvTitleAbibilityUltimate = findViewById(R.id.tv_ultimate)

        mTvLegendDesc.movementMethod = ScrollingMovementMethod()

        setupScrollingMethod()
        mTvLegendTitle.text = mLegend.mName
        mTvLegendDesc.text = mLegend.mDescription
        setImageByLegendId()
    }

    private fun setImageByLegendId() {
        when (mLegend.mId) {
            0 -> Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/apexcompanion-ddc07.appspot.com/o/legends%2Flegends_wraith.png?alt=media").into(mIvLegendImage)
            1 -> Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/apexcompanion-ddc07.appspot.com/o/legends%2Flegends_bangalore.png?alt=media").into(mIvLegendImage)
            2 -> Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/apexcompanion-ddc07.appspot.com/o/legends%2Flegends_bloodhound.png?alt=media").into(mIvLegendImage)
            3 -> Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/apexcompanion-ddc07.appspot.com/o/legends%2Flegends_wraith.png?alt=media").into(mIvLegendImage)
            4 -> Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/apexcompanion-ddc07.appspot.com/o/legends%2Flegends_wraith.png?alt=media").into(mIvLegendImage)
            5 -> Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/apexcompanion-ddc07.appspot.com/o/legends%2Flegends_wraith.png?alt=media").into(mIvLegendImage)
            6 -> Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/apexcompanion-ddc07.appspot.com/o/legends%2Flegends_wraith.png?alt=media").into(mIvLegendImage)
            7 -> Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/apexcompanion-ddc07.appspot.com/o/legends%2Flegends_wraith.png?alt=media").into(mIvLegendImage)
        }
    }

    private fun setupScrollingMethod() {
        findViewById<ScrollView>(R.id.scroll_container).setOnTouchListener{_, _ ->
            mTvLegendDesc.parent.requestDisallowInterceptTouchEvent(false)
            false

        }
        mTvLegendDesc.setOnTouchListener{_, _ ->
            mTvLegendDesc.parent.requestDisallowInterceptTouchEvent(true)
            false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> ActivityCompat.finishAfterTransition(this)
        }
        return super.onOptionsItemSelected(item)
    }
}