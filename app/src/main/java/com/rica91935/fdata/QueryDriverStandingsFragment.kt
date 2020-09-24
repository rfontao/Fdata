package com.rica91935.fdata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class QueryDriverStandingsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.query_by_year, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val numberPicker = view.findViewById<NumberPicker>(R.id.numberPicker)
        if (numberPicker != null) {
            numberPicker.minValue = 1950
            numberPicker.maxValue = 2019
            numberPicker.wrapSelectorWheel = true
        }

        view.findViewById<Button>(R.id.query_button).setOnClickListener {

            val bundle = bundleOf("queryURL" to createQueryURL())
            findNavController().navigate(R.id.action_Show_Driver_Standings_List, bundle)

        }

    }


    private fun createQueryURL() : String {

        var url = "https://ergast.com/api/f1/"

        val numberPicker = view?.findViewById<NumberPicker>(R.id.numberPicker)
        if(numberPicker != null){
            url += numberPicker.value.toString() + "/driverStandings.json"
        }

        return url
    }
}