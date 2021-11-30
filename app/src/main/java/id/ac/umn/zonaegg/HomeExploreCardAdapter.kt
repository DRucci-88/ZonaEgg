package id.ac.umn.zonaegg

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import id.ac.umn.zonaegg.data.Eatery

class HomeExploreCardAdapter (private val dataSet : Array<Eatery>) : RecyclerView.Adapter<HomeExploreCardAdapter.ViewHolder>() {
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val imgEateryPhoto : ImageView = view.findViewById(R.id.home_ivExploreEateryPhoto)
        val tvEateryName : TextView = view.findViewById(R.id.home_tvExploreEateryName)
        val tvEateryCategory : TextView = view.findViewById(R.id.home_tvExploreEateryCategory)
        val tvEateryRating : TextView = view.findViewById(R.id.home_tvExploreEateryRating)
        val tvEateryDistance : TextView = view.findViewById(R.id.home_tvEateryDistance)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_explore_card, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgEateryPhoto.setImageURI(dataSet[position].photoUrl.toUri())
        holder.tvEateryName.text = dataSet[position].name
        holder.tvEateryCategory.text = dataSet[position].category
        holder.tvEateryRating.text = dataSet[position].rating
        holder.tvEateryDistance.text = dataSet[position].distance.toString()
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}