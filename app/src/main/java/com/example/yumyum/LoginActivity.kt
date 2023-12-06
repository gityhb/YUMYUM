package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yumyum.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = DBHelper(this)

        binding.loginBtn.setOnClickListener {
            val LstrId = binding.mainLogin.text.toString().trim()
            val LstrPwd = binding.mainPwd.text.toString().trim()
            val isLogin = dbHelper.isLogin(LstrId, LstrPwd)

            if(isLogin) {
                dbHelper.updateIsLogin(LstrId, 1)
                Toast.makeText(applicationContext, "$LstrId 로그인 성공!", Toast.LENGTH_SHORT).show()
                binding.LwarningLogin.visibility = View.INVISIBLE

                val intentM = Intent(this@LoginActivity, MyPageActivity::class.java)
                startActivity(intentM)
            } else {
                binding.LwarningLogin.visibility = View.VISIBLE
                Toast.makeText(applicationContext, "실패", Toast.LENGTH_SHORT).show()
            }
        } // loginBtn

        binding.joinBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val intentJ = Intent(this@LoginActivity, JoinActivity::class.java)
                startActivity(intentJ)
            }
        })
        val backButton: ImageView = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    } // onCreate
}