package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class RecipeFinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_finish)

        val backButton: ImageView = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            startActivity(Intent(this, RecipeStartActivity::class.java))
        }

        val anotherButton: Button = findViewById(R.id.another_recipe_btn)
        anotherButton.setOnClickListener {
            startActivity(Intent(this, RecipeSearchActivity::class.java))
        }

        val replayButton: Button = findViewById(R.id.replay_recipe_btn)
        replayButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}