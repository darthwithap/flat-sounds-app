package me.darthwithap.flatsounds.data

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object CategoryRepo {

  private const val TAG = "CategoryRepo"
  suspend fun getCategoryList(): List<String>? {
    val db = FirebaseFirestore.getInstance()
    return try {
      Log.d(
        TAG, "getCategoryList: ${
          db.collection("music")
            .document("categories").get().await()
        }"
      )
//      db.collection("music")
//        .document("categories").get().await()
      listOf("Music", "Podcasts", "Live Streams")
    } catch (e: Exception) {
//      FirebaseCrashlytics.getInstance().log("Error getting music collection details")
//      FirebaseCrashlytics.getInstance().recordException(e)
      null
    }
  }

//  private fun toListOfString(snap: DocumentSnapshot): String {
//
//  }
}