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
import com.bumptech.glide.Glide
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
        val legend = mLegends[position]
        val inflater = LayoutInflater.from(mContext)
        val layout = inflater.inflate(R.layout.item_legend, collection, false) as ViewGroup

        layout.findViewById<TextView>(R.id.tv_title_legend).text = legend.mName
        Glide.with(mContext).load(legend.mImageUrl).into(layout.findViewById<ImageView>(R.id.bg_legend))
        layout.setOnClickListener{
            val intent = Intent((mContext as MainActivity), LegendDetailActivity::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(mContext as Activity, layout.findViewById<View>(R.id.bg_legend), "legend")

            intent.putExtra(LegendDetailActivity.LEGEND_OBJECT, legend)
            mContext.startActivity(intent, options.toBundle())
        }

        collection.addView(layout)
        return layout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int = mLegends.size

    override fun isViewFromObject(view: View, obj: Any): Boolean = view === obj

    override fun getPageTitle(position: Int): CharSequence? = mLegends[position].mName



}