package com.example.yumyum

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yumyum.databinding.ActivityRecipeStartBinding

class RecipeStartActivity : AppCompatActivity() {
    lateinit var binding : ActivityRecipeStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val recipe = intent.getStringExtra("Recipe")
        val ingredient = intent.getStringExtra("Ingredient")
        val time = intent.getStringExtra("Time")

        val start_name: TextView = findViewById(R.id.recipe_name_start)
        val start_ingredient: TextView = findViewById(R.id.recipe_ingredient_start)
        val start_time: TextView = findViewById(R.id.recipe_time_start)

        start_name.text = recipe
        start_ingredient.text = ingredient
        start_time.text = time*/

        var cook_imgV : ImageView = findViewById(R.id.cook_img)
        var cook_titleV : TextView = findViewById(R.id.cook_title)
        var cook_userV : TextView = findViewById(R.id.enroll_user)
        var cook_timeV : TextView = findViewById(R.id.time)
        var cook_ingredient_detailV : TextView = findViewById(R.id.cook_ingredient_detail)
        var cook_tool_detail : TextView = findViewById(R.id.cook_tool_detail)
        /*var cook*/

        binding.likeYes.setOnClickListener {
            binding.likeYes.visibility = View.GONE
            binding.likeNo.visibility = View.VISIBLE
        }
        binding.likeNo.setOnClickListener{
            binding.likeNo.visibility = View.GONE
            binding.likeYes.visibility = View.VISIBLE
        }
    }
}