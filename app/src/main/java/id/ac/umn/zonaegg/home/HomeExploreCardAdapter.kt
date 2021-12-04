package id.ac.umn.zonaegg.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.umn.zonaegg.R
import id.ac.umn.zonaegg.data.Eatery

class HomeExploreCardAdapter (
    private var dataSet : ArrayList<Eatery>,
    private val listener : HomeExploreListener
) : RecyclerView.Adapter<HomeExploreCardAdapter.ViewHolder>() {
    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val imgEateryPhoto : ImageView = view.findViewById(R.id.home_ivExploreEateryPhoto)
        val tvEateryName : TextView = view.findViewById(R.id.home_tvExploreEateryName)
        val tvEateryCategory : TextView = view.findViewById(R.id.home_tvExploreEateryCategory)
        val tvEateryRating : TextView = view.findViewById(R.id.home_tvExploreEateryRating)
        val tvEateryDistance : TextView = view.findViewById(R.id.home_tvEateryDistance)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            listener.goToDetailEatery(dataSet[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_explore_card, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.imgEateryPhoto.setImageURI(dataSet[position].photoUrl.toUri())
        holder.imgEateryPhoto.setImageResource(dataSet[position].photoUrl)
        holder.tvEateryName.text = dataSet[position].name
        holder.tvEateryCategory.text = dataSet[position].category
        holder.tvEateryRating.text = dataSet[position].rating
        holder.tvEateryDistance.text = dataSet[position].distance.toString()
    }

    override fun getItemCount(): Int = dataSet.size

}