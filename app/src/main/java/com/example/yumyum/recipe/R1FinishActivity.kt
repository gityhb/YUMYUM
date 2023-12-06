package com.example.yumyum.recipe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.yumyum.MainActivity
import com.example.yumyum.R
import com.example.yumyum.RecipeSearchActivity
import com.example.yumyum.databinding.ActivityRecipeFinishBinding

class R1FinishActivity : AppCompatActivity() {
    lateinit var binding : ActivityRecipeFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val backButton: ImageView = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            startActivity(Intent(this, R1StartActivity::class.java))
        }

        val anotherButton: Button = findViewById(R.id.another_recipe_btn)
        anotherButton.setOnClickListener {
            startActivity(Intent(this, RecipeSearchActivity::class.java))
        }

        val homeButton: Button = findViewById(R.id.replay_recipe_btn)
        homeButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        val drawable = resources.getDrawable(R.drawable.food7, null)
        /*출처: https://mainia.tistory.com/2016*/

        binding.fcookImg.setImageDrawable(drawable)
        binding.fcookTitle.text = "동물모양쿠키"

    } // onCreate
}