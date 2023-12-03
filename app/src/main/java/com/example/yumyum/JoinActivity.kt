package com.example.yumyum

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.yumyum.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {
    lateinit var dbHelper: DBHelper
    private var idOk = false
    private var nkOk = false
    private var phoneOk = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = DBHelper(this)



        //갤러리
        val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent(),
            object : ActivityResultCallback<Uri?> {
                override fun onActivityResult(result: Uri?) {
                    binding.profileImg.setImageURI(result)
                }
            })

        binding.profileImgBtn.setOnClickListener {
            galleryLauncher.launch("image/*")
        }

        //id 중복 확인
        binding.checkIdBtn.setOnClickListener {
            val strId = binding.inputId.text.toString().trim()
            val isUserIdExists = dbHelper.isUserIdExists(strId)

            if(strId.isNotEmpty()) {
                if(isUserIdExists) { //중복될 경우
                    binding.warningIdChkT.visibility = View.VISIBLE
                    binding.warningIdChkF.visibility = View.GONE
                    binding.warningId.visibility = View.GONE
                }
                else { //중복되지 않을 경우
                    binding.warningIdChkT.visibility = View.VISIBLE
                    binding.warningIdChkF.visibility = View.GONE
                    binding.warningId.visibility = View.GONE
                    idOk = true
                }
            }
            else { //strId.isEmpty()인 경우
                binding.warningIdChkT.visibility = View.GONE
                binding.warningIdChkF.visibility = View.GONE
                binding.warningId.visibility = View.VISIBLE
            }
        } //checkIdBtn

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
                    nkOk = true
                }
            }
            else { //strNkname.isEmpty()인 경우
                binding.warningNknameChkT.visibility = View.GONE
                binding.warningNknameChkF.visibility = View.GONE
                binding.warningNkname.visibility = View.VISIBLE
            }
        } // checkNknameBtn

        //phone 인증
        binding.checkPhoneBtn.setOnClickListener {

            val strPhone = binding.inputPhone.text.toString().trim()

            if (strPhone.isNotEmpty()) {
                binding.checkPhoneBtn.setText("재발송")
                binding.phoneAuthor.visibility = View.VISIBLE
                binding.warningPhone.visibility = View.GONE
                Toast.makeText(applicationContext, "인증번호 : 2122", Toast.LENGTH_LONG).show()
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

        if(binding.checkPhoneBtn.text == "재발송") {
            binding.checkPhoneBtn.setOnClickListener {
                Toast.makeText(applicationContext, "인증번호 : 2122", Toast.LENGTH_LONG).show()
            }
        }

        //경고글
        binding.joinBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {

                val strName = binding.inputName.text.toString().trim()
                val strId = binding.inputId.text.toString().trim()
                val strNkname = binding.inputNkname.text.toString().trim()
                val strPwd = binding.inputPwd.text.toString().trim()
                val strPwd2 = binding.inputPwd2.text.toString().trim()
                val strPhone = binding.inputPhone.text.toString().trim()
                val strPhoneAuthor = binding.inputPhoneAuthor.text.toString().trim()
                val strEmail = binding.inputEmail.text.toString().trim()

                val isUserIdExists = dbHelper.isUserIdExists(strId)
                val isUserNknameExists = dbHelper.isUserNknameExists(strNkname)

                if(strName.isNotEmpty() && (strId.isNotEmpty() && isUserIdExists == false) && (strNkname.isNotEmpty() && isUserNknameExists == false) && (strPwd.isNotEmpty() && strPwd2.isNotEmpty() && strPwd == strPwd2) &&
                    strPhone.isNotEmpty() && (strPhoneAuthor.isNotEmpty() && strPhoneAuthor == "2122") && strEmail.isNotEmpty()) {
                    val userId = dbHelper.addUser(strName, strId, strNkname, strPwd, strPhone, strEmail)

                    if(userId != -1L) {
                        Toast.makeText(applicationContext, "회원가입 성곻! $userId, $strName", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(applicationContext, "회원가입 실패!", Toast.LENGTH_SHORT).show()
                    }
                }
                else {
                    if(strName.isEmpty()) {
                        binding.warningName.visibility = View.VISIBLE

                    } else {
                        binding.warningName.visibility = View.INVISIBLE
                    }

                    if(strId.isEmpty()) {
                        binding.warningId.visibility = View.VISIBLE
                        binding.warningIdChkT.visibility = View.GONE
                        binding.warningIdChkF.visibility = View.GONE
                    } else {
                        if(idOk) { //중복확인을 이미 마친 경우
                            binding.warningId.visibility = View.GONE
                        } else {
                            binding.warningId.visibility = View.VISIBLE
                            binding.warningId.setText("아이디 중복확인을 해주세요.")
                        }
                    }

                    if(strNkname.isEmpty()) {
                        binding.warningNkname.visibility = View.VISIBLE
                        binding.warningNknameChkT.visibility = View.GONE
                        binding.warningNknameChkF.visibility = View.GONE
                    } else {
                        if(nkOk) { //중복확인을 이미 마친 경우
                            binding.warningNkname.visibility = View.GONE
                        } else {
                            binding.warningNkname.visibility = View.VISIBLE
                            binding.warningNkname.setText("닉네임 중복확인을 해주세요.")
                        }
                    }

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
                    if(strPhone.isEmpty()) {
                        binding.warningPhone.visibility = View.VISIBLE
                    } else {
                        if(phoneOk == false && binding.phoneAuthor.visibility == View.GONE) {
                            binding.warningPhone.visibility = View.VISIBLE
                            binding.warningPhone.setText("휴대폰 번호를 인증해주세요.")
                        }
                    }

                    if(strEmail.isEmpty()) {
                        binding.warningEmail.visibility = View.VISIBLE
                    } else {
                        binding.warningEmail.visibility = View.INVISIBLE
                    }
                }
            }
        })
    } // onCreate
}