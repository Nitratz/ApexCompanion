package com.nitratz.apexcompanion.ui

import android.annotation.SuppressLint
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
    private lateinit var mTvTitleAbilityTactical: TextView
    private lateinit var mTvTitleAbilityUltimate: TextView
    private lateinit var mIvAbilityPassive: ImageView
    private lateinit var mIvAbilityTactical: ImageView
    private lateinit var mIvAbilityUltimate: ImageView
    private lateinit var mTvCooldoownPassive: TextView
    private lateinit var mTvCooldoownTactical: TextView
    private lateinit var mTvCooldoownUltimate: TextView
    private lateinit var mTvDescPassive: TextView
    private lateinit var mTvDescTactical: TextView
    private lateinit var mTvDescUltimate: TextView

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

        bindViews()
        attachDataToViews()
    }

    private fun bindViews() {
        mIvLegendImage = findViewById(R.id.legend_image)
        mTvLegendTitle = findViewById(R.id.tv_title_legend)
        mTvLegendDesc = findViewById(R.id.tv_desc_legend)
        mTvTitleAbilityPassive = findViewById(R.id.tv_passive)
        mTvTitleAbilityTactical = findViewById(R.id.tv_tactical)
        mTvTitleAbilityUltimate = findViewById(R.id.tv_ultimate)
        mIvAbilityPassive = findViewById(R.id.iv_passive)
        mIvAbilityTactical = findViewById(R.id.iv_tactical)
        mIvAbilityUltimate = findViewById(R.id.iv_ultimate)
        mTvCooldoownPassive = findViewById(R.id.cooldown_passive)
        mTvCooldoownTactical = findViewById(R.id.cooldown_tactical)
        mTvCooldoownUltimate = findViewById(R.id.cooldown_ultimate)
        mTvDescPassive = findViewById(R.id.tv_desc_passive)
        mTvDescTactical = findViewById(R.id.tv_desc_tactical)
        mTvDescUltimate = findViewById(R.id.tv_desc_ultimate)
    }

    private fun attachDataToViews() {
        mTvLegendTitle.text = mLegend.mName
        mTvLegendDesc.text = mLegend.mDescription
        setupScrollingMethod(mTvLegendDesc)
        Glide.with(this).load(mLegend.mImageUrl).into(mIvLegendImage)

        mTvTitleAbilityPassive.text = mLegend.mPassive.mName
        mTvTitleAbilityTactical.text = mLegend.mTactical.mName
        mTvTitleAbilityUltimate.text = mLegend.mUltimate.mName

        mTvCooldoownPassive.text = "${mLegend.mPassive.mCooldown} sec"
        mTvCooldoownTactical.text = "${mLegend.mTactical.mCooldown} sec"
        mTvCooldoownUltimate.text = "${mLegend.mUltimate.mCooldown} sec"

        mTvDescPassive.text = mLegend.mPassive.mDescription
        mTvDescTactical.text = mLegend.mTactical.mDescription
        mTvDescUltimate.text = mLegend.mUltimate.mDescription
        setupScrollingMethod(mTvDescPassive)
        setupScrollingMethod(mTvDescTactical)
        setupScrollingMethod(mTvDescUltimate)

        Glide.with(this).load(mLegend.mPassive.mImageUrl).into(mIvAbilityPassive)
        Glide.with(this).load(mLegend.mTactical.mImageUrl).into(mIvAbilityTactical)
        Glide.with(this).load(mLegend.mUltimate.mImageUrl).into(mIvAbilityUltimate)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupScrollingMethod(tv: TextView) {
        tv.movementMethod = ScrollingMovementMethod()
        findViewById<ScrollView>(R.id.scroll_container).setOnTouchListener{_, _ ->
            tv.parent.requestDisallowInterceptTouchEvent(false)
            false

        }
        tv.setOnTouchListener{_, _ ->
            tv.parent.requestDisallowInterceptTouchEvent(true)
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