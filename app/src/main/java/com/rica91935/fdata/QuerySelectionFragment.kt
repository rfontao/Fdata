package com.rica91935.fdata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class QuerySelectionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.query_options, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.races_button).setOnClickListener{
            findNavController().navigate(R.id.action_Race_Query)
        }
        view.findViewById<Button>(R.id.standings_button).setOnClickListener{
            findNavController().navigate(R.id.action_Driver_Standings_Query)
        }

    }




}