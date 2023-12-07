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
import com.example.yumyum.recipe.R1StartActivity

class RecipeSearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecipeSearchBinding
    val recipeList = arrayListOf<RecipeItem>()      // 아이템 배열

    val recipeAdapter = RecipesearchAdapter(recipeList){ clickedItem ->
        // 아이템 클릭 처리, 예를 들어 다른 액티비티로 이동
        val intent = Intent(this,R1StartActivity::class.java)
        intent.putExtra("Recipe", clickedItem.recipe)
        intent.putExtra("Ingredient", clickedItem.ingredient)
        intent.putExtra("Time", clickedItem.time)
        startActivity(intent)
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

        // 아이템 추가
        recipeList.add(RecipeItem("동물모양쿠키", "우염버터 100g, 설탕 60g", "2시간"))
        recipeList.add(RecipeItem("멘보샤", "새우, 식빵", "30분"))
        recipeList.add(RecipeItem("삼겹살볶음", "고기, 후추, 기름장", "10분"))
        recipeList.add(RecipeItem("라멘", "라면, 파", "35분"))
        recipeList.add(RecipeItem("스콘", "우염버터 150g, 설탕 60g", "2시간"))
        recipeList.add(RecipeItem("핫도그", "밀가루, 소세지", "57분"))
        recipeList.add(RecipeItem("참치김밥", "참치, 김, 오이", "45분"))
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


        var name = intent.getStringExtra("name")
        var ingredient = intent.getStringExtra("ingredient")
        var time = intent.getStringExtra("time")


        if (name != null && ingredient != null && time != null) {
            // 이름과 번호를 사용하여 새로운 ListItem 생성
            val newItem = RecipeItem(name, ingredient, time)

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