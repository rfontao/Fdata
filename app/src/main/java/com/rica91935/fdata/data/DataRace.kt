package com.rica91935.fdata.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataRace(
    val xmlns: String,
    val series: String,
    val url: String,
    val limit: String,
    val offset: String,
    val total: String,
    val RaceTable: RaceTable
) : Parcelable {
    override fun toString(): String {
        return "DataRace(xmlns='$xmlns', series='$series', url='$url', limit='$limit', offset='$offset', total='$total', RaceTable=$RaceTable)"
    }
}