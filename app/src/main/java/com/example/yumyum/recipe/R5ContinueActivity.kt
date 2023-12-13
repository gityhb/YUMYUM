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

class R5ContinueActivity : AppCompatActivity() {
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
        }//출처:chatgpt

        val backButton: ImageView = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            startActivity(Intent(this, R1StartActivity::class.java))
        }

        when(clickCount) {
            1-> {
                binding.cookStep.text = "No.$clickCount"
                setTimeS = 0
                binding.cookTimer.text = "00:00"
                binding.cookStepText.text = "$clickCount. 생강을 다진다."
                binding.beforeToPageBtn.visibility = View.INVISIBLE
            }
        }

        binding.nextToPageBtn.setOnClickListener {
            clickCount++
            startBtn.text = "시작"
            stopBtn.text = "계속"
            resetTimer()
            //출처:chatgpt
            if(clickCount == 11) {
                binding.nextToPageText.text = "종료하기"
            }
            if(binding.nextToPageText.text == "종료하기") {
                binding.nextToPageBtn.setOnClickListener {
                    val intent = Intent(this, R1FinishActivity::class.java)
                    intent.putExtra("Name", "라멘")
                    intent.putExtra("Img", R.drawable.food11)
                    startActivity(intent)
                }
            }

            when(clickCount) {
                1-> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 생강을 다진다."
                    binding.beforeToPageBtn.visibility = View.INVISIBLE
                }
                2 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 대파는 채썰어서 찬물에 담가둔다."
                    binding.beforeToPageBtn.visibility = View.VISIBLE
                }
                3 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 숙주를 씻어서 물기를 빼놓는다."
                }
                4 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 삶은 계란은 반으로 잘라 놓는다."
                }
                5 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 300
                    binding.cookTimer.text = "05:00"
                    binding.cookStepText.text = "$clickCount. 팬에 오일을 살짝만 두르고 돼지고기 간 것과 생강을 주걱으로 볶는다."
                }
                6 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 4200
                    binding.cookTimer.text = "07:00"
                    binding.cookStepText.text = "$clickCount. 두반장, 미소, 설탕을 넣고, 물 1/4컵을 붓고 조린다."
                }
                7 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 1200
                    binding.cookTimer.text = "20:00"
                    binding.cookStepText.text = "$clickCount. 다른 냄비에 참기를 1t을 두르고 마늘, 생강 1/2t씩 넣고 볶는다."
                }
                8 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 이후 물 400ml, 미소 1T도 잘 풀어넣어준다."
                }
                9 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 120
                    binding.cookTimer.text = "02:00"
                    binding.cookStepText.text = "$clickCount. 끓는 물에 면을 2분간 삶는다."
                }
                10 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 면은 물기를 털고 그릇에 넣어준 뒤 면을 넣어준다."
                }
                11 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 고기와 숙주, 계란으로 토핑한다."
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
                    binding.cookStepText.text = "$clickCount. 생강을 다진다."
                    binding.beforeToPageBtn.visibility = View.INVISIBLE
                }
                2 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 대파는 채썰어서 찬물에 담가둔다."
                    binding.beforeToPageBtn.visibility = View.VISIBLE
                }
                3 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 숙주를 씻어서 물기를 빼놓는다."
                }
                4 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 삶은 계란은 반으로 잘라 놓는다."
                }
                5 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 300
                    binding.cookTimer.text = "05:00"
                    binding.cookStepText.text = "$clickCount. 팬에 오일을 살짝만 두르고 돼지고기 간 것과 생강을 주걱으로 볶는다."
                }
                6 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 420
                    binding.cookTimer.text = "07:00"
                    binding.cookStepText.text = "$clickCount. 두반장, 미소, 설탕을 넣고, 물 1/4컵을 붓고 조린다."
                }
                7 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 1200
                    binding.cookTimer.text = "20:00"
                    binding.cookStepText.text = "$clickCount. 다른 냄비에 참기를 1t을 두르고 마늘, 생강 1/2t씩 넣고 볶는다."
                }
                8 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 이후 물 400ml, 미소 1T도 잘 풀어넣어준다."
                }
                9 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 120
                    binding.cookTimer.text = "02:00"
                    binding.cookStepText.text = "$clickCount. 끓는 물에 면을 2분간 삶는다."
                }
                10 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 면은 물기를 털고 그릇에 넣어준 뒤 면을 넣어준다."
                }
                11 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 고기와 숙주, 계란으로 토핑한다."
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
        stopBtn.text = "계속" //출처:chatgpt
        when(clickCount) {
            1 -> binding.cookTimer.text = "00:00"
            2 -> binding.cookTimer.text = "00:00"
            3 -> binding.cookTimer.text = "00:00"
            4 -> binding.cookTimer.text = "00:00"
            5 -> binding.cookTimer.text = "05:00"
            6 -> binding.cookTimer.text = "07:00"
            7 -> binding.cookTimer.text = "20:00"
            8 -> binding.cookTimer.text = "00:00"
            9 -> binding.cookTimer.text = "02:00"
            10 -> binding.cookTimer.text = "00:00"
            11 -> binding.cookTimer.text = "00:00"
        }
    }

    private fun updateTimerText() {
        val minutes = (remainingTimeInMillis / 1000 / 60).toInt()
        val seconds = (remainingTimeInMillis / 1000 % 60).toInt()
        val timeText = String.format("%02d:%02d", minutes, seconds)
        cookTimer.text = timeText
    }//출처:chatgpt


}