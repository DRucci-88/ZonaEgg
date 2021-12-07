package id.ac.umn.zonaegg.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.umn.zonaegg.data.Eatery
import id.ac.umn.zonaegg.eatery.EateryActivity
import id.ac.umn.zonaegg.data.EateryFireStore
import id.ac.umn.zonaegg.databinding.FragmentHomeExploreBinding
import java.util.*
import kotlin.collections.ArrayList

class HomeExploreFragment : Fragment() {

    private lateinit var bind: FragmentHomeExploreBinding
    private val eateryCategory = arrayOf("All","Canteen","Restaurant","Warteg")
    private val eateryDataRaw : ArrayList<Eatery> = arrayListOf(
        Eatery("Libro UMN", "Libro UMN", "Canteen",4.8, 0.1, ""),
        Eatery("Mie Ayam Bakso Wonogiri", "Mie Ayam Bakso Wonogiri", "Canteen", 4.5, 0.3, ""),
        Eatery("Lamian Palace", "Lamian Palace", "Restaurant", 4.9, 4.1, ""),
        Eatery("Nyapii!", "Nyapii!", "Restaurant", 5.0, 4.8, ""),
        Eatery("O! Fish", "O! Fish", "Restaurant", 4.8, 3.6, ""),
        Eatery("Sushi Naru", "Sushi Naru", "Restaurant", 4.2, 3.9, ""),
        Eatery("Pondok Makan", "Pondok Makan", "Warteg", 4.9, 2.8, ""),
        Eatery("Raos", "Raos", "Warteg", 4.8, 4.1, "")
    )

    private val exploreListener = object : HomeExploreListener {
        override fun onChangeNav(category: String) {
            Log.d("Explore", category)
            when (category.lowercase(Locale.getDefault())){
                "all" -> bind.rvExploreCard.swapAdapter(cardAllAdapter, false)
                "canteen" -> bind.rvExploreCard.swapAdapter(cardCanteenAdapter, false)
                "restaurant" -> bind.rvExploreCard.swapAdapter(cardRestaurantAdapter, false)
                "warteg" -> bind.rvExploreCard.swapAdapter(cardWartegAdapter, false)
            }
        }
        override fun goToDetailEatery(data: Eatery) {
            val intent = Intent(requireContext(), EateryActivity::class.java)
            intent.putExtra("data", data)
            requireActivity().startActivity(intent)
        }
    }
    private val cardAllAdapter: HomeExploreCardAdapter by lazy { HomeExploreCardAdapter(eateryDataRaw, exploreListener) }
    private val cardCanteenAdapter: HomeExploreCardAdapter by lazy {
        HomeExploreCardAdapter(eateryDataRaw.filter {
            it.category?.lowercase(Locale.getDefault()) ?: "" == "canteen"
        } as ArrayList<Eatery>, exploreListener)
    }
    private val cardRestaurantAdapter: HomeExploreCardAdapter by lazy {
        HomeExploreCardAdapter(eateryDataRaw.filter {
            it.category?.lowercase(Locale.getDefault()) ?: "" == "restaurant"
        } as ArrayList<Eatery>, exploreListener)
    }
    private val cardWartegAdapter: HomeExploreCardAdapter by lazy {
        HomeExploreCardAdapter(eateryDataRaw.filter {
            it.category?.lowercase(Locale.getDefault()) ?: "" == "warteg"
        } as ArrayList<Eatery>, exploreListener)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentHomeExploreBinding.inflate(inflater, container, false)

        val navAdapter = HomeExploreNavAdapter(eateryCategory, exploreListener)
        bind.rvExploreNav.adapter = navAdapter
        bind.rvExploreNav.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        bind.rvExploreCard.adapter = cardAllAdapter
        bind.rvExploreCard.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return bind.root
    }
}

private fun Intent.putExtra(s: String, data: EateryFireStore) {

}

