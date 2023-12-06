package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yumyum.databinding.ActivityRecipeSearchBinding
import com.example.yumyum.recipe1.R1StartActivity

class RecipeSearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecipeSearchBinding
    val recipeList = arrayListOf<RecipeItem>()      // 아이템 배열
    val recipeAdapter = RecipesearchAdapter(recipeList){ clickedItem ->
        // 아이템 클릭 처리, 예를 들어 다른 액티비티로 이동
        val intent = Intent(this,RecipeStartActivity::class.java)
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

        val levelimg : ImageView= findViewById(R.id.level)

        // 아이템 추가
        recipeList.add(RecipeItem("동물모양쿠키", "우염버터 100g, 설탕 60g", "2시간"))
        recipeList.add(RecipeItem("멘보샤", "새우, 식빵", "30분"))
        recipeList.add(RecipeItem("고기구이", "고기, 후추, 기름장", "10분"))
        recipeList.add(RecipeItem("라면", "라면, 파", "3분"))
        // 리스트가 변경됨을 어댑터에 알림

        /* 레시피 검색부분, 출처는 gpt > 출처 수정예정 */
        val searchEditText: EditText = findViewById(R.id.recipe_search)

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                // 검색어가 변경될 때마다 아이템을 필터링하여 어댑터에 적용
                val filteredList = recipeList.filter { recipeItem ->
                    recipeItem.recipe.contains(s.toString(), ignoreCase = true)
                }

                recipeAdapter.updateList(filteredList)
            }
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

        val Recipe1: LinearLayout = findViewById(R.id.recipe_hard)
        Recipe1.setOnClickListener {
            startActivity(Intent(this, R1StartActivity::class.java))
        }

    } // onCreate
}