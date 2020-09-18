package com.rica91935.fdata.Data

import com.google.gson.annotations.SerializedName

data class MRData(
    val MRData: Data
) {
    override fun toString(): String {
        return "MRData(Data=$MRData)"
    }
}


data class Data(
        val xmlns: String,
        val series: String,
        val url: String,
        val limit: String,
        val offset: String,
        val total: String,
        val RaceTable: RaceTable
) {
    override fun toString(): String {
        return "Data(xmlns='$xmlns', series='$series', url='$url', limit='$limit', offset='$offset', total='$total', RaceTable=$RaceTable)"
    }


}

data class RaceTable(
    val season: String,
    val Races: List<Race>
) {
    override fun toString(): String {
        return "RaceTable(season='$season', Races=$Races)"
    }
}


data class Race(
    val season: String,
    val round: String,
    val url: String,
    val raceName: String,
    val Circuit: Circuit,
    val date: String,
    val time: String
) {
    override fun toString(): String {
        return "Race(season='$season', round='$round', url='$url', raceName='$raceName', Circuit=$Circuit, date='$date', time='$time')"
    }
}

data class Circuit (
    val circuitId: String,
    val url: String,
    val circuitName: String,
    val Location: Location
) {
    override fun toString(): String {
        return "Circuit(circuitId='$circuitId', url='$url', circuitName='$circuitName', Location=$Location)"
    }
}

data class Location(
    val lat: String,
    val long: String,
    val locality: String,
    val country: String
) {
    override fun toString(): String {
        return "Location(lat='$lat', long='$long', locality='$locality', country='$country')"
    }
}