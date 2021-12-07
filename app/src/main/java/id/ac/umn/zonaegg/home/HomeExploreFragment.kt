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
        Eatery("Libro UMN", "Libro UMN", "Canteen",4.8, 0.1, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Kantin%20UMN%2FLIBRO%20UMN%2FBackground.jpg?alt=media&token=c84834e6-469d-490e-8282-48fddfe79bf6"),
        Eatery("Mie Ayam Bakso Wonogiri", "Mie Ayam Bakso Wonogiri", "Canteen", 4.5, 0.3, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Kantin%20UMN%2FMie%20Ayam%20Bakso%20Wonogiri%2FBackground.jpg?alt=media&token=5db0ff06-77bb-409e-a3a8-fbcf8bf71d45"),
        Eatery("Lamian Palace", "Lamian Palace", "Restaurant", 4.9, 4.1, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Restoran%2FLamian%20Palace%2FBakpao%20Naga%20Durian%20Cropped.jpg?alt=media&token=60fbadb2-4aa7-45d1-9574-a640eb31eb34"),
        Eatery("Nyapii!", "Nyapii!", "Restaurant", 5.0, 4.8, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Restoran%2FNyapii!%2F120271355_104652764739956_2039778306485302658_n.jpg?alt=media&token=e0f2b9d0-1bef-47cb-803a-de893b059990"),
        Eatery("O! Fish", "O! Fish", "Restaurant", 4.8, 3.6, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Restoran%2FO!%20Fish%2Fpicture-1579230773.jpg?alt=media&token=4cc944e7-5c2f-4065-ac73-366d6c036076"),
        Eatery("Sushi Naru", "Sushi Naru", "Restaurant", 4.2, 3.9, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Restoran%2FSushi%20Naru%2FExterior-Sushi-Naru-by-Myfunfoodiary.jpg?alt=media&token=12479514-7742-4449-8b71-48b3c9e3ff3d"),
        Eatery("Pondok Makan", "Pondok Makan", "Warteg", 4.9, 2.8, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Warteg%2FPondok%20Makan%2FS__4448275.jpg?alt=media&token=1685d49d-f757-4f70-9536-e966bcc746d8"),
        Eatery("Raos", "Raos", "Warteg", 4.8, 4.1, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Warteg%2FRaos%2F31bab1f0119a40ee988e1ac5678ce4e0_1626622475335485125.jpeg?alt=media&token=8e3c216c-d06f-4f7b-9106-264606bd69f7")
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
