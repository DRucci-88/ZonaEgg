package id.ac.umn.zonaegg.eatery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.umn.zonaegg.R
import id.ac.umn.zonaegg.databinding.FragmentEateryReviewBinding


class EateryReviewFragment : Fragment() {

    private lateinit var bind: FragmentEateryReviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentEateryReviewBinding.inflate(inflater, container, false)



        return bind.root
    }
}