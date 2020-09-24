package com.rica91935.fdata.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Constructor(
    val constructorId: String,
    val url: String,
    val name: String,
    val nationality: String
) : Parcelable {
    override fun toString(): String {
        return "Constructor(constructorId='$constructorId', url='$url', name='$name', nationality='$nationality')"
    }
}