package com.rica91935.fdata

import androidx.fragment.app.Fragment
import com.google.gson.GsonBuilder
import com.rica91935.fdata.data.MRDataDriverStandings
import com.rica91935.fdata.data.MRDataRaces
import okhttp3.*
import java.io.IOException

object ErgaastAPIFetcher{

    private const val BASE_URL = "https://ergast.com/api/f1/"
    private const val JSON_TERMINATION = ".json"

    init {
        println("API Fetcher instanciated")
    }

    fun queryRacesByYear(year: Int, fragment: Fragment?) {

        val url = BASE_URL + year.toString() + JSON_TERMINATION

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Could not reach: {$url}")
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {

                val body = response.body?.string()
                val gson = GsonBuilder().create()
                val result = gson.fromJson(body, MRDataRaces::class.java)

                if(fragment != null){
                    val frag = fragment as RaceListFragment
                    frag.updateViewFromData(result.MRData.RaceTable.Races)
                }
            }
        })
    }

    fun queryDriverStandingsByYear(year: Int, fragment: Fragment?){

        val url = "$BASE_URL$year/driverStandings$JSON_TERMINATION"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Could not reach: {$url}")
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {

                val body = response.body?.string()
                val gson = GsonBuilder().create()
                val result = gson.fromJson(body, MRDataDriverStandings::class.java)

                if(fragment != null){
                    val frag = fragment as DriverStandingsListFragment
                    frag.updateViewFromData(result.MRData.StandingsTable.StandingsLists[0].DriverStandings)
                }
            }
        })
    }




}