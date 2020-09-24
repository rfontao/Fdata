package com.rica91935.fdata.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class StandingsLists(
    val Standings: List<StandingsListItem>
) : Parcelable {
    override fun toString(): String {
        return "StandingsLists(Standings=$Standings)"
    }
}