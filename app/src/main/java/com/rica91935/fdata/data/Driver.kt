package com.rica91935.fdata.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Driver(
    val driverId: String,
    val permanentNumber: String,
    val code: String,
    val url: String,
    val givenName: String,
    val familyName: String,
    val dateOfBirth: String,
    val nationality: String
) : Parcelable {
    override fun toString(): String {
        return "Driver(driverId='$driverId', permanentNumber='$permanentNumber', code='$code', url='$url', givenName='$givenName', familyName='$familyName', dateOfBirth='$dateOfBirth', nationality='$nationality')"
    }
}