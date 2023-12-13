package com.example.yumyum.recipe

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.yumyum.R
import com.example.yumyum.databinding.ActivityRecipeContinueBinding

class R6ContinueActivity : AppCompatActivity() {
    private lateinit var cookTimer: TextView
    private lateinit var startBtn: Button
    private lateinit var stopBtn: Button
    private var timer: CountDownTimer? = null
    private var isTimerRunning = false
    private var remainingTimeInMillis: Long = 0
    private var setTimeS : Long = 0
    private lateinit var binding: ActivityRecipeContinueBinding
    private var clickCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeContinueBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cookTimer = findViewById(R.id.cook_timer)
        startBtn = findViewById(R.id.start_btn)
        stopBtn = findViewById(R.id.stop_btn)

        stopBtn.setOnClickListener{
            if(isTimerRunning){
                stopTimer()
                stopBtn.text = "계속"

            }else{
                if(remainingTimeInMillis > 0){
                    startTimer(remainingTimeInMillis)
                    stopBtn.text = "중지"
                }
            }
        }

        startBtn.setOnClickListener {
            if (remainingTimeInMillis > 0) {
                // 초기화 버튼으로 변경
                resetTimer()
            } else {
                // 새로운 타이머 시작
                startTimer(setTimeS * 1000) // 시간을 설정하려면 여기 값을 조정, 5분 -> setTimeS -> 60*5=300
            }
        }

        val backButton: ImageView = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            startActivity(Intent(this, R1StartActivity::class.java))
        }

        when(clickCount) {
            1-> {
                binding.cookStep.text = "No.$clickCount"
                setTimeS = 0
                binding.cookTimer.text = "00:00"
                binding.cookStepText.text = "$clickCount. 소금, 설탕, 식초를(1:2:3)에 맞춰 만든다."
                binding.beforeToPageBtn.visibility = View.INVISIBLE
            }
        }

        binding.nextToPageBtn.setOnClickListener {
            clickCount++
            startBtn.text = "시작"
            stopBtn.text = "계속"
            resetTimer()

            if(clickCount == 6) {
                binding.nextToPageText.text = "종료하기"
            }
            if(binding.nextToPageText.text == "종료하기") {
                binding.nextToPageBtn.setOnClickListener {
                    val intent = Intent(this, R1FinishActivity::class.java)
                    intent.putExtra("Name", "연어초밥")
                    intent.putExtra("Img", R.drawable.food10)
                    startActivity(intent)
                }
            }

            when(clickCount) {
                1-> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 소금, 설탕, 식초를(1:2:3)에 맞춰 만든다."
                    binding.beforeToPageBtn.visibility = View.INVISIBLE
                }
                2 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 10
                    binding.cookTimer.text = "00:10"
                    binding.cookStepText.text = "$clickCount. 단촛물을 전자레인지에 넣고 10초간 돌려주고 잘 저어준다."
                    binding.beforeToPageBtn.visibility = View.VISIBLE
                }
                3 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 그릇에 밥 한공기를 넣고 단촛물 4t을 넣어 잘 섞어 준다."
                }
                4 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 연어회가 덩어리라면 먹기 좋은 크기로 썰어준다."
                }
                5 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 위생장갑을 끼고 밥을 뭉쳐준 뒤 와사비를 묻힌다."
                }
                6 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 위에 연어회 슬라이스 올려준다."
                }
            }
        }

        binding.beforeToPageBtn.setOnClickListener {
            clickCount--

            when(clickCount) {
                1-> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 소금, 설탕, 식초를(1:2:3)에 맞춰 만든다."
                    binding.beforeToPageBtn.visibility = View.INVISIBLE
                }
                2 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 10
                    binding.cookTimer.text = "00:10"
                    binding.cookStepText.text = "$clickCount. 단촛물을 전자레인지에 넣고 10초간 돌려주고 잘 저어준다."
                    binding.beforeToPageBtn.visibility = View.VISIBLE
                }
                3 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 그릇에 밥 한공기를 넣고 단촛물 4t을 넣어 잘 섞어 준다."
                }
                4 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 연어회가 덩어리라면 먹기 좋은 크기로 썰어준다."
                }
                5 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 위생장갑을 끼고 밥을 뭉쳐준 뒤 와사비를 묻힌다."
                }
                6 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 위에 연어회 슬라이스 올려준다."
                }
            }
        }
    } // onCreate


    private fun startTimer(durationInMillis: Long) {
        timer = object : CountDownTimer(durationInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                remainingTimeInMillis = millisUntilFinished
                updateTimerText()
            }

            override fun onFinish() {
                isTimerRunning = false
                startBtn.text = "시작"
                stopBtn.text = "계속"
            }
        }.start()

        isTimerRunning = true
        startBtn.text = "초기화"
        stopBtn.text = "중지"
    }

    private fun stopTimer() {
        timer?.cancel()
        isTimerRunning = false
    }

    private fun resetTimer() {
        timer?.cancel()
        remainingTimeInMillis = 0
        updateTimerText()
        isTimerRunning = false
        startBtn.text = "시작"
        stopBtn.text = "계속"
        when(clickCount) {
            1 -> binding.cookTimer.text = "00:00"
            2 -> binding.cookTimer.text = "00:10"
            3 -> binding.cookTimer.text = "00:00"
            4 -> binding.cookTimer.text = "00:00"
            5 -> binding.cookTimer.text = "00:00"
            6 -> binding.cookTimer.text = "00:00"
        }
    }

    private fun updateTimerText() {
        val minutes = (remainingTimeInMillis / 1000 / 60).toInt()
        val seconds = (remainingTimeInMillis / 1000 % 60).toInt()
        val timeText = String.format("%02d:%02d", minutes, seconds)
        cookTimer.text = timeText
    }


}