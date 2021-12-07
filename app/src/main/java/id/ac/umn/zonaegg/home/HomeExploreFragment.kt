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
//        Eatery("Libro UMN", "Libro UMN", "Canteen",4.8, 0.1, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Kantin%20UMN%2FLIBRO%20UMN%2FBackground_Libro.jpg?alt=media&token=7f1b2188-71fd-4084-83e5-42f6e3146f51"),
        Eatery("Mie Ayam Bakso Wonogiri", "Mie Ayam Bakso Wonogiri", "Canteen", 4.5, 0.3, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Kantin%20UMN%2FMie%20Ayam%20Bakso%20Wonogiri%2FBackground_MieAyam.jpg?alt=media&token=7ba384ff-563f-4a41-a5ad-d26e894ea0c8"),
        Eatery("Lamian Palace", "Lamian Palace", "Restaurant", 4.9, 4.1, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Restoran%2FLamian%20Palace%2FBackground_Lamian.jpg?alt=media&token=08ff9dda-015b-4ad7-b6a6-a1d60a1dc559"),
        Eatery("Nyapii!", "Nyapii!", "Restaurant", 5.0, 4.8, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Restoran%2FNyapii!%2FBackground_Nyapii.jpg?alt=media&token=dfced3c9-1334-4f8d-b29c-0a8c5561c856"),
//        Eatery("O! Fish", "O! Fish", "Restaurant", 4.8, 3.6, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Restoran%2FO!%20Fish%2FBackground_Ofish.jpg?alt=media&token=7409cc4f-01b7-4ef9-80ea-db35be368ff1"),
//        Eatery("Sushi Naru", "Sushi Naru", "Restaurant", 4.2, 3.9, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Restoran%2FSushi%20Naru%2FBackground_Sushinaru.jpg?alt=media&token=cfe89b3f-ef0f-414f-b1cb-ad37d0ca985c"),
        Eatery("Pondok Makan", "Pondok Makan", "Warteg", 4.9, 2.8, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Warteg%2FPondok%20Makan%2FS__4448275.jpg?alt=media&token=1685d49d-f757-4f70-9536-e966bcc746d8"),
//        Eatery("Raos", "Raos", "Warteg", 4.8, 4.1, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Warteg%2FRaos%2F31bab1f0119a40ee988e1ac5678ce4e0_1626622475335485125.jpeg?alt=media&token=8e3c216c-d06f-4f7b-9106-264606bd69f7")
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
