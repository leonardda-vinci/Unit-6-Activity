package com.example.uielements

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Album : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        findViewById<ImageButton>(R.id.imageView).setOnClickListener {buttonimg1()}
        findViewById<ImageButton>(R.id.imageView2).setOnClickListener{buttonimg2()}
        findViewById<ImageButton>(R.id.imageView3).setOnClickListener{buttonimg3()}
    }
    private fun buttonimg1(){
        val intent =Intent(this@Album,image1::class.java)
        startActivity(intent)
    }

    private fun buttonimg2(){
        val intent1 = Intent(this,image2::class.java)
        startActivity(intent1)
    }

    private fun buttonimg3() {
        val intent2 = Intent( this, image3::class.java)
        startActivity(intent2)
    }
}