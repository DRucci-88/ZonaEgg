package id.ac.umn.zonaegg.getting_started

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.umn.zonaegg.HomeActivity
import id.ac.umn.zonaegg.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val bind = FragmentSplashBinding.inflate(inflater, container, false)

        Handler(Looper.getMainLooper()).postDelayed({
//            findNavController().navigate(R.id.action_splashFragment_to_started0Fragment)
            val intent = Intent(requireContext(), HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            requireActivity().startActivity(intent)
        }, 300)



        return bind.root
    }

}