package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.yumyum.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var dbHelper: DBHelper
    private lateinit var binding: ActivityMainBinding

    private val imageViews = arrayOf(
        R.id.food1,
        R.id.food2,
        R.id.food3,
        R.id.food4,
        R.id.food5,
        R.id.food6,
        R.id.food7
    )

    //좋아요 이미지
    private val likeYesViews = arrayOf (
        R.id.like_yes1,
        R.id.like_yes2,
        R.id.like_yes3,
        R.id.like_yes4,
        R.id.like_yes5,
        R.id.like_yes6,
        R.id.like_yes7
    )

    private val likeNoViews = arrayOf(
        R.id.like_no1,
        R.id.like_no2,
        R.id.like_no3,
        R.id.like_no4,
        R.id.like_no5,
        R.id.like_no6,
        R.id.like_no7
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*dbHelper = DBHelper(this)

        val recipeList = dbHelper.generateRecipeList()

        // 레시피 리스트 순회하면서, 데이터베이스에 추가
        for(recipe in recipeList) {
            dbHelper.addRecipe(recipe)
        }*/

        /*val navView: BottomNavigationView = binding.navView

        val partImg: ImageView = findViewById(R.id.food1)
        partImg.clipToOutline = true*/

        binding.food1.clipToOutline = true
        binding.food2.clipToOutline = true
        binding.food3.clipToOutline = true
        binding.food4.clipToOutline = true
        binding.food5.clipToOutline = true
        binding.food6.clipToOutline = true
        binding.food7.clipToOutline = true

        /*출처 : https://bada744.tistory.com/167*/



        for(i in imageViews.indices) {
            val likeYes = findViewById<ImageView>(likeYesViews[i])
            val likeNo = findViewById<ImageView>(likeNoViews[i])

            likeYes.setOnClickListener{ toggleVisibility(likeYes, likeNo) }
            likeNo.setOnClickListener{ toggleVisibility(likeYes, likeNo) }
        }

        /*val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)*/

        val community: Button = findViewById(R.id.btn_community)
        community.setOnClickListener {
            startActivity(Intent(this, CommunityActivity::class.java))
        }

        val application: Button = findViewById(R.id.btn_recipe_application)
        application.setOnClickListener {
            startActivity(Intent(this, RecipeApplicationEnrollActivity::class.java))
        }

        val recipesearch: Button = findViewById(R.id.btn_recipe)
        recipesearch.setOnClickListener {
            startActivity(Intent(this, RecipeSearchActivity::class.java))
        }

        /* val community: Button = findViewById(R.id.btn_community)
        community.setOnClickListener {
            startActivity(Intent(this, CommunityActivity::class.java))
        }  재료활용 페이지로 이동 */

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.nav_view)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_other -> {
                    //사이드바 액티비티 넣기
                }
                R.id.navigation_my -> { //마이페이지로 이동
                    startActivity(Intent(this, MyPageActivity::class.java))
                }
            }
            true
        }


    } //onCreate

    private fun toggleVisibility(likeYes: ImageView, likeNo: ImageView) {
        if(likeYes.visibility == View.VISIBLE) {
            likeYes.visibility = View.GONE
            likeNo.visibility = View.VISIBLE
        } else {
            likeYes.visibility = View.VISIBLE
            likeNo.visibility = View.GONE
        }
    }
    /*출처: chatGPT*/
}
