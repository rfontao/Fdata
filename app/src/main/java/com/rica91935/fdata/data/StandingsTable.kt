package com.rica91935.fdata.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class StandingsTable(
    val season: String,
    val StandingsLists: List<StandingsListItem>
) : Parcelable {
    override fun toString(): String {
        return "StandingsTable(season='$season', StandingsLists=$StandingsLists)"
    }
}