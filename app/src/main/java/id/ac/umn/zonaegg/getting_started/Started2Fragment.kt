package id.ac.umn.zonaegg.getting_started

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.umn.zonaegg.HomeActivity
import id.ac.umn.zonaegg.databinding.FragmentStarted2Binding
import id.ac.umn.zonaegg.getting_started.SplashFragment.Companion.GETTING_STARTED_SHARED
import id.ac.umn.zonaegg.getting_started.SplashFragment.Companion.GETTING_STARTED_STATUS

class Started2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bind = FragmentStarted2Binding.inflate(inflater, container, false)

        bind.btnStarted2Finish.setOnClickListener{
            onGettingStartedCompleted()
            val intent = Intent(requireContext(), HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            requireActivity().startActivity(intent)
        }

        return bind.root
    }

    private fun onGettingStartedCompleted(){
        val sharedPref = requireActivity().getSharedPreferences(GETTING_STARTED_SHARED, Context.MODE_PRIVATE)
        with(sharedPref.edit()){
            putBoolean(GETTING_STARTED_STATUS, true)
            apply()
        }
    }

}