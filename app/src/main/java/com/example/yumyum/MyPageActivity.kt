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
                // FragmentManager를 통해 프래그먼트를 교체합니다.


                // 선택된 탭에 따라 프래그먼트를 설정합니다.
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
                    // 다른 탭에 대한 처리 추가 (등록한 레시피, 레시피 후기 등)
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // 탭이 다시 선택되었을 때의 동작을 추가할 수 있습니다.
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // 이전에 선택되었던 탭이 선택 해제되었을 때의 동작을 추가할 수 있습니다.
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