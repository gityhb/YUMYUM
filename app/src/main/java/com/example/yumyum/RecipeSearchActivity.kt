package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yumyum.databinding.ActivityRecipeSearchBinding

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

        // 아이템 추가
        recipeList.add(RecipeItem("계란후라이", "계란, 소금", "10분"))
        recipeList.add(RecipeItem("멘보샤", "새우, 식빵", "30분"))
        recipeList.add(RecipeItem("고기구이", "고기, 후추, 기름장", "10분"))
        recipeList.add(RecipeItem("라면", "라면, 파", "3분"))
        // 리스트가 변경됨을 어댑터에 알림

    }
}