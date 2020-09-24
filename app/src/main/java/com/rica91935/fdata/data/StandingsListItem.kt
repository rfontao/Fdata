package com.rica91935.fdata.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StandingsListItem(
    val season: String,
    val round: String,
    val DriverStandings: List<DriverStanding>
) : Parcelable {
    override fun toString(): String {
        return "StandingsListItem(season='$season', round='$round', DriverStandings=$DriverStandings)"
    }
}