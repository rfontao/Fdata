package com.rica91935.fdata.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    val lat: String,
    val long: String,
    val locality: String,
    val country: String
) : Parcelable {
    override fun toString(): String {
        return "Location(lat='$lat', long='$long', locality='$locality', country='$country')"
    }
}