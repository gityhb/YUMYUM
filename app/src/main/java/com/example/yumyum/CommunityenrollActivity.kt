package com.example.yumyum

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.yumyum.databinding.ActivityCommunityenrollBinding

class CommunityenrollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_communityenroll)
        val binding = ActivityCommunityenrollBinding.inflate(layoutInflater)


        val buttonRegister = findViewById<Button>(R.id.button_register)
        val editTextContent2 = findViewById<EditText>(R.id.write_content)
        val editTextContent1 = findViewById<EditText>(R.id.write_title)

        buttonRegister.setOnClickListener {

            val title = editTextContent1.text.toString()
            val content = editTextContent2.text.toString()
            // 버튼이 눌리면 EditText에 있는 내용 저장

            val Listintent = Intent(this , RecyclerActivity :: class.java)
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

        val camera: ImageView = findViewById(R.id.camera_btn)
        val cameraLauncher=registerForActivityResult(ActivityResultContracts.TakePicturePreview()){
        }

        camera.setOnClickListener{
            cameraLauncher.launch(null)
        } /*일단 카메라 클릭시 카메라 앱 실행*/


        val imageView: ImageView = findViewById(R.id.back_btn)

        imageView.setOnClickListener {
            startActivity(Intent(this@CommunityenrollActivity, RecyclerActivity::class.java))
        }
    }
}