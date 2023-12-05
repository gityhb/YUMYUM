package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.yumyum.databinding.ActivityRecipeFinishBinding

class StartActivity : AppCompatActivity() {
    lateinit var binding : ActivityRecipeFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            finish()
        }, 5000)
    }
}

/*출처: https://fre2-dom.tistory.com/67*/
