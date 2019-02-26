package com.nitratz.apexcompanion.stackadapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.v4.view.PagerAdapter
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.nitratz.apexcompanion.ui.LegendDetailActivity
import com.nitratz.apexcompanion.ui.MainActivity
import android.support.v4.app.ActivityOptionsCompat
import com.google.gson.Gson
import com.nitratz.apexcompanion.R
import com.nitratz.apexcompanion.models.Legend
import com.google.gson.reflect.TypeToken



class LegendsAdapter(private val mContext: Context) : PagerAdapter() {

    private var mLegends: ArrayList<Legend>

    init {
        val json = mContext.resources.openRawResource(R.raw.legends).bufferedReader().use { it.readText() }

        mLegends = Gson().fromJson(json, object : TypeToken<List<Legend>>(){}.type)
    }

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val legendEnum = LegendsEnum.values()[position]
        val inflater = LayoutInflater.from(mContext)
        val layout = inflater.inflate(R.layout.item_legend, collection, false) as ViewGroup
        layout.run {
            findViewById<TextView>(R.id.tv_title_legend).text = mContext.getString(legendEnum.mLegendName)
            findViewById<ImageView>(R.id.bg_legend).setImageResource(legendEnum.mLegendImage)
        }

        layout.setOnClickListener{
            val intent = Intent((mContext as MainActivity), LegendDetailActivity::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(mContext as Activity, layout.findViewById<View>(R.id.bg_legend), "legend")

            intent.putExtra(LegendDetailActivity.LEGEND_OBJECT, mLegends[legendEnum.mLegendId])
            mContext.startActivity(intent, options.toBundle())
        }

        collection.addView(layout)
        return layout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return LegendsEnum.values().size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val customPagerEnum = LegendsEnum.values()[position]
        return mContext.getString(customPagerEnum.mLegendName)
    }



}