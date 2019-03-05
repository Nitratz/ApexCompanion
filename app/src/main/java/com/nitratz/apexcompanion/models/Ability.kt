package com.nitratz.apexcompanion.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Ability(@SerializedName("name") val mName: String, @SerializedName("type") val mType: String,
                   @SerializedName("image_url") val mImageUrl: String, @SerializedName("cooldown") val mCooldown: Int,
                   @SerializedName("description") val mDescription: String) : Serializable