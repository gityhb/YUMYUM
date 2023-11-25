package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class CommunityenrollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_communityenroll)

        val imageView: ImageView = findViewById(R.id.back2002)

        imageView.setOnClickListener {
            startActivity(Intent(this@CommunityenrollActivity, CommunityActivity::class.java))
        }
    }
}