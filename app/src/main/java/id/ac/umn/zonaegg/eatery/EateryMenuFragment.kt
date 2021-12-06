package id.ac.umn.zonaegg.eatery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import id.ac.umn.zonaegg.R
import id.ac.umn.zonaegg.data.Serving
import id.ac.umn.zonaegg.databinding.FragmentEateryMenuBinding

//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

class EateryMenuFragment : Fragment() {

    private lateinit var bind: FragmentEateryMenuBinding
    private val servingData : ArrayList<Serving> = arrayListOf(
        /* Serving("1","Ikan Gurame Sambla Pete",40000F, R.drawable.ikan_gurame_sambal_pete),
        Serving("2","Nasi Ayam sambal pete",35000F, R.drawable.nasi_ayam_sambel_pete),
        Serving("3","Udang Sambal Pete",20000F, R.drawable.udang_sambel_pete),
        Serving("1","Ikan Gurame Sambla Pete",40000F, R.drawable.ikan_gurame_sambal_pete),
        Serving("2","Nasi Ayam sambal pete",35000F, R.drawable.nasi_ayam_sambel_pete),
        Serving("3","Udang Sambal Pete",20000F, R.drawable.udang_sambel_pete),
        Serving("1","Ikan Gurame Sambla Pete",40000F, R.drawable.ikan_gurame_sambal_pete),
        Serving("2","Nasi Ayam sambal pete",35000F, R.drawable.nasi_ayam_sambel_pete),
        Serving("3","Udang Sambal Pete",20000F, R.drawable.udang_sambel_pete), */

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentEateryMenuBinding.inflate(inflater, container, false)

        bind.rvEateryMenu.adapter = EateryAdapter(servingData)
        bind.rvEateryMenu.layoutManager = GridLayoutManager(requireContext(), 2)

        return bind.root
    }

}