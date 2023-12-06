package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout



class MyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.text) {
                    "찜한 레시피" -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, LoveFragment())
                            .commit()
                    }
                    "등록한 레시피" -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, RegisterFragment())
                            .commit()
                    }
                    "레시피 후기" -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, ReviewFragment())
                            .commit()
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
        })

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, LoveFragment())
            .commit()


        val backButton: ImageView = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}