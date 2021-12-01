package id.ac.umn.zonaegg.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.umn.zonaegg.R
import id.ac.umn.zonaegg.data.Eatery
import id.ac.umn.zonaegg.databinding.FragmentHomeExploreBinding

class HomeExploreFragment : Fragment() {

    private lateinit var bind: FragmentHomeExploreBinding
    private val eateryCategory = arrayOf("All","Canteen","Restaurant","Warteg")
    private val eateryData = arrayOf(
        Eatery("Pondok", "Pondok", "Canteen", "4.8", 5f, R.drawable.sangkyuu_somuch_besto_frendo),
        Eatery("Pondok Lagi", "Pondok Lagi", "Warteg", "4.3", 4.5f, R.drawable.pepatah_kakek_kura_kura),
        Eatery("Restototo", "Restototo", "Restaurant", "4.9", 4.1f, R.drawable.swaq_face)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentHomeExploreBinding.inflate(inflater, container, false)

        val navAdapter = HomeExploreNavAdapter(eateryCategory)
        bind.rvExploreNav.adapter = navAdapter
        bind.rvExploreNav.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val cardAdapter = HomeExploreCardAdapter(eateryData)
        bind.rvExploreCard.adapter = cardAdapter
        bind.rvExploreCard.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return bind.root
    }
}

