package com.rica91935.fdata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val numberPicker = view.findViewById<NumberPicker>(R.id.numberPicker)
        if (numberPicker != null) {
            numberPicker.minValue = 1950
            numberPicker.maxValue = 2020
            numberPicker.wrapSelectorWheel = true
        }

        view.findViewById<Button>(R.id.query_button).setOnClickListener {

            val bundle = bundleOf("queryURL" to createQueryURL())
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)

        }

    }


    private fun createQueryURL() : String {

        var url = "http://ergast.com/api/f1/"

        val numberPicker = view?.findViewById<NumberPicker>(R.id.numberPicker)
        if(numberPicker != null){
            url += numberPicker.value.toString() + ".json"
        }

        return url
    }
}