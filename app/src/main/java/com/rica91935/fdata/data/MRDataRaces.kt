package com.rica91935.fdata.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MRDataRaces(
    val MRData: DataRace
) : Parcelable{
    override fun toString(): String {
        return "MRData(Data=$MRData)"
    }
}







