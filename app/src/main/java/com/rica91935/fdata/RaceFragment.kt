package com.rica91935.fdata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.rica91935.fdata.Data.Race
import com.rica91935.fdata.databinding.RaceBinding


class RaceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: RaceBinding = DataBindingUtil.inflate(
            inflater, R.layout.race, container, false
        )
        val view: View = binding.root

        val race : Race? = arguments?.get("race") as Race?
        binding.race = race
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}