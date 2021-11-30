package id.ac.umn.zonaegg

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class HomeExploreNavAdapter (private val dataSet : Array<String>) : RecyclerView.Adapter<HomeExploreNavAdapter.ViewHolder>() {
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tvNav : TextView = view.findViewById(R.id.home_tvExploreNavItem)

        init {
            tvNav.setOnClickListener {
                Toast.makeText(tvNav.context, "You clicked on $adapterPosition", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_explore_nav, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNav.text = dataSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}