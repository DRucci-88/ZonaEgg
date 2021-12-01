package id.ac.umn.zonaegg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import id.ac.umn.zonaegg.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back button
        binding.settingsBtnBack.setOnClickListener {
            finish()
        }

        // Dark theme button
        binding.settingsBtnDarkTheme.setOnClickListener {
            // If night mode is active
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            // If night mode is not active
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }

        // Getting started button
        binding.settingsBtnGettingStarted.setOnClickListener {
//            val gettingStarted = Intent(this, GettingStartedActivity::class.java)
//            startActivity(gettingStarted)
        }

        // Homepage button
        binding.settingsBtnHomepage.setOnClickListener {
            finish()
        }

        // Popular places button
        binding.settingsBtnPopularPlaces.setOnClickListener {

        }

        // Your favorites button
        binding.settingsBtnYourFavorites.setOnClickListener {

        }

        // Credits button
        binding.settingsBtnCredits.setOnClickListener {
            val credits = Intent(this, CreditsActivity::class.java)
            startActivity(credits)
        }
    }
}