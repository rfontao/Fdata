package com.rica91935.fdata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.rica91935.fdata.data.DriverStanding
import com.rica91935.fdata.data.MRDataDriverStandings

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DriverStandingsListFragment : Fragment() {

    lateinit var data : MRDataDriverStandings

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.driver_standings_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val year: Int? = arguments?.getInt("yearToQuery")
        view.findViewById<TextView>(R.id.textview_second).text = year.toString()

        if (year != null) {
            ErgaastAPIFetcher.queryDriverStandingsByYear(year,this)
        }

    }

    fun updateViewFromData(driverStandingsList: List<DriverStanding>){
        activity?.runOnUiThread {
            view!!.findViewById<ExpandableListView>(R.id.driver_standing_expandable_view).setAdapter(DriverStandingsListViewAdapter(driverStandingsList))
        }
    }

}