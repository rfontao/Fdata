package com.rica91935.fdata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.rica91935.fdata.Data.MRData
import com.rica91935.fdata.Data.Race
import okhttp3.*
import java.io.IOException

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url : String? = arguments?.getString("queryURL")
        view.findViewById<TextView>(R.id.textview_second).text = url

        view.findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SecondFragment.context)
            // specify an viewAdapter (see also next example)

            val raceList : List<Race>? = queryURL(url)?.MRData?.RaceTable?.Races

            adapter = raceList?.let { ResultViewAdapter(it) }

        }

    }


    fun queryURL(url: String?): MRData? {
        val request = Request.Builder().url(url.toString()).build()

        var result: MRData? = null

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Could not reach: {$url}")
            }

            override fun onResponse(call: Call, response: Response) {

                val body = response.body?.string()
                val gson = GsonBuilder().create()
                result = gson.fromJson(body, MRData::class.java)


            }
        })

        return result
    }


}