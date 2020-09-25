package com.rica91935.fdata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ListAdapter
import android.widget.TextView
import com.rica91935.fdata.data.DriverStanding

/*
class ParentViewHolder(itemView: View) : BaseExpandableListAdapter {
    private val position: TextView = itemView.findViewById(R.id.position)
    private val driverName: TextView = itemView.findViewById(R.id.driverName)

    fun putData(driverNameString: String, positionString: String) {
        position.text = positionString
        driverName.text = driverNameString
    }
}

class ChildrenViewHolder(itemView: View) : ChildViewHolder(itemView) {
    private val teamNationality: TextView = itemView.findViewById(R.id.teamNacionality)
    private val teamName: TextView = itemView.findViewById(R.id.teamName)

    fun putData(teamNationalityString: String, teamNameString: String) {
        teamNationality.text = teamNationalityString
        teamName.text = teamNameString
    }
}

*/


class DriverStandingsListViewAdapter(private val standing: List<DriverStanding>) : BaseExpandableListAdapter(){
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

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return false
    }


    /*

    // Create new views (invoked by the layout manager)
    override fun onCreateGroupViewHolder(parent: ViewGroup?, viewType: Int): ParentViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent?.context)
            .inflate(R.layout.driver_standings_list_parent_item, parent, false)
        // set the view's size, margins, paddings and layout parameters

        return ParentViewHolder(textView)
    }

    override fun onCreateChildViewHolder(parent: ViewGroup?, viewType: Int): ChildrenViewHolder {
        val textView = LayoutInflater.from(parent?.context)
            .inflate(R.layout.driver_standings_list_child_item, parent, false)

        return ChildrenViewHolder(textView)
    }

    override fun onBindGroupViewHolder(holder: ParentViewHolder?, position: Int, group: ExpandableGroup<*>?) {

        val standing: DriverStanding = group as DriverStanding
        holder?.putData(standing.Driver.givenName + " " + standing.Driver.familyName, "HAM")

    }

    override fun onBindChildViewHolder(holder: ChildrenViewHolder?, flatPosition: Int, group: ExpandableGroup<*>?, childIndex: Int) {

        val standing: DriverStanding = group as DriverStanding
        val data = standing.items[childIndex]
        holder?.putData(data.nationality, data.name)
    }

    */
}
