package com.rica91935.fdata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.rica91935.fdata.data.Race
import com.rica91935.fdata.databinding.RaceBinding
import org.osmdroid.api.IMapController
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker


class RaceInfoFragment : Fragment() {

    lateinit var race : Race

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: RaceBinding = DataBindingUtil.inflate(
            inflater, R.layout.race_info, container, false
        )
        val view: View = binding.root

        race  = arguments?.get("race_info") as Race
        binding.race = race
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val map = view.findViewById<MapView>(R.id.map)

        Configuration.getInstance().userAgentValue = context?.packageName

        val mapController: IMapController = map.controller
        mapController.setZoom(15.0)

        val startPoint = GeoPoint(race.Circuit.Location.lat.toDouble(), race.Circuit.Location.long.toDouble())
        mapController.setCenter(startPoint)

        val startMarker = Marker(map)
        startMarker.position = startPoint
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        map.overlays.add(startMarker)
    }


}