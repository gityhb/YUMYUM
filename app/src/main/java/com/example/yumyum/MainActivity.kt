package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.yumyum.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var dbHelper: DBHelper
    private lateinit var binding: ActivityMainBinding
    private val fragmentManager: FragmentManager = supportFragmentManager
    private val sidebarFragment: SidebarFragment = SidebarFragment()

    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: MainPagerAdapter
    private val handler = Handler()
    private lateinit var runnable: Runnable
    private fun replaceFragment(fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(
            R.id.sidebar_frame,
            fragment
        )  // R.id.fragment_container는 교체될 프래그먼트를 보여줄 레이아웃 ID로 변경
        transaction.commit()
    }

    private val imageViews = arrayOf(
        R.id.food1,
        R.id.food2,
        R.id.food3,
        R.id.food4,
        R.id.food5,
        R.id.food6,
        R.id.food7,
        R.id.food8,
        R.id.food9,
        R.id.food10,
        R.id.food11
    )

    //좋아요 이미지
    private val likeYesViews = arrayOf(
        R.id.like_yes1,
        R.id.like_yes2,
        R.id.like_yes3,
        R.id.like_yes4,
        R.id.like_yes5,
        R.id.like_yes6,
        R.id.like_yes7,
        R.id.like_yes8,
        R.id.like_yes9,
        R.id.like_yes10,
        R.id.like_yes11
    )

    private val likeNoViews = arrayOf(
        R.id.like_no1,
        R.id.like_no2,
        R.id.like_no3,
        R.id.like_no4,
        R.id.like_no5,
        R.id.like_no6,
        R.id.like_no7,
        R.id.like_no8,
        R.id.like_no9,
        R.id.like_no10,
        R.id.like_no11
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (i in imageViews.indices) {
            val likeYes = findViewById<ImageView>(likeYesViews[i])
            val likeNo = findViewById<ImageView>(likeNoViews[i])

            likeYes.setOnClickListener { toggleVisibility(likeYes, likeNo) }
            likeNo.setOnClickListener { toggleVisibility(likeYes, likeNo) }
        }

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

        val ingredientsearch: Button = findViewById(R.id.btn_ingredient_search)
        ingredientsearch.setOnClickListener {
            startActivity(Intent(this, IngredientSearchActivity::class.java))
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.nav_view)

        bottomNavigationView.menu.findItem(R.id.navigation_home)?.isChecked = true

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_other -> {  //사이드바로 이동
                    replaceFragment(sidebarFragment)
                }

                R.id.navigation_home -> { //홈으로 이동
                    startActivity(Intent(this, MainActivity::class.java))
                }

                R.id.navigation_my -> { //마이페이지로 이동
                    startActivity(Intent(this, MyPageActivity::class.java))
                }
            }
            true
        }

        viewPager = binding.foodViewPager
        adapter = MainPagerAdapter()
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })

        // 3초마다 Runnable을 실행하여 다음 페이지로 전환
        runnable = object : Runnable {
            override fun run() {
                val currentItem = viewPager.currentItem
                val nextItem = (currentItem + 1) % adapter.itemCount
                viewPager.setCurrentItem(nextItem, true)
                handler.postDelayed(this, 3000)
            }
        }
        // 처음 3초 뒤에 시작하고 반복
        handler.postDelayed(runnable, 3000)

        //좋아요 기능
        if (binding.likeYes8.visibility == View.GONE) {
            binding.fl4.visibility = View.GONE

        }
        if (binding.likeYes9.visibility == View.GONE) {
            binding.fl5.visibility = View.GONE
        }
        if (binding.likeYes10.visibility == View.GONE) {
            binding.fl6.visibility = View.GONE
        }
        if (binding.likeYes11.visibility == View.GONE) {
            binding.fl7.visibility = View.GONE
        }
    } //onCreate

    override fun onDestroy() {
        // 액티비티가 소멸될 때 핸들러의 Runnable을 제거하여 메모리 누수 방지
        handler.removeCallbacks(runnable)
        super.onDestroy()
    }

    private class MainPagerAdapter : RecyclerView.Adapter<MainPagerViewHolder>() {
        private val imageResIds = intArrayOf(
            R.drawable.viewp1,
            R.drawable.viewp2,
            R.drawable.viewp3,
            R.drawable.viewp4,
            R.drawable.viewp5,
            R.drawable.viewp6,
            R.drawable.viewp7
        )

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainPagerViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.viewpager_item, parent, false)
            return MainPagerViewHolder(view)
        }

        override fun onBindViewHolder(holder: MainPagerViewHolder, position: Int) {
            holder.bind(imageResIds[position])
        }

        override fun getItemCount(): Int = imageResIds.size
    }

    private class MainPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.slide_img)

        fun bind(imageResIds: Int) {
            imageView.setImageResource(imageResIds)
        }
    }
    /*출처: chatGPT*/

    private fun toggleVisibility(likeYes: ImageView, likeNo: ImageView) {
        if (likeYes.visibility == View.VISIBLE) {
            likeYes.visibility = View.GONE
            likeNo.visibility = View.VISIBLE

            //좋아요 찜한 레시피
            if (binding.likeYes1.visibility == View.GONE) {
                binding.fl4.visibility = View.GONE
                binding.likeNo8.visibility = View.VISIBLE
                binding.likeYes8.visibility = View.GONE
                binding.likeYes1.visibility = View.VISIBLE
            }
            if (binding.likeYes2.visibility == View.GONE) {
                binding.fl5.visibility = View.GONE
                binding.likeNo9.visibility = View.VISIBLE
                binding.likeYes9.visibility = View.GONE
                binding.likeYes2.visibility = View.VISIBLE
            }

            if (binding.likeYes3.visibility == View.GONE) {
                binding.fl6.visibility = View.GONE
                binding.likeNo10.visibility = View.VISIBLE
                binding.likeYes10.visibility = View.GONE
                binding.likeYes3.visibility = View.VISIBLE
            }

            if (binding.likeYes4.visibility == View.GONE) {
                binding.fl7.visibility = View.GONE
                binding.likeNo11.visibility = View.VISIBLE
                binding.likeYes11.visibility = View.GONE
                binding.likeYes4.visibility = View.VISIBLE
            }

            if (binding.likeYes5.visibility == View.GONE)
                binding.fl1.visibility = View.GONE

            if (binding.likeYes6.visibility == View.GONE)
                binding.fl2.visibility = View.GONE

            if (binding.likeYes7.visibility == View.GONE)
                binding.fl3.visibility = View.GONE

            if (binding.likeYes8.visibility == View.GONE) {
                binding.fl4.visibility = View.GONE
            }
            if (binding.likeYes9.visibility == View.GONE) {
                binding.fl5.visibility = View.GONE
            }
            if (binding.likeYes10.visibility == View.GONE) {
                binding.fl6.visibility = View.GONE
            }
            if (binding.likeYes11.visibility == View.GONE) {
                binding.fl7.visibility = View.GONE
            }

        } else {
            likeYes.visibility = View.VISIBLE
            likeNo.visibility = View.GONE

            //좋아요 찜한 레시피
            if (binding.likeNo8.visibility == View.GONE) {
                binding.fl4.visibility = View.VISIBLE
            }
            if (binding.likeNo9.visibility == View.GONE) {
                binding.fl5.visibility = View.VISIBLE
            }
            if (binding.likeNo10.visibility == View.GONE) {
                binding.fl6.visibility = View.VISIBLE
            }
            if (binding.likeNo11.visibility == View.GONE) {
                binding.fl7.visibility = View.VISIBLE
            }
        }
    }
}