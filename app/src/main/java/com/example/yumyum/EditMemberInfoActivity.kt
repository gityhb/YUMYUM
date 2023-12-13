package com.example.yumyum

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.yumyum.databinding.ActivityEditMemberInfoBinding

class EditMemberInfoActivity : AppCompatActivity() {
    lateinit var dbHelper: DBHelper
    private var nkOk = false
    private var phoneOk = false
    lateinit var binding:ActivityEditMemberInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityEditMemberInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbHelper = DBHelper(this)
        val db = dbHelper.readableDatabase

        if(dbHelper.isUserLoggedIn()) {
            val userInfo = dbHelper.getUserInfo(db)

            if(userInfo != null) { // 사용자 정보가 있는 경우
                binding.inputName.text = "${userInfo?.name}"
                binding.inputId.text = "${userInfo?.id}"
            }
            db.close()
        }

        //갤러리
        val galleryLauncher = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            object : ActivityResultCallback<Uri?> {
                override fun onActivityResult(result: Uri?) {
                    binding.editPrfileImg.setImageURI(result)
                }
            })

        binding.editPrfileButton.setOnClickListener {
            galleryLauncher.launch("image/*")
        }

        //nickname 중복 확인
        binding.checkNknameBtn.setOnClickListener {

            val strNkname = binding.inputNkname.text.toString().trim()
            val isUserNknameExists = dbHelper.isUserNknameExists(strNkname)

            if(strNkname.isNotEmpty()) {
                if(isUserNknameExists) { //중복될 경우
                    binding.warningNknameChkT.visibility = View.GONE
                    binding.warningNknameChkF.visibility = View.VISIBLE
                    binding.warningNkname.visibility = View.GONE
                }
                else { //중복되지 않을 경우
                    binding.warningNknameChkT.visibility = View.VISIBLE
                    binding.warningNknameChkF.visibility = View.GONE
                    binding.warningNkname.visibility = View.GONE
                }
            }
            else { //strNkname.isEmpty()인 경우
                binding.warningNknameChkT.visibility = View.GONE
                binding.warningNknameChkF.visibility = View.GONE
                binding.warningNkname.visibility = View.VISIBLE
            }
        } // checkNknameBtn

        binding.checkPwdBtn.setOnClickListener {
            val strPwd = binding.inputPwd.text.toString().trim()
            val strPwd2 = binding.inputPwd2.text.toString().trim()

            if(strPwd.isEmpty()) {
                binding.warningPwd.visibility = View.VISIBLE
            } else {
                binding.warningPwd.visibility = View.INVISIBLE
            }
            if(strPwd2.isEmpty()) {
                binding.warningPwd2.visibility = View.VISIBLE
                binding.warningPwd2ChkT.visibility = View.GONE
                binding.warningPwd2ChkF.visibility = View.GONE
            } else {
                if(strPwd.isNotEmpty() && strPwd == strPwd2) {
                    binding.warningPwd2.visibility = View.GONE
                    binding.warningPwd2ChkT.visibility = View.VISIBLE
                    binding.warningPwd2ChkF.visibility = View.GONE
                } else {
                    binding.warningPwd2.visibility = View.GONE
                    binding.warningPwd2ChkT.visibility = View.GONE
                    binding.warningPwd2ChkF.visibility = View.VISIBLE
                }
            }
        } // checkPwdBtn

        //phone 인증
        binding.checkPhoneBtn.setOnClickListener {

            val strPhone = binding.inputPhone.text.toString().trim()

            if (strPhone.isNotEmpty()) {
                binding.checkPhoneBtn.setText("재발송")
                binding.phoneAuthor.visibility = View.VISIBLE
                binding.warningPhone.visibility = View.GONE
                Toast.makeText(applicationContext, "인증번호 : 2122", Toast.LENGTH_LONG).show()
            } else {
                binding.warningPhone.visibility = View.VISIBLE
                binding.phoneAuthor.visibility = View.GONE
            }
        } // checkPhoneAuthorBtn

        binding.checkPhoneAuthorBtn.setOnClickListener {

            val strPhoneAuthor = binding.inputPhoneAuthor.text.toString().trim()

            if(strPhoneAuthor.isEmpty()) {
                binding.warningPhoneAuthor.visibility = View.VISIBLE
            } else { //인증번호를 입력한 경우
                if(strPhoneAuthor == "2122") { //인증번호가 일치할 경우
                    binding.warningPhoneAuthor.visibility = View.GONE
                    binding.warningPhoneAuthorChkT.visibility = View.VISIBLE
                    binding.warningPhoneAuthorChkF.visibility = View.GONE
                    phoneOk = true
                }
                else { //인증번호가 일치하지 않은 경우
                    binding.warningPhoneAuthor.visibility = View.GONE
                    binding.warningPhoneAuthorChkT.visibility = View.GONE
                    binding.warningPhoneAuthorChkF.visibility = View.VISIBLE
                }
            }
        }

        binding.checkEmailBtn.setOnClickListener {
            val strEmail = binding.inputEmail.text.toString().trim()

            if(strEmail.isEmpty()) {
                binding.warningEmailT.visibility = View.GONE
                binding.warningEmail.visibility = View.VISIBLE
            } else {
                binding.warningEmailT.visibility = View.VISIBLE
                binding.warningEmail.visibility = View.GONE
            }
        }

        val backButton: ImageView = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}