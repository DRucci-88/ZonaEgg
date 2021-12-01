package id.ac.umn.zonaegg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import id.ac.umn.zonaegg.databinding.ActivityLoginBinding
import java.lang.Exception

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back button
//        binding.loginBtnBack.setOnClickListener {
//            finish()
//        }

        // Login button
        binding.loginBtnLogin.setOnClickListener {
            var email = ""
            var password = ""

            // Try email
            try {
                email = binding.loginEtEmail.text.toString()
            }
            catch (e : Exception) {
                binding.loginTvEmailError.isVisible = true
            }

            // Try password
            try {
                password = binding.loginEtPassword.text.toString()
            }
            catch (e : Exception) {
                binding.loginTvPasswordError.isVisible = true
            }

            // If login data valid
            if (isLoginDataValid(email, password)) {

            }
            // If login data invalid
            else {

            }
        }
    }

    private fun isLoginDataValid(email : String, password : String) : Boolean {
        if (email == "" || password == "")
            return false
        return true
    }
}