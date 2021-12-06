package id.ac.umn.zonaegg.home

import android.graphics.BitmapFactory
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.ac.umn.zonaegg.R
import id.ac.umn.zonaegg.data.Eatery
import java.util.logging.Handler

class HomeExploreCardAdapter (
    private var dataSet : ArrayList<Eatery>,
    private val listener : HomeExploreListener
) : RecyclerView.Adapter<HomeExploreCardAdapter.ViewHolder>() {

    private val url = "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Kantin%20UMN%2FMie%20Ayam%20Bakso%20Wonogiri%2FBackground.jpg?alt=media&token=5db0ff06-77bb-409e-a3a8-fbcf8bf71d45"

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val imgEateryPhoto : ImageView = view.findViewById(R.id.home_ivExploreEateryPhoto)
        val tvEateryName : TextView = view.findViewById(R.id.home_tvExploreEateryName)
        val tvEateryCategory : TextView = view.findViewById(R.id.home_tvExploreEateryCategory)
        val tvEateryRating : TextView = view.findViewById(R.id.home_tvExploreEateryRating)
        val tvEateryDistance : TextView = view.findViewById(R.id.tv_range_eatery)

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
//        holder.imgEateryPhoto.setImageURI(dataSet[position].photoBackground.toUri())

//        Picasso.get().load(url).into(holder.imgEateryPhoto)
//        holder.imgEateryPhoto.setImageResource(dataSet[position].photoBackground)
        Picasso.get().load(dataSet[position].photoBackground).into(holder.imgEateryPhoto)
        holder.tvEateryName.text = dataSet[position].name
        holder.tvEateryCategory.text = dataSet[position].category
        holder.tvEateryRating.text = dataSet[position].rating.toString()
        holder.tvEateryDistance.text = dataSet[position].distance.toString()
    }

    override fun getItemCount(): Int = dataSet.size

}