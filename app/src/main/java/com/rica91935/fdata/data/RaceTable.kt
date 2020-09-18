package com.rica91935.fdata.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class RaceTable(
    val season: String,
    val Races: List<Race>
) : Parcelable {
    override fun toString(): String {
        return "RaceTable(season='$season', Races=$Races)"
    }
}