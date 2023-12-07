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

        recipeList.add(RecipeItem("동물모양 쿠키", "우염버터 100g, 설탕 60g", "2시간", "제과제빵용 주걱, 제과제빵용 붓, 종이호일, 체, 랩, 믹싱볼(그릇)", "\"넘어가나?설탕, 소금, 베이킹파우더, 중력분을 섞어 30분간 냉장한다.\", \"버터를 1cm x 1cm씩 깍둑썰어서 30분간 냉장한다.\", \"계란과 우유를 섞어서 30분간 냉장한다.\", \"냉장시킨 가루를 체 쳐서 볼에 넣는다.\", \"차가운 버터를 넣고 쌀알만큼 작아질 때까지 다진다.(버터가 녹지 않도록 신속하게 하는 것이 중요하다.)\", \"가운데 홈을 파서 수분재료(계란+우유)를 넣어 흡수시킨 후 다시 다진다.\",\n" +
                "            \"날가루가 보이지 않으면 사각형으로 대충 뭉친다.(손을 사용하지 않는다.)\", \"사각형을 반으로 잘라 포개 겹치는 것을 3-4회 반복한다.\", \"반죽을 랩에 싸서 1시간 냉장한다.\", \"75-85g 정도로 잘라 반죽을 접어 까준다는 느낌으로 모양을 만든다.\"",
            R.drawable.food7, R.drawable.level_easy))
        recipeList.add(RecipeItem("머핀", "재료", "시간", "식기구", "순서", R.drawable.food8, R.drawable.level_nomal))
        recipeList.add(RecipeItem("닭발", "재료", "시간", "식기구", "순서", R.drawable.food8, R.drawable.level_nomal))
        recipeList.add(RecipeItem("오소정", "재료", "시간", "식기구", "순서", R.drawable.food8, R.drawable.level_nomal))
        recipeList.add(RecipeItem("윤혜빈", "재료", "시간", "식기구", "순서", R.drawable.food8, R.drawable.level_nomal))
        recipeList.add(RecipeItem("송수빈", "재료", "시간", "식기구", "순서", R.drawable.food8, R.drawable.level_nomal))
        recipeList.add(RecipeItem("위아원", "재료", "시간", "식기구", "순서", R.drawable.food8, R.drawable.level_nomal))
        
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

        
        
        //신청페이지에서 받을때, 수정해야함

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
        }

        val backButton: ImageView = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }



    } // onCreate
}