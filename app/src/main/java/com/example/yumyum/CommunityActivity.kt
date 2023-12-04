package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yumyum.databinding.ActivityCommunityBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CommunityActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommunityBinding
    val itemList = arrayListOf<ListItem>()      // 아이템 배열
    val listAdapter = ListAdapter(itemList) { clickedItem ->
        // 아이템 클릭 처리, 예를 들어 다른 액티비티로 이동
        val intent = Intent(this, CommunityDetailActivity::class.java)
        intent.putExtra("Title", clickedItem.title)
        intent.putExtra("Content", clickedItem.content)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommunityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvList.adapter = listAdapter

        // 레이아웃 매니저와 어댑터 설정
        binding.rvList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvList.adapter = listAdapter

        // 아이템 추가
        itemList.add(ListItem("미역국 잘 끓이는 법", "알려주세용"))
        itemList.add(ListItem("멘보샤 먹고싶당", "이연복 레시피 아는 분?"))
        itemList.add(ListItem("다이어트 1일차", "같이하실 분 구해요 ㅎㅎ"))
        itemList.add(ListItem("신전 떡볶이", "신전 떡볶이 레시피 내놔"))
        itemList.add(ListItem("신전 떡볶이", "신전 떡볶이 레시피 내놔"))
        itemList.add(ListItem("신전 떡볶이", "신전 떡볶이 레시피 내놔"))
        itemList.add(ListItem("신전 떡볶이", "신전 떡볶이 레시피 내놔"))
        // 리스트가 변경됨을 어댑터에 알림

        var title = intent.getStringExtra("Title")
        var content = intent.getStringExtra("Content")


        if (title != null && content != null) {
            // 이름과 번호를 사용하여 새로운 ListItem 생성
            val newItem = ListItem(title, content)

            // itemList에 새로운 아이템 추가
            itemList.add(newItem)

            // 어댑터에 데이터 추가 및 갱신
            listAdapter.notifyDataSetChanged()
        }

        val add_btn: FloatingActionButton = findViewById(R.id.add)

        add_btn.setOnClickListener{
            startActivity(Intent(this, CommunityEnrollActivity::class.java))  // 인텐트를 생성해줌,
        } //+ 누르면 글쓰기창로


        val backButton: ImageView = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }


        add_btn.setOnClickListener{
            startActivity(Intent(this, CommunityEnrollActivity::class.java))  // 인텐트를 생성해줌,
        } //+ 누르면 글쓰기창로
    }
}