package com.example.uielements


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*


class Songs : AppCompatActivity() {
    private var parentRelativeLayout: RelativeLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_songs)
        parentRelativeLayout = findViewById(R.id.parentRelativeLayout)
        val songsArray = arrayOf("Living in a Ghost Town","You Should Be Sad" ,"Imported","In In In","Slide","Blueberry Faygo","Toosie Slide","My Truch","You're Too Precious","Tusa","Let Me Know","Dealer","Intentions","Charlie","Aries","RockStar","Good Bad Times")
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,songsArray)
        val songListView = findViewById<ListView>(R.id.songlv)
        songListView.adapter = adapter
        songListView.onItemClickListener = AdapterView.OnItemClickListener{parent,view,position,id ->
            Log.i("Position","Position $position")

            findViewById<Button>(R.id.showToastBtn).setOnClickListener {
                val toast = Toast.makeText(applicationContext, "Song has been removed", Toast.LENGTH_LONG)
                toast.show()
            }
        }

    }

    fun onDelete(view: View) {
        parentRelativeLayout!!.removeView(view.parent as View)
    }
}