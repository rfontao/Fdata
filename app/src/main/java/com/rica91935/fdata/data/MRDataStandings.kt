package com.rica91935.fdata.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MRDataStandings(
    val MRData: DataStandings
) : Parcelable{
    override fun toString(): String {
        return "MRData(Data=$MRData)"
    }
}