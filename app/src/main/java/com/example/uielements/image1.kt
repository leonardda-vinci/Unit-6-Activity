package com.example.uielements

import android.app.*
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.RelativeLayout

class image1 : AppCompatActivity() {
    private var parentRelativeLayout: RelativeLayout? = null
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel : NotificationChannel
    lateinit var builder : Notification.Builder
    private val channelId = "i.apps.notifications"
    private val description = "Text notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image1)

        parentRelativeLayout = findViewById(R.id.parentRelativeLayout)

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

        )
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray)
        val songListView = findViewById<ListView>(R.id.songlv1)
        songListView.adapter = adapter

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        findViewById<Button>(R.id.showDialogBtn).setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)

            dialogBuilder.setMessage("Do you want to delete this song?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", DialogInterface.OnClickListener {
                        dialog, which ->
                            val intent = Intent(applicationContext, image1::class.java)
                            val pendingIntent = PendingIntent.getActivity(applicationContext, 0,
                                    intent, PendingIntent.FLAG_UPDATE_CURRENT)
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                notificationChannel = NotificationChannel(
                                        channelId,description,NotificationManager.IMPORTANCE_HIGH)
                                notificationChannel.enableLights(true)
                                notificationChannel.lightColor = Color.GREEN
                                notificationChannel.enableVibration(false)
                                notificationManager.createNotificationChannel(notificationChannel)

                                builder = Notification.Builder(this, channelId)
                                        .setContentTitle("Notification")
                                        .setContentText("Notification message")
                                        .setSmallIcon(R.drawable.ic_launcher_background)
                                        .setLargeIcon(BitmapFactory.decodeResource(this.resources,
                                        R.drawable.ic_launcher_background))
                                        .setContentIntent(pendingIntent)
                            } else {
                                builder = Notification.Builder(this)
                                        .setContentTitle("Notification")
                                        .setContentText("Notification message")
                                        .setSmallIcon(R.drawable.ic_launcher_background)
                                        .setLargeIcon(BitmapFactory.decodeResource(this.resources,
                                                R.drawable.ic_launcher_background))
                                        .setContentIntent(pendingIntent)
                            }
                        notificationManager.notify(1234,builder.build())
                    }).setNegativeButton("No", DialogInterface.OnClickListener {
                        dialog, which ->
                        dialog.cancel()
                    })

            val alert = dialogBuilder.create()

            alert.setTitle("Dialog")
            alert.show()
        }
    }

    fun onDelete(view: View) {
        parentRelativeLayout!!.removeView(view.parent as View)
    }
}
