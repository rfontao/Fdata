package com.rica91935.fdata.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataStandings(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: String,
    val offset: String,
    val total: String,
    val StandingsTable: StandingsTable
) : Parcelable {
    override fun toString(): String {
        return "DataStandings(xmlns='$xmlns', series='$series', url='$url', limit='$limit', offset='$offset', total='$total', StandingsTable=$StandingsTable)"
    }
}