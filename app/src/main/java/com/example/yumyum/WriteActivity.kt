package com.example.yumyum

import CommentAdapter
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yumyum.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWriteBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("Title")
        val content = intent.getStringExtra("Content")

        val innerTitleTextView: TextView = findViewById(R.id.inner_title)
        val innerContentTextView: TextView = findViewById(R.id.inner_content)

        innerTitleTextView.text = title
        innerContentTextView.text = content

        val commentList = arrayListOf<CommentItem>()
        val commentAdapter = CommentAdapter(commentList)

        val addCommentBtn: Button = findViewById(R.id.add_comment_btn)
        addCommentBtn.setOnClickListener {
            // 댓글 추가 버튼 눌렸을 때의 동작 구현
            val writer = "익명" // 적절한 방식으로 작성자 정보를 가져와야 합니다.
            val commentContent = findViewById<EditText>(R.id.add_comment)

            // CommentItem 생성
            val newComment = CommentItem(writer, commentContent.text.toString())

            // commentList에 새로운 댓글 아이템 추가
            commentList.add(newComment)

            // 어댑터에 데이터 변경 알림
            commentAdapter.notifyDataSetChanged()
        }

        /*val backButton: ImageView = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            startActivity(Intent(this, RecyclerActivity::class.java))
        }*/

        binding.coList.adapter = commentAdapter

        // 레이아웃 매니저 설정
        binding.coList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // 아이템 추가
        commentList.add(CommentItem("익명", "ㅋㅋㅋ"))

        // 어댑터에 데이터 변경 알림
        commentAdapter.notifyDataSetChanged()
    }
    }
