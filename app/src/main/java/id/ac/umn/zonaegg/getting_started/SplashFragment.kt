package id.ac.umn.zonaegg.getting_started

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import id.ac.umn.zonaegg.HomeActivity
import id.ac.umn.zonaegg.R
import id.ac.umn.zonaegg.Testing1Activity
import id.ac.umn.zonaegg.Testing2Activity
import id.ac.umn.zonaegg.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    companion object{
        const val GETTING_STARTED_SHARED = "gettingStarted"
        const val GETTING_STARTED_STATUS = "isFinished"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val bind = FragmentSplashBinding.inflate(inflater, container, false)

        Handler(Looper.getMainLooper()).postDelayed({
            if (checkGettingStartedStatus()){
                val intent = Intent(requireContext(), HomeActivity::class.java)
//                val intent = Intent(requireContext(), Testing1Activity::class.java)
//                val intent = Intent(requireContext(), Testing2Activity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                requireActivity().startActivity(intent)
            }
            else
                findNavController().navigate(R.id.action_splashFragment_to_started0Fragment)

        }, 300)

        return bind.root
    }

    private fun checkGettingStartedStatus() : Boolean {
        val sharedPref = requireActivity().getSharedPreferences(GETTING_STARTED_SHARED, Context.MODE_PRIVATE)
        return sharedPref.getBoolean(GETTING_STARTED_STATUS, false)
    }

}