package com.example.uielements

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val songsArray = arrayOf(
            "Kabilang Buhay",
            "Holy",
            "Mood",
            "Godzilla",
            "Mistletoe",
            "Beautiful Scars",
            "Intentions",
            "Mean it",
            "I'm the one",
            "Goodbyes",
            "Charlie",
            "Aries",
            "RockStar",
            "Good Bad Times"
            )

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray)
        val songListView = findViewById<ListView>(R.id.songlv1)
        songListView.adapter = adapter
        songListView.onItemLongClickListener = AdapterView.OnItemLongClickListener { _, _, _, _ ->
            Toast.makeText(this, "Long clicked", Toast.LENGTH_SHORT).show()
            true
            /*fun onItemLongClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (position == 0) {
                    val intent = Intent(this, QuedSongs::class.java)
                    startActivity(intent)
                }*/

        }
    }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            val inflater = menuInflater
            inflater.inflate(R.menu.main, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.song -> {
                    startActivity(Intent(this, Songs::class.java))
                    true
                }


                R.id.que -> {
                    startActivity(Intent(this, QuedSongs::class.java))
                    true
                }
                R.id.album -> {
                    startActivity(Intent(this, Album::class.java))
                    true
                }
                else -> super.onOptionsItemSelected(item)

            }

        }
    }
