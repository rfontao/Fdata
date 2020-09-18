package com.rica91935.fdata.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Circuit (
    val circuitId: String,
    val url: String,
    val circuitName: String,
    val Location: Location
): Parcelable {
    override fun toString(): String {
        return "Circuit(circuitId='$circuitId', url='$url', circuitName='$circuitName', Location=$Location)"
    }
}