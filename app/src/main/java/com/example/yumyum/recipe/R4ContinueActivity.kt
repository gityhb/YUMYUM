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
import com.example.yumyum.RecipeStartActivity
import com.example.yumyum.databinding.ActivityRecipeContinueBinding

class R4ContinueActivity : AppCompatActivity() {
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
            startActivity(Intent(this, RecipeStartActivity::class.java))
        }

        /*val nextButton: LinearLayout = findViewById(R.id.next_to_page_btn)
        nextButton.setOnClickListener {
            startActivity(Intent(this, RecipeFinishActivity::class.java))
        }*/

        when(clickCount) {
            1-> {
                binding.cookStep.text = "No.$clickCount"
                setTimeS = 0
                binding.cookTimer.text = "00:00"
                binding.cookStepText.text = "$clickCount. 계란을 풀어 반죽을 준비한다."
                binding.beforeToPageBtn.visibility = View.INVISIBLE
            }
        }

        binding.nextToPageBtn.setOnClickListener {
            clickCount++

            if(clickCount == 12) {
                binding.nextToPageText.text = "종료하기"
            }
            if(binding.nextToPageText.text == "종료하기") {
                startActivity(Intent(this, R1FinishActivity::class.java))
            }

            when(clickCount) {
                1-> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 계란을 풀어 반죽을 준비한다."
                    binding.beforeToPageBtn.visibility = View.INVISIBLE
                }
                2 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 버터에 설탕을 여러번 나누어 넣으면서 녹인다."
                    binding.beforeToPageBtn.visibility = View.VISIBLE
                }
                3 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 설탕과 버터를 잘 섞었다면 풀어둔 계란을 세번을 나눠 넣어 섞어준다."
                }
                4 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 박력분과 베이킹파우더, 바닐라파우더, 소금을 체에 내려준다."
                }
                5 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 오븐을 170도-180도에서 예열해준다."
                }
                6 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 짤주머니에 주걱으로 잘 넣어서 매듭을 집게로 집어준 후 틀에 반죽을 넣어주고 위에 토핑을 넣어준다."
                }
                7 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 1200
                    binding.cookTimer.text = "20:00"
                    binding.cookStepText.text = "$clickCount. 170도에서 20분 구워준다."
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
                    binding.cookStepText.text = "$clickCount. 계란을 풀어 반죽을 준비한다."
                    binding.beforeToPageBtn.visibility = View.INVISIBLE
                }
                2 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 버터에 설탕을 여러번 나누어 넣으면서 녹인다."
                    binding.beforeToPageBtn.visibility = View.VISIBLE
                }
                3 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 설탕과 버터를 잘 섞었다면 풀어둔 계란을 세번을 나눠 넣어 섞어준다."
                }
                4 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 박력분과 베이킹파우더, 바닐라파우더, 소금을 체에 내려준다."
                }
                5 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 오븐을 170도-180도에서 예열해준다."
                }
                6 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 짤주머니에 주걱으로 잘 넣어서 매듭을 집게로 집어준 후 틀에 반죽을 넣어주고 위에 토핑을 넣어준다."
                }
                7 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 1200
                    binding.cookTimer.text = "20:00"
                    binding.cookStepText.text = "$clickCount. 170도에서 20분 구워준다."
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
            2 -> binding.cookTimer.text = "00:00"
            3 -> binding.cookTimer.text = "00:00"
            4 -> binding.cookTimer.text = "00:00"
            5 -> binding.cookTimer.text = "00:00"
            6 -> binding.cookTimer.text = "00:00"
            7 -> binding.cookTimer.text = "20:00"
        }
    }

    private fun updateTimerText() {
        val minutes = (remainingTimeInMillis / 1000 / 60).toInt()
        val seconds = (remainingTimeInMillis / 1000 % 60).toInt()
        val timeText = String.format("%02d:%02d", minutes, seconds)
        cookTimer.text = timeText
    }


}