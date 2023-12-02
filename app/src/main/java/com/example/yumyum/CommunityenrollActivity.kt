package com.example.yumyum

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class CommunityenrollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_communityenroll)


        val buttonRegister = findViewById<Button>(R.id.button_register)
        val editTextContent2 = findViewById<EditText>(R.id.write_content)
        val editTextContent1 = findViewById<EditText>(R.id.write_title)

        buttonRegister.setOnClickListener {

            val title = editTextContent1.text.toString()
            val content = editTextContent2.text.toString()
            // 버튼이 눌리면 EditText에 있는 내용 저장

            val Listintent = Intent(this , ListActivity :: class.java)
            // 인텐트 생성

            Listintent.putExtra("Title", title) // .putExtra() 메소드로 데이터 전달준비
            Listintent.putExtra("Content", content)


            startActivity(Listintent) // 인텐트 실행
        }

        val imageView: ImageView = findViewById(R.id.back2002)

        imageView.setOnClickListener {
            startActivity(Intent(this@CommunityenrollActivity, CommunityActivity::class.java))
        }
    }
}