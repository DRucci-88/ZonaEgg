package id.ac.umn.zonaegg.getting_started

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import id.ac.umn.zonaegg.R
import id.ac.umn.zonaegg.databinding.FragmentStarted0Binding

class Started0Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val bind = FragmentStarted0Binding.inflate(inflater, container, false)

        bind.btnGettingStarted.setOnClickListener {
//            requireActivity().findNavController(R.id.main_nav).navigate(R.id.action_started0Fragment_to_startedViewPagerFragment2)
            findNavController().navigate(R.id.action_started0Fragment_to_startedViewPagerFragment2)
        }

        return bind.root
    }
}

