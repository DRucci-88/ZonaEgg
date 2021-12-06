package id.ac.umn.zonaegg

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import id.ac.umn.zonaegg.data.Eatery
import id.ac.umn.zonaegg.data.EateryFireStore
import id.ac.umn.zonaegg.data.Serving
import id.ac.umn.zonaegg.databinding.ActivityTesting5Binding
import id.ac.umn.zonaegg.home.HomeExploreCardAdapter
import id.ac.umn.zonaegg.home.HomeExploreListener
import java.util.*
import kotlin.collections.ArrayList


class Testing5Activity : AppCompatActivity() {

    private lateinit var bind: ActivityTesting5Binding
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityTesting5Binding.inflate(layoutInflater)
        setContentView(bind.root)

        var list = ArrayList<Eatery>()
        var temp: Eatery

        db.collection("Kantin UMN")
            .get()
            .addOnSuccessListener { eateries ->
                for (eatery in eateries) {
//                    val temp : Eatery = eatery.toObject(Eatery::class.java)
                    val temp : EateryFireStore = eatery.toObject<EateryFireStore>()
                    Log.d("testing5", temp.toString())
                }
            }
            .addOnFailureListener { exception ->
                Log.d("testing5", "Error getting documents: ", exception)
            }

        val testingListener = object : HomeExploreListener {
            override fun onChangeNav(category: String) {
            }
            override fun goToDetailEatery(data: Eatery) {
            }
        }

        bind.testing5Rv.adapter = HomeExploreCardAdapter(list, testingListener)
        bind.testing5Rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onStart() {
        super.onStart()

    }
}
