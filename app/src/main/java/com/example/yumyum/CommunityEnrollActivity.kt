package com.example.yumyum

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.yumyum.databinding.ActivityCommunityEnrollBinding

class CommunityEnrollActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommunityEnrollBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCommunityEnrollBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonRegister = findViewById<Button>(R.id.button_register)
        val editTextContent2 = findViewById<EditText>(R.id.write_content)
        val editTextContent1 = findViewById<EditText>(R.id.write_title)

        buttonRegister.setOnClickListener {

            val title = editTextContent1.text.toString()
            val content = editTextContent2.text.toString()
            // 버튼이 눌리면 EditText에 있는 내용 저장

            val Listintent = Intent(this , CommunityActivity :: class.java)
            // 인텐트 생성

            Listintent.putExtra("Title", title) // .putExtra() 메소드로 데이터 전달준비
            Listintent.putExtra("Content", content)

            startActivity(Listintent) // 인텐트 실행
        }

        val map: ImageView = findViewById(R.id.map_btn)

        map.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.500537533615905,126.86774077038955"))
                startActivity(intent)
            }
        })  /*일단 맵 클릭하면 우리학교 위치로 이동*/

        //카메라
        val cameraLauncher = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) {
            if(it != null) {
                binding.imgInput1.setImageBitmap(it)
                binding.imgInput1.visibility = View.VISIBLE
            }
        }

        binding.cameraBtn.setOnClickListener {
            cameraLauncher.launch(null)
        }

        // 갤러리
        val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent(),
            object: ActivityResultCallback<Uri?> {
                override fun onActivityResult(result: Uri?) {
                    binding.imgInput1.setImageURI(result)
                    binding.imgInput1.visibility = View.VISIBLE
                }
            })

        binding.galleryBtn.setOnClickListener {
            galleryLauncher.launch("image/*")
        }

        val backButton: ImageView = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            startActivity(Intent(this, CommunityActivity::class.java))
        }
    }
}