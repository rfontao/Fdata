package com.rica91935.fdata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rica91935.fdata.data.MRDataRaces
import com.rica91935.fdata.data.Race

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RaceListFragment : Fragment() {

    lateinit var data : MRDataRaces

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.race_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val year: Int? = arguments?.getInt("yearToQuery")
        view.findViewById<TextView>(R.id.textview_second).text = year.toString()


        if (year != null) {
            ErgaastAPIFetcher.queryRacesByYear(year,this)
        }
    }

    fun updateViewFromData(raceList : List<Race>){
        activity?.runOnUiThread {
            view!!.findViewById<RecyclerView>(R.id.my_recycler_view).apply {
                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@RaceListFragment.context)
                adapter = RaceListViewAdapter(raceList)

            }
        }
    }

}