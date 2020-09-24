package com.rica91935.fdata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.rica91935.fdata.data.DriverStanding
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder

class ParentViewHolder(itemView: View) : GroupViewHolder(itemView) {
    private val position: TextView = itemView.findViewById(R.id.position)
    val driverName: TextView = itemView.findViewById(R.id.driverName)

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


class DriverStandingsListViewAdapter(private val myDataset: List<DriverStanding>,
                                     groups: List<DriverStanding>
) :
    ExpandableRecyclerViewAdapter<ParentViewHolder, ChildrenViewHolder>(groups) {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    //class MyViewHolder(val textView: View) : RecyclerView.ViewHolder(textView


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
        // set the view's size, margins, paddings and layout parameters

        return ChildrenViewHolder(textView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindGroupViewHolder(holder: ParentViewHolder?, position: Int, group: ExpandableGroup<*>?) {
        holder?.putData(myDataset[position].Driver.givenName + " " + myDataset[position].Driver.familyName, myDataset[position].Driver.permanentNumber)

        holder?.driverName?.setOnClickListener {
            toggleGroup(position)
        }

        /*
        holder.textView.setOnClickListener {
            val bundle = bundleOf("race_info" to myDataset[position])
            it.findNavController().navigate(R.id.action_Show_Race, bundle)
        }
         */

    }

    override fun onBindChildViewHolder(holder: ChildrenViewHolder?, flatPosition: Int, group: ExpandableGroup<*>?, childIndex: Int) {
        holder?.putData(myDataset[flatPosition].Constructors[0].nationality, myDataset[flatPosition].Constructors[0].name)
    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}
