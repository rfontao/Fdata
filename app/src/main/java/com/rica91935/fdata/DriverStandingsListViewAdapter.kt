package com.rica91935.fdata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.rica91935.fdata.data.DriverStanding

class DriverStandingsListViewAdapter(private val standing: List<DriverStanding>) : BaseExpandableListAdapter(){

    override fun getGroupView(listPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.driver_standings_list_parent_item, parent, false)

        view.findViewById<TextView>(R.id.driverName).text = standing[listPosition].Driver.givenName
        view.findViewById<TextView>(R.id.position).text = standing[listPosition].position

        return view
    }

    override fun getChildView(listPosition: Int, expandedListPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View? {

        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.driver_standings_list_child_item, parent, false)

        view.findViewById<TextView>(R.id.teamName).text = standing[listPosition].Constructors[0].name
        view.findViewById<TextView>(R.id.teamNacionality).text = standing[listPosition].Constructors[0].nationality

        return view
    }

    override fun getGroupCount(): Int {
        return standing.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return standing[0].Constructors.size
    }

    override fun getGroup(p0: Int): Any {
        return standing[p0]
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return standing[p0].Constructors[0]
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return false
    }
}
