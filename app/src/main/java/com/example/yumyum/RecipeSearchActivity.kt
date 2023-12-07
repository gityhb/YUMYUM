package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yumyum.databinding.ActivityRecipeSearchBinding

class RecipeSearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecipeSearchBinding
    val recipeList = arrayListOf<RecipeItem>()      // 아이템 배열

    val recipeAdapter = RecipesearchAdapter(recipeList){ clickedItem ->
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcList.adapter = recipeAdapter

        // 레이아웃 매니저와 어댑터 설정
        binding.rcList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcList.adapter = recipeAdapter

        //RecipeItem(val recipe: String, val ingredient:String, val time:String, val utensil: String, val step: String, val recipeimg: Drawable,  val levelimg: Drawable)

        recipeList.add(RecipeItem("동물모양 쿠키", "무염버터 100g, 설탕 60g", "2시간", "제과제빵용 주걱, 제과제빵용 붓, 종이호일, 체, 랩, 믹싱볼(그릇)", "1.설탕, 소금, 베이킹파우더, 중력분을 섞어 30분간 냉장한다.\n2.버터를 1cm x 1cm씩 깍둑썰어서 30분간 냉장한다.\n3.계란과 우유를 섞어서 30분간 냉장한다.\n4.냉장시킨 가루를 체 쳐서 볼에 넣는다.\n5.차가운 버터를 넣고 쌀알만큼 작아질 때까지 다진다.(버터가 녹지 않도록 신속하게 하는 것이 중요하다.)\n6.가운데 홈을 파서 수분재료(계란+우유)를 넣어 흡수시킨 후 다시 다진다.\n7.날가루가 보이지 않으면 사각형으로 대충 뭉친다.(손을 사용하지 않는다.)\n8.사각형을 반으로 잘라 포개 겹치는 것을 3-4회 반복한다.\n9.반죽을 랩에 싸서 1시간 냉장한다.\n10.75-85g 정도로 잘라 반죽을 접어 까준다는 느낌으로 모양을 만든다.",
                R.drawable.food7, R.drawable.level_easy))
        recipeList.add(RecipeItem("머핀", "박력분 340g, 설탕 340g, 바닐라파우더 4g, 계란 4개, 버터 340g, 베이킹파우더 4g, 소금 4g", "2시간", "믹싱볼, 체, 거품기, 제과제빵용 주걱, 짤주머니, 틀", "1.계란을 풀어 반죽을 준비한다.\n2.버터에 설탕을 여러번 나누어 넣으면서 녹인다.\n3.설탕과 버터를 잘 섞었다면 풀어둔 계란을 세번을 나눠 넣어 섞어준다.\n4.박력분과 베이킹파우더, 바닐라파우더, 소금을 체에 내려준다.\n5.오븐을 170도-180도에서 예열해준다.\n6.짤주머니에 주걱으로 잘 넣어서 매듭을 집게로 집어준 후 틀에 반죽을 넣어주고 위에 토핑을 넣어준다.\n7.170도에서 20분 구워준다.", R.drawable.food8, R.drawable.level_easy))
        recipeList.add(RecipeItem("닭발", "무뼈닭발 500g, 통후추 2스푼, 생강 1톨, 고추장 3스푼, 고춧가루 2스푼, 간장 3스푼, 올리고당 1스푼, 다진 마늘 2스푼, 식용유", "시간", "프라이팬, 주걱, 냄비, 칼", "1.닭발을 해동시켜 깨끗이 씻는다.\n2.닭발이 잠길 정도로 물을 넣고 통후추 2스푼과 생강 1톨과 함께 10분정도 삶는다.\n3.삶은 닭발을 찬물에 깨끗이 씻는다.\n4.닭발에 고추장 3스푼과 고춧가루 2스푼, 간장 2스푼, 올리고당 1스푼을 넣고 버무린다.\n5.30분동안 재워둔다.\n6.달구워진 팬에 식용유를 두르고 재워둔 닭발을 넣고 볶는다.\n7.약한 불에 10분정도 조려준다.",
                R.drawable.food6, R.drawable.level_nomal))
        recipeList.add(RecipeItem("스콘", "무염버터 100g, 설탕 40g, 소금 2g, 베이킹파우터 2g, 계랸 50g, 우유 50g, 중력분 220g(초코: 중력분 200g, 코코아 가루: 20g)", "3시간", "제과제빵용 주걱, 제과제빵용 붓, 종이호일, 체, 랩, 믹싱볼(그릇)", "1.설탕, 소금, 베이킹파우더, 중력분을 섞어 30분간 냉장한다.\n2.버터를 1cm x 1cm씩 깍둑썰어서 30분간 냉장한다.\n3.계란과 우유를 섞어서 30분간 냉장한다.\n4.냉장시킨 가루를 체 쳐서 볼에 넣는다.\n5.차가운 버터를 넣고 쌀알만큼 작아질 때까지 다진다.(버터가 녹지 않도록 신속하게 하는 것이 중요하다.)\n6.가운데 홈을 파서 수분재료(계란+우유)를 넣어 흡수시킨 후 다시 다진다.\n7.날가루가 보이지 않으면 사각형으로 대충 뭉친다.(손을 사용하지 않는다.)\n8.사각형을 반으로 잘라 포개 겹치는 것을 3-4회 반복한다.\n9.반죽을 랩에 싸서 1시간 냉장한다.\n10.75-85g 정도로 잘라 반죽을 접어 까준다는 느낌으로 모양을 만든다.\n11.달걀물을 반죽 표면 위에 얇게 바른다.\n12.오븐 190도 10분 예열 후 180도에서 20분간 굽는다.",
                R.drawable.food9, R.drawable.level_nomal))
        recipeList.add(RecipeItem("라멘", "라멘 생면 1인분, 마늘 1/2t, 생강 1/2t, 설탕, 1t, 참기름 1t, 미소, 1T, 돼지고기 150g, 삷은 계랸 1개, 두반장", "1시간", "프라이팬, 냄비, 주걱, 집게",
            "1.생강을 다진다.\n2.대파는 채썰어서 찬물에 담가둔다.\n3.숙주를 씻어서 물기를 빼놓는다.\n4.삶은 계란은 반으로 잘라 놓는다.\n5.팬에 오일을 살짝만 두르고 돼지고기 간 것과 생강을 주걱으로 볶는다.\n6.두반장, 미소, 설탕을 넣고, 물 1/4컵을 붓고 조린다.\n7.다른 냄비에 참기를 1t을 두르고 마늘, 생강 1/2t씩 넣고 볶는다.\n8.이후 물 400ml, 미소 1T도 잘 풀어넣어준다.\n9.끓는 물에 면을 2분간 삶는다.\n10.면은 물기를 털고 그릇에 넣어준 뒤 면을 넣어준다.\n11.고기와 숙주, 계란으로 토핑한다.", R.drawable.food11, R.drawable.level_easy))
        recipeList.add(RecipeItem("연어초밥", "연어회 200g, 밥 1공기, 간장 1T, 와사비 1/2T, 소금 1t, 설탕 2t, 식초 3t", "1시간", "볼, 도마 위생장갑, 조리용 나이프, 접시, 숟가락", "1.소금, 설탕, 식초를(1:2:3)에 맞춰 만든다.\n2.단촛물을 전자레인지에 넣고 10초간 돌려주고 잘 저어준다.\n3.그릇에 밥 한 공기를 넣고 단촛물 4t을 넣어 잘 섞어 준다.\n4.연어회가 덩어리라면 먹기 좋은 크기로 썰어준다.\n5.위생장갑을 끼고 밥을 뭉쳐준 뒤 와사비를 묻힌다.\n6.위에 연어회 슬라이스 올려준다.", R.drawable.food10, R.drawable.level_easy))
        recipeList.add(RecipeItem("우니덮밥", "밥 1공기, 성게알 40-50g, 양파 1/4개, 어린잎 채소 작은 한줌, 김가루, 참기름 2t, 식초 1T,0 설탕 0.5T, 소금 한 꼬집", "1시간", "도마, 칼, 그릇, 작은 볼, 숟가락", "1.양파를 채 썰어 찬물에 담가둔다.\n2.설탕, 소금, 식초를 작은 볼에 넣고 녹여준다.\n3.따뜻한 밥에 단촛물을 넣고 섞어준다.\n4.양파와 채소, 우니 물기를 제거한다.\n5.그릇에 밥을 넣고 물기를 제거한 양파와 채소, 우니를 얹는다.\n6.쪽파와 김가루를 뿌린 뒤 참기름을 뿌려준다.", R.drawable.food11, R.drawable.level_easy))
        
        // 리스트가 변경됨을 어댑터에 알림

        /* 레시피 검색부분, 출처는 gpt > 출처 수정예정 */
        val searchEditText: EditText = findViewById(R.id.recipe_search)

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                // 검색어가 변경될 때마다 아이템을 필터링하여 어댑터에 적용
                val filteredList = recipeList.filter { recipeItem ->
                    containsKorean(recipeItem.recipe, s.toString())
                }

                recipeAdapter.updateList(filteredList)
            }

            // 한글 검색 가능하게 하기> gpt
            fun decomposeHangul(s: Char): String {
                if (s >= '가' && s <= '힣') {
                    val uniVal = s - '가'
                    val cho = uniVal / 588
                    val jung = (uniVal % 588) / 28
                    val jong = uniVal % 28
                    return "${chosung[cho]}${jungsung[jung]}${jongsung[jong]}"
                }
                return s.toString()
            }

            fun containsKorean(original: String, search: String): Boolean {
                val decomposedOriginal = original.map { decomposeHangul(it) }.joinToString("")
                val decomposedSearch = search.map { decomposeHangul(it) }.joinToString("")
                return decomposedOriginal.contains(decomposedSearch, ignoreCase = true)
            }

            val chosung = arrayOf("ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ")
            val jungsung = arrayOf("ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ", "ㅗ", "ㅘ", "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ", "ㅣ")
            val jongsung = arrayOf("", "ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ", "ㄹ", "ㄺ", "ㄻ", "ㄼ", "ㄽ", "ㄾ", "ㄿ", "ㅀ", "ㅁ", "ㅂ", "ㅄ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ")
        })



        /*/신청페이지에서 받을때, 수정해야함

        var name = intent.getStringExtra("name")
        var ingredient = intent.getStringExtra("ingredient")
        var time = intent.getStringExtra("time")
        var utensil = intent.getStringExtra("utensil")
        var step = intent.getStringExtra("Step")
        var recipeimg = intent.getIntExtra("recipeimg",  R.drawable.food4)
        var levelimg = intent.getIntExtra("levelimg", R.drawable.img1)



        if (name != null && ingredient != null && time != null && utensil !=null && step !=null) {
            // 이름과 번호를 사용하여 새로운 ListItem 생성
            val newItem = RecipeItem(name, ingredient, time, utensil, step, recipeimg, levelimg)

            // itemList에 새로운 아이템 추가
            recipeList.add(newItem)

            // 어댑터에 데이터 추가 및 갱신
            recipeAdapter.notifyDataSetChanged()
        }*/

        val backButton: ImageView = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }



    } // onCreate

}