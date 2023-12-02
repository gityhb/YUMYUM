package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yumyum.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerBinding
    val itemList = arrayListOf<ListItem>()      // 아이템 배열
    val listAdapter = ListAdapter(itemList)     // 어댑터

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        val add_btn: ImageView = findViewById(R.id.add)

        add_btn.setOnClickListener{
            startActivity(Intent(this, CommunityenrollActivity::class.java))  // 인텐트를 생성해줌,
        } //+ 누르면 글쓰기창로


        /*item_list.setOnClickListener{
            val intent = Intent(this, WriteActivity::class.java)  // 인텐트를 생성해줌,
            intent.putExtra("Title", title)
            intent.putExtra("Content", content)
            startActivity(intent)
        } //제목 누르면 InnerActivity로*/
    }
}