package com.example.yumyum

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout

class MyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)


        val tab1: TabLayout.Tab = tabLayout.newTab()
        tab1.text="찜한 레시피"
        tabLayout.addTab(tab1)

        val tab2: TabLayout.Tab = tabLayout.newTab()
        tab1.text="등록한 레시피"
        tabLayout.addTab(tab1)

        val tab3: TabLayout.Tab = tabLayout.newTab()
        tab1.text="레시피 후기"
        tabLayout.addTab(tab1)
    }
}