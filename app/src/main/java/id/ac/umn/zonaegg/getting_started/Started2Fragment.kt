package id.ac.umn.zonaegg.getting_started

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.umn.zonaegg.HomeActivity
import id.ac.umn.zonaegg.databinding.FragmentStarted2Binding

class Started2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bind = FragmentStarted2Binding.inflate(inflater, container, false)

        bind.btnStarted2Finish.setOnClickListener{
            val intent = Intent(requireContext(), HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            requireActivity().startActivity(intent)
        }

        return bind.root
    }

}