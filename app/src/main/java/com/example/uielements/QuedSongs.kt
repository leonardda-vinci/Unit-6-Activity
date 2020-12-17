package com.example.uielements

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import com.google.android.material.snackbar.Snackbar

class QuedSongs : AppCompatActivity() {
    private var parentRelativeLayout: RelativeLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qued_songs)

        findViewById<Button>(R.id.showSnackbarBtn).setOnClickListener {
            val snack = Snackbar.make(it, "Song has been added", Snackbar.LENGTH_LONG)
            snack.setAction("Songs", View.OnClickListener {
            startActivity(Intent(applicationContext, QuedSongs::class.java))
            })
            snack.show()
        }
    }

    fun onAddSong(view: View) {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var rowView: View = inflater.inflate(R.layout.activity_qued_songs, null)
        parentRelativeLayout!!.addView(rowView, parentRelativeLayout!!.childCount)
    }
}
