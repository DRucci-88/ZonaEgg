package id.ac.umn.zonaegg

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import id.ac.umn.zonaegg.data.Eatery
import id.ac.umn.zonaegg.data.Serving
import id.ac.umn.zonaegg.databinding.ActivityTesting4Binding
import id.ac.umn.zonaegg.home.HomeExploreCardAdapter
import id.ac.umn.zonaegg.home.HomeExploreListener


class Testing4Activity : AppCompatActivity() {

    private lateinit var bind: ActivityTesting4Binding
//    private lateinit var list: ArrayList<Eatery>
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityTesting4Binding.inflate(layoutInflater)
        setContentView(bind.root)

        var list = ArrayList<Eatery>()
        var temp: Eatery

        db.collection("Kantin UMN")
            .get()
            .addOnSuccessListener { eateries ->
                for (eatery in eateries) {
                    var temps = eatery.data["zmenu"].toString()
                    val array = temps.split(",")
                        .map { it.split("=") }
                        .map { it.first() to it.last().toString() }
                        .toMap()
                    for (a in array) {
                        Log.d("testing4", "${a.key} => ${a.value}")
                    }
                }
            }
            .addOnFailureListener { exception ->
                Log.d("testing4", "Error getting documents: ", exception)
            }

//        Log.d("testing4", "FINAL : ${list.last().name!!}")
//        Log.d("testing4", list[0].name.toString())

        val testingListener = object : HomeExploreListener {
            override fun onChangeNav(category: String) {
            }
            override fun goToDetailEatery(data: Eatery) {
            }
        }

        bind.testingRv.adapter = HomeExploreCardAdapter(list, testingListener)
        bind.testingRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onStart() {
        super.onStart()

    }

//    private fun EventChangeListener(){
//
//        db= FirebaseFirestore.getInstance()
//        db.collection("").
//                addSnapshotListener(object : EventListener<QuerySnapshot>{
//                    override fun onEvent(
//                        value: QuerySnapshot?,
//                        error: FirebaseFirestoreException?
//                    ){
//
//
//
//                    }
//                })
//    }
}
