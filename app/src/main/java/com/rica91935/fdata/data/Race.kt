package com.rica91935.fdata.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Race(
    val season: String,
    val round: String,
    val url: String,
    val raceName: String,
    val Circuit: Circuit,
    val date: String,
    val time: String
) : Parcelable {
    override fun toString(): String {
        return "Race(season='$season', round='$round', url='$url', raceName='$raceName', Circuit=$Circuit, date='$date', time='$time')"
    }
}