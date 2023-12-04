package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeStartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_start)

        val recipe = intent.getStringExtra("Recipe")
        val ingredient = intent.getStringExtra("Ingredient")
        val time = intent.getStringExtra("Time")

        val start_name: TextView = findViewById(R.id.recipe_name_start)
        val start_ingredient: TextView = findViewById(R.id.recipe_ingredient_start)
        val start_time: TextView = findViewById(R.id.recipe_time_start)

        start_name.text = recipe
        start_ingredient.text = ingredient
        start_time.text = time

        val recipe_start: Button = findViewById(R.id.StartButton)
        recipe_start.setOnClickListener {
            startActivity(Intent(this, RecipeContinueActivity::class.java))
        }

        val backButton: ImageView = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            startActivity(Intent(this, RecipeSearchActivity::class.java))
        }
    }
}