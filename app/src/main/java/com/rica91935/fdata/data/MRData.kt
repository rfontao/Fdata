package com.rica91935.fdata.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MRData(
    val MRData: Data
) : Parcelable{
    override fun toString(): String {
        return "MRData(Data=$MRData)"
    }
}







