package id.ac.umn.zonaegg.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.squareup.picasso.Picasso
import id.ac.umn.zonaegg.R
import id.ac.umn.zonaegg.data.Eatery
import id.ac.umn.zonaegg.databinding.HomePopularSliderItemBinding

class HomePopularSliderAdapter(
    private val listPopular: ArrayList<Eatery>,
    private val viewPager: ViewPager2
) : RecyclerView.Adapter<HomePopularSliderAdapter.MyViewHolder>() {

    companion object{
        lateinit var rawListPopular: ArrayList<Eatery>
    }
    init {
        rawListPopular = listPopular.map { it.copy() } as ArrayList<Eatery>
//        Log.d("heroism","Total: ${rawListPopular.size}")
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val bind = HomePopularSliderItemBinding.bind(itemView)
        val namePopular = bind.tvPopularName
        val ratingPopular = bind.tvPopularRating
        val distancePopular = bind.tvPopularDistance
        val imagePopular = bind.ivPopularImage

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
//            Log.d("heroism", "Home Popular Slide Position : $adapterPosition")
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_popular_slider_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.namePopular.text = listPopular[position].name
        holder.ratingPopular.text = listPopular[position].rating
        holder.distancePopular.text = listPopular[position].distance.toString()
//        holder.imagePopular.setImageResource(listPopular[position].photoBackground)
        Picasso.get().load(listPopular[position].photoBackground).into(holder.imagePopular)
//        Log.d("heroism","Position : ${position.toString()}, Size: ${listPopular.size}")
        if(listPopular.size == rawListPopular.size * 6)
            viewPager.post(runnableReset)
        else if(position == listPopular.size - 2)
            viewPager.post(runnable)

    }

    override fun getItemCount(): Int = listPopular.size

    private val runnableReset = Runnable {
        kotlin.run {
//            Log.d("heroism","Reset")
            listPopular.clear()
//            Log.d("heroism", rawListPopular.toString())
            listPopular.addAll(rawListPopular)

            this.notifyItemRangeChanged(0, listPopular.size)
            viewPager.setCurrentItem(0, true)
//            this.notifyDataSetChanged()
        }
    }

    private val runnable = Runnable {
        kotlin.run {
//            Log.d("heroism","Add")
            listPopular.addAll(rawListPopular)
            this.notifyItemRangeChanged(0, (listPopular.size/2))
//            this.notifyDataSetChanged()
        }
    }
}
