package id.ac.umn.zonaegg.eatery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.umn.zonaegg.R
import id.ac.umn.zonaegg.data.Serving
import id.ac.umn.zonaegg.databinding.ItemEateryFoodBinding

class EateryAdapter(
    private val list: ArrayList<Serving>
) : RecyclerView.Adapter<EateryAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemEateryFoodBinding.bind(itemView)
        val nameEatery = bind.tvNameItemEatery
        val priceEatery = bind.tvPriceItemEatery
        val photoEatery = bind.ivImageItemEatery
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_eatery_food, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameEatery.text = list[position].name
        holder.priceEatery.text = "Rp. ${list[position].price}"
        holder.photoEatery.setImageResource(list[position].photoUrl)

    }

    override fun getItemCount(): Int = list.size

}