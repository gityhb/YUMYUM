package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.yumyum.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var dbHelper: DBHelper
    private lateinit var binding: ActivityMainBinding


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

        val navView: BottomNavigationView = binding.navView

        val partImg: ImageView = findViewById(R.id.food1)
        partImg.clipToOutline = true



        binding.food1.clipToOutline = true
        binding.food2.clipToOutline = true
        binding.food3.clipToOutline = true
        binding.food4.clipToOutline = true
        binding.food5.clipToOutline = true
        binding.food6.clipToOutline = true
        binding.food7.clipToOutline = true*/

        /*출처 : https://bada744.tistory.com/167*/

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


    }
}