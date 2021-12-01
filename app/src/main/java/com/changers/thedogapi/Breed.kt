package com.changers.thedogapi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Breed(val id: Int, val name: String, val reference_image_id: String) : Parcelable

