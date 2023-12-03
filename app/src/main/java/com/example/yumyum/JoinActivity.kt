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
    private lateinit var dbHelper: DBHelper
    private lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
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

                /*val warning_name = View.findViewById<TextView>(R.id.warning_name)
                val warning_id = view.findViewById<TextView>(R.id.warning_id)
                val warning_id_chk_t = view.findViewById<TextView>(R.id.warning_id_chk_t)
                val warning_id_chk_f = view.findViewById<TextView>(R.id.warning_id_chk_f)
                val warning_nkname = view.findViewById<TextView>(R.id.warning_nkname)
                val warning_nkname_chk_t = view.findViewById<TextView>(R.id.warning_nkname_chk_t)
                val warning_nkname_chk_f = view.findViewById<TextView>(R.id.warning_nkname_chk_f)
                val warning_pwd = view.findViewById<TextView>(R.id.warning_pwd)
                val warning_pwd2 = view.findViewById<TextView>(R.id.warning_pwd2)
                val warning_pwd2_chk_t = view.findViewById<TextView>(R.id.warning_id_chk_t)
                val warning_pwd2_chk_f = view.findViewById<TextView>(R.id.warning_id_chk_f)
                val warning_phone = view.findViewById<TextView>(R.id.warning_phone)
                val warning_phone_author = view.findViewById<TextView>(R.id.warning_phone_author)
                val warning_phone_author_chk_t = view.findViewById<TextView>(R.id.warning_phone_author_chk_t)
                val warning_phone_author_chk_f = view.findViewById<TextView>(R.id.warning_phone_author_chk_f)
                val warning_email = view.findViewById<TextView>(R.id.warning_email)*/

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
                    }

                    if(strId.isEmpty()) {
                        binding.warningId.visibility = View.VISIBLE
                    }
                    //id 중복 확인
                    binding.checkIdBtn.setOnClickListener {

                        if(strId.isNotEmpty()) {
                            if(isUserIdExists) { //중복될 경우
                                binding.warningIdChkT.visibility = View.GONE
                                binding.warningIdChkF.visibility = View.VISIBLE
                                binding.warningId.visibility = View.GONE
                            }
                            else { //중복되지 않을 경우
                                binding.warningIdChkT.visibility = View.VISIBLE
                                binding.warningIdChkF.visibility = View.GONE
                                binding.warningId.visibility = View.GONE
                            }
                        }
                    } //checkIdBtn
                    if(strNkname.isEmpty()) {
                        binding.warningNkname.visibility = View.VISIBLE
                    }
                    //nickname 중복 확인
                    binding.checkNknameBtn.setOnClickListener {

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
                    } // checkNknameBtn
                    if(strPwd.isEmpty()) {
                        binding.warningPwd.visibility = View.VISIBLE
                    }
                    if(strPwd2.isEmpty()) {
                        binding.warningPwd2.visibility = View.VISIBLE
                        binding.warningPwd2ChkT.visibility = View.GONE
                        binding.warningPwd2ChkF.visibility = View.GONE
                    }
                    if(strPwd == strPwd2) {
                        binding.warningPwd2.visibility = View.GONE
                        binding.warningPwd2ChkT.visibility = View.VISIBLE
                        binding.warningPwd2ChkF.visibility = View.GONE
                    } else {
                        binding.warningPwd2.visibility = View.GONE
                        binding.warningPwd2ChkT.visibility = View.GONE
                        binding.warningPwd2ChkF.visibility = View.VISIBLE
                    }
                    if(strPhone.isEmpty()) {
                        binding.warningPhone.visibility = View.VISIBLE
                    }
                    //phone 인증
                    if(strPhone.isNotEmpty()) {
                        binding.checkPhoneBtn.setOnClickListener {
                            binding.checkPhoneBtn.setText("재발송")
                            binding.phoneAuthor.visibility = View.VISIBLE
                            Toast.makeText(applicationContext, "인증번호 : 2122", Toast.LENGTH_LONG).show()
                            binding.checkPhoneBtn.setOnClickListener {
                                Toast.makeText(applicationContext, "인증번호 : 2122", Toast.LENGTH_LONG).show()
                            }
                        }
                        if(strPhoneAuthor.isEmpty()) {
                            binding.warningPhoneAuthor.visibility = View.VISIBLE
                        } else { //인증번호를 입력한 경우
                            binding.checkPhoneAuthorBtn.setOnClickListener {
                                if(strPhoneAuthor == "2122") { //인증번호가 일치할 경우
                                    binding.warningPhoneAuthor.visibility = View.GONE
                                    binding.warningPhoneAuthorChkT.visibility = View.VISIBLE
                                    binding.warningPhoneAuthorChkF.visibility = View.GONE
                                }
                                else { //인증번호가 일치하지 않은 경우
                                    binding.warningPhoneAuthor.visibility = View.GONE
                                    binding.warningPhoneAuthorChkT.visibility = View.GONE
                                    binding.warningPhoneAuthorChkF.visibility = View.VISIBLE
                                }
                            } // checkPhoneAuthorBtn
                        }
                    }
                    if(strEmail.isEmpty()) {
                        binding.warningEmail.visibility = View.VISIBLE
                    }
                    /*visibility 출처
                    https://heezit.tistory.com/116*/

                }
            }

        })

    } // onCreate
}