package com.nitratz.apexcompanion.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Legend(@SerializedName("id") val mId: Int, @SerializedName("name") val mName: String,
                  @SerializedName("image_url") val mImageUrl : String, @SerializedName("description") val mDescription: String,
                  @SerializedName("ability_0") val mPassive: Ability, @SerializedName("ability_1") val mTactical: Ability,
                  @SerializedName("ability_2") val mUltimate: Ability) : Serializable