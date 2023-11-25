package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class WriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        val imageView: ImageView = findViewById(R.id.back2001)

        imageView.setOnClickListener {
            startActivity(Intent(this@WriteActivity, CommunityActivity::class.java))
        }
    }
}