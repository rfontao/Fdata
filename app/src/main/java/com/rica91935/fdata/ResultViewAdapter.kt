package com.rica91935.fdata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.rica91935.fdata.Data.Race

class ResultViewAdapter(private val myDataset: List<Race>) :
    RecyclerView.Adapter<ResultViewAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(val textView: View) : RecyclerView.ViewHolder(textView)


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_text_view, parent, false)
        // set the view's size, margins, paddings and layout parameters

        return MyViewHolder(textView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.textView.findViewById<TextView>(R.id.track_name).text = myDataset[position].raceName
        holder.textView.findViewById<TextView>(R.id.round).text = myDataset[position].round
        holder.textView.setOnClickListener {
            val bundle = bundleOf("race" to myDataset[position])
            it.findNavController().navigate(R.id.action_SecondFragment_to_RaceFragment, bundle)
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}
