package id.ac.umn.zonaegg.getting_started

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import id.ac.umn.zonaegg.R
import id.ac.umn.zonaegg.databinding.FragmentStarted1Binding

class Started1Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val bind = FragmentStarted1Binding.inflate(inflater, container, false)

        bind.btnStarted1Next.setOnClickListener{
            val viewPager = requireActivity().findViewById<ViewPager2>(R.id.started_view_pager)
            viewPager.setCurrentItem(1, true)
        }

        return bind.root
    }
}