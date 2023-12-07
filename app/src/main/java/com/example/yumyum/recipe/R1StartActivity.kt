package com.example.yumyum.recipe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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
            val intent = Intent(this, R1ContinueActivity::class.java)
            intent.putExtra("Name", recipe)
            intent.putExtra("Img", recipeimg)
            startActivity(intent)
        }


        //val drawable = resources.getDrawable(R.drawable.food7, null)
        /*출처: https://mainia.tistory.com/2016*/

        //binding.cookImg.setImageDrawable(drawable)
        /*binding.time.text = "2시간"
        binding.cookTitle.text = "동물모양쿠키"
        binding.cookIngredientDetail.text = "무염버터 100g, 설탕 60g, 소금 1g, 계란 30g, 바닐라익스트랙, 베이킹파우더 2g, 박력분 200g(초코: 박력분 180g, 코코아가루 20g)"*/
        //binding.cookToolDetail.text = "제과제빵용 주걱, 종이호일, 체, 쟁반, 밀대, 믹싱볼(그릇), 쿠키틀(쿠키커터)"
        /*binding.cookSteps.text = "1. 버터가 말랑해지도록 실온에 둔 후 볼에 넣고 풀어준다.\n\n" +
                "2. 설탕과 소금을 넣고 버터색이 약간 밝아질 때까지 주걱으로 잘 섞는다.\n\n" +
                "3. 계랸을 2번에 나누어 넣으면서 섞어준다.\n\n" +
                "4. 박력분과 베이킹파우더를 체 쳐서 넣는다.\n\n" +
                "5. 반죽이 뭉쳐질 때까지 주걱을 수직으로 세워 자르듯 섞는다.\n\n" +
                "6. 뭉쳐진 반죽을 살살 눌러서 매끈한 상태로 만든다.(너무 많이 치대지 않는다.)\n\n" +
                "7. 반죽을 종이호일에 넣어 약 0.5cm 두꼐로 균일하게 핀다.(비닐봉지도 가능하다.)\n\n" +
                "8. 핀 반죽을 쟁반에 담아 40분간 냉장한다.\n\n" +
                "9. 반죽에 모양틀을 찍어낸다.\n\n" +
                "10. 오븐 170도 15분 예열 후 170도에서 13-15분간 굽는다.\n\n" +
                "11. 오븐에서 꺼낸 후 5분간 식힌다."*/

        //이후 구현 계획 코드
        /*var cook_imgV : ImageView = findViewById(R.id.cook_img)
        var cook_titleV : TextView = findViewById(R.id.cook_title)
        var cook_userV : TextView = findViewById(R.id.enroll_user)
        var cook_timeV : TextView = findViewById(R.id.time)
        var cook_ingredient_detailV : TextView = findViewById(R.id.cook_ingredient_detail)
        var cook_tool_detail : TextView = findViewById(R.id.cook_tool_detail)*/

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