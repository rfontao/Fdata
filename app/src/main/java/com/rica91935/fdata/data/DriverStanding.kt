package com.rica91935.fdata.data

import android.os.Parcelable
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DriverStanding (
    val position: String,
    val positionText: String,
    val points: String,
    val wins: String,
    val Driver: Driver,
    val Constructors: List<Constructor>
) : Parcelable, ExpandableGroup<Constructor>(Driver.givenName + Driver.familyName, Constructors) {
    override fun toString(): String {
        return "DriverStanding(position='$position', positionText='$positionText', points='$points', wins='$wins', Driver=$Driver, Constructors=$Constructors)"
    }
}