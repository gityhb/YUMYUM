package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WriteActivity : AppCompatActivity(){

    private lateinit var commentList: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var toComment : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        commentList=ArrayList() //댓글 리스트 초기화

        //adapter = ArrayAdapter(this, R.layout.activity_inner, toComment)


        var title = intent.getStringExtra("Title")
        var content = intent.getStringExtra("Content")

        val innerTitleTextView = findViewById<TextView>(R.id.inner_title)
        val innerContentTextView = findViewById<TextView>(R.id.inner_content)

        innerTitleTextView.text = title
        innerContentTextView.text = content

        val add_comment_btn = findViewById<Button>(R.id.add_comment_btn)
        add_comment_btn.setOnClickListener{

        } //등록 버튼 누르면..


        val imageView: ImageView = findViewById(R.id.back2001)  //백버튼
        imageView.setOnClickListener {
            startActivity(Intent(this, CommunityActivity::class.java))
        }
    }
}