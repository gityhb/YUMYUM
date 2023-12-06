package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.yumyum.databinding.ActivityMyPageBinding
import com.google.android.material.tabs.TabLayout



class MyPageActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbHelper = DBHelper(this)
        val db = dbHelper.readableDatabase

        if(dbHelper.isUserLoggedIn()) {
            val userInfo = dbHelper.getUserInfo(db)

            if(userInfo != null) { // 사용자 정보가 있는 경우
                binding.userNk.text = "${userInfo?.nickname}"
                binding.userEmail.text = "${userInfo?.email}"
                binding.userEmail.visibility = View.VISIBLE
                binding.logIn.visibility = View.GONE
                binding.logOut.visibility = View.VISIBLE
                binding.logRemove.visibility = View.VISIBLE

            }
            db.close()
        }

        /*출처: chatGPT*/

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.text) {
                    "찜한 레시피" -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, LoveFragment())
                            .commit()
                    }
                    "등록한 레시피" -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, RegisterFragment())
                            .commit()
                    }
                    "레시피 후기" -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, ReviewFragment())
                            .commit()
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
        })

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, LoveFragment())
            .commit()


        val backButton: ImageView = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        val loginButton: TextView = findViewById(R.id.log_in)
        loginButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        val logoutButton: TextView = findViewById(R.id.log_out)
        logoutButton.setOnClickListener {
            val usernk = binding.userNk.text.toString()
            dbHelper.isUserLogout(usernk)

            finish()
        }

        binding.editMemberInfo.setOnClickListener {
            startActivity(Intent(this, EditMemberInfoActivity::class.java))
        }


    } // onCreate
}

/*출처: chatGPT와 수업자료*/
