package com.nitratz.apexcompanion.stackadapter

import com.nitratz.apexcompanion.R

enum class LegendsEnum private constructor(val mLegendId: Int, val mLegendImage: Int, val mLegendName: Int) {

    WRAITH(
        0,
        R.drawable.legends_wraith,
        R.string.legends_wraith
    ),
    BANGALORE(
        1,
        R.drawable.legends_bangalore,
        R.string.legends_bangalore
    ),
    BLOODHOUND(
        2,
        R.drawable.legends_bloodhound,
        R.string.legends_bloodhound
    ),
    LIFELINE(
        3,
        R.drawable.legends_lifeline,
        R.string.legends_lifeline
    ),
    GIBRALTAR(
        4,
        R.drawable.legends_gibraltar,
        R.string.legends_gibraltar
    ),
    PATHFINDER(
        5,
        R.drawable.legends_pathfinder,
        R.string.legends_pathfinder
    ),
    MIRAGE(
        6,
        R.drawable.legends_mirage,
        R.string.legends_mirage
    ),
    CAUSTIC1(
        7,
        R.drawable.legends_caustic,
        R.string.legends_caustic
    );
}