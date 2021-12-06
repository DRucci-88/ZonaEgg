package id.ac.umn.zonaegg.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.umn.zonaegg.eatery.EateryActivity
import id.ac.umn.zonaegg.R
import id.ac.umn.zonaegg.data.Eatery
import id.ac.umn.zonaegg.databinding.FragmentHomeExploreBinding
import java.util.*
import kotlin.collections.ArrayList

class HomeExploreFragment : Fragment() {

    private lateinit var bind: FragmentHomeExploreBinding
    private val eateryCategory = arrayOf("All","Canteen","Restaurant","Warteg")
    private val eateryDataRaw : ArrayList<Eatery> = arrayListOf(
        Eatery("Pondok", "Pondok", "Canteen",4.8, 4.5, "https://firebasestorage.googleapis.com/v0/b/testing-firebase-50139.appspot.com/o/Kantin%20UMN%2FLIBRO%20UMN%2FEspresso.jpg?alt=media&token=b0b5447a-ab48-4036-8552-2c9c552152e7", ),
        Eatery("Pondok Lagi", "Pondok Lagi", "Warteg", 4.5, 4.8, "https://firebasestorage.googleapis.com/v0/b/testing-firebase-50139.appspot.com/o/Kantin%20UMN%2FLIBRO%20UMN%2FEspresso.jpg?alt=media&token=b0b5447a-ab48-4036-8552-2c9c552152e7"),
        Eatery("Restototo", "Restototo", "Restaurant", 4.9, 4.1, "https://firebasestorage.googleapis.com/v0/b/testing-firebase-50139.appspot.com/o/Kantin%20UMN%2FLIBRO%20UMN%2FEspresso.jpg?alt=media&token=b0b5447a-ab48-4036-8552-2c9c552152e7"),
        Eatery("Lazada", "Lazada", "Canteen", 5.0, 4.8, "https://firebasestorage.googleapis.com/v0/b/testing-firebase-50139.appspot.com/o/Kantin%20UMN%2FLIBRO%20UMN%2FEspresso.jpg?alt=media&token=b0b5447a-ab48-4036-8552-2c9c552152e7")
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

