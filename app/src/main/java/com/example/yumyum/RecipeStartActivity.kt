package com.example.yumyum

import android.os.Bundle
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

    }
}