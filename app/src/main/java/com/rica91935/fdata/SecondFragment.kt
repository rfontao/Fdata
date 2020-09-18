package com.rica91935.fdata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
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

    lateinit var data : MRData

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

        queryURL(url)

    }


    private fun queryURL(url: String?) {
        val request = Request.Builder().url(url.toString()).build()


        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Could not reach: {$url}")
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {

                val body = response.body?.string()
                val gson = GsonBuilder().create()
                data = gson.fromJson(body, MRData::class.java)


                updateRecyclerView(data.MRData.RaceTable.Races)
            }
        })
    }

    fun updateRecyclerView(raceList : List<Race>){
        activity?.runOnUiThread {
            view!!.findViewById<RecyclerView>(R.id.my_recycler_view).apply {
                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@SecondFragment.context)
                adapter = ResultViewAdapter(raceList)

            }
        }
    }

    fun moveToRaceFragment(index : Int){
        val bundle = bundleOf("race" to data.MRData.RaceTable.Races[index])
        findNavController().navigate(R.id.action_SecondFragment_to_RaceFragment, bundle)
    }


}