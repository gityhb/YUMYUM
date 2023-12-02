package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CommunityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community)


        var title = intent.getStringExtra("Title")
        var content = intent.getStringExtra("Content")

        val listTitleTextView = findViewById<TextView>(R.id.list_title)
        val listContentTextView = findViewById<TextView>(R.id.list_content)

        listTitleTextView.text = title
        listContentTextView.text = content

        val add_btn: ImageView = findViewById(R.id.add)
        val list_title: TextView = findViewById(R.id.list_title)

        list_title.setOnClickListener{
            val intent = Intent(this, CommunityenrollActivity::class.java)  // 인텐트를 생성해줌,
            intent.putExtra("Title", title)
            intent.putExtra("Content", content)
            startActivity(intent)
        } //제목 누르면 InnerActivity로


        add_btn.setOnClickListener{
            startActivity(Intent(this@CommunityActivity, CommunityenrollActivity::class.java))  // 인텐트를 생성해줌,
        } //+ 누르면 글쓰기창로
    }
}