package com.example.yumyum.recipe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yumyum.R
import com.example.yumyum.RecipeSearchActivity
import com.example.yumyum.databinding.ActivityRecipeStartBinding

class R1StartActivity : AppCompatActivity() {
    lateinit var binding : ActivityRecipeStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val number = intent.getIntExtra("number", 0)
        val recipe = intent.getStringExtra("Recipe")
        val ingredient = intent.getStringExtra("Ingredient")
        val time = intent.getStringExtra("Time")
        val utensil = intent.getStringExtra("Utensil")
        val recipeimg = intent.getIntExtra("RecipeImg", R.drawable.food1)
        val step = intent.getStringExtra("Step")
        //val levelimg = intent.getStringExtra("LevelImg")

        val start_name: TextView = findViewById(R.id.cook_title)
        val start_ingredient: TextView = findViewById(R.id.cook_ingredient_detail)
        val start_time: TextView = findViewById(R.id.time)
        val start_step: TextView = findViewById(R.id.cook_steps)
        val start_img: ImageView = findViewById(R.id.cook_img)
        val start_utensil: TextView = findViewById(R.id.cook_tool_detail)

        start_name.text = recipe
        start_ingredient.text = ingredient
        start_time.text = time
        start_step.text = step
        start_utensil.text = utensil
        start_img.setImageResource(recipeimg)

        val backButton: ImageView = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            startActivity(Intent(this, RecipeSearchActivity::class.java))
        }

        val startButton: Button = findViewById(R.id.cook_start_btn)
        startButton.setOnClickListener {
            //val intent = Intent(this, R1ContinueActivity::class.java)
            intent.putExtra("Name", recipe)
            intent.putExtra("Img", recipeimg)
            //위 인텐트 2개는 마지막 피니시액티비티로 레시피명과 이미지 넘기는 것임

            if(number == 1)
                startActivity(Intent(this, R4ContinueActivity::class.java))
            else if(number == 2)
                startActivity(Intent(this, R3ContinueActivity::class.java))
            else if(number == 3)
                startActivity(Intent(this, R2ContinueActivity::class.java))
            else if(number == 4)
                startActivity(Intent(this, R1ContinueActivity::class.java))
            else if(number == 5)
                startActivity(Intent(this, R5ContinueActivity::class.java))
            else if(number == 6)
                startActivity(Intent(this, R6ContinueActivity::class.java))
            else
                Toast.makeText(this, "없음", Toast.LENGTH_SHORT).show()
        }

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