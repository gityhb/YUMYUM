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

class R3ContinueActivity : AppCompatActivity() {
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
                binding.cookStepText.text = "$clickCount. 닭발을 해동시켜 깨끗이 씻는다."
                binding.beforeToPageBtn.visibility = View.INVISIBLE
            }
        }

        binding.nextToPageBtn.setOnClickListener {
            clickCount++
            startBtn.text = "시작"
            stopBtn.text = "계속"
            resetTimer()

            if(clickCount == 7) {
                binding.nextToPageText.text = "종료하기"
            }
            if(binding.nextToPageText.text == "종료하기") {
                binding.nextToPageBtn.setOnClickListener {
                    val intent = Intent(this, R1FinishActivity::class.java)
                    intent.putExtra("Name", "닭발")
                    intent.putExtra("Img", R.drawable.food6)
                    startActivity(intent)
                }
            }

            when(clickCount) {
                1-> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 닭발을 해동시켜 깨끗이 씻는다."
                    binding.beforeToPageBtn.visibility = View.INVISIBLE
                }
                2 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 600
                    binding.cookTimer.text = "10:00"
                    binding.cookStepText.text = "$clickCount. 닭발이 잠길 정도로 물을 넣고 통후추 2스푼과 생강 1톨과 함께 10분정도 삶는다."
                    binding.beforeToPageBtn.visibility = View.VISIBLE
                }
                3 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 삶은 닭발을 찬물에 깨끗이 씻는다."
                }
                4 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 닭발에 고추장 3스푼과 고춧가루 2스푼, 간장 2스푼, 올리고당 1스푼을 넣고 버무린다."
                }
                5 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 1800
                    binding.cookTimer.text = "30:00"
                    binding.cookStepText.text = "$clickCount. 30분동안 재워둔다."
                }
                6 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 달구워진 팬에 식용유를 두르고 재워둔 닭발을 넣고 볶는다."
                }
                7 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 600
                    binding.cookTimer.text = "10:00"
                    binding.cookStepText.text = "$clickCount. 약한 불에 10분정도 조려준다."
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
                    binding.cookStepText.text = "$clickCount. 닭발을 해동시켜 깨끗이 씻는다."
                    binding.beforeToPageBtn.visibility = View.INVISIBLE
                }
                2 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 600
                    binding.cookTimer.text = "10:00"
                    binding.cookStepText.text = "$clickCount. 닭발이 잠길 정도로 물을 넣고 통후추 2스푼과 생강 1톨과 함께 10분정도 삶는다."
                    binding.beforeToPageBtn.visibility = View.VISIBLE
                }
                3 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 삶은 닭발을 찬물에 깨끗이 씻는다."
                }
                4 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 닭발에 고추장 3스푼과 고춧가루 2스푼, 간장 2스푼, 올리고당 1스푼을 넣고 버무린다."
                }
                5 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 1800
                    binding.cookTimer.text = "30:00"
                    binding.cookStepText.text = "$clickCount. 30분동안 재워둔다."
                }
                6 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 달구워진 팬에 식용유를 두르고 재워둔 닭발을 넣고 볶는다."
                }
                7 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 600
                    binding.cookTimer.text = "10:00"
                    binding.cookStepText.text = "$clickCount. 약한 불에 10분정도 조려준다."
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
            2 -> binding.cookTimer.text = "10:00"
            3 -> binding.cookTimer.text = "00:00"
            4 -> binding.cookTimer.text = "00:00"
            5 -> binding.cookTimer.text = "30:00"
            6 -> binding.cookTimer.text = "00:00"
            7 -> binding.cookTimer.text = "10:00"
        }
    }

    private fun updateTimerText() {
        val minutes = (remainingTimeInMillis / 1000 / 60).toInt()
        val seconds = (remainingTimeInMillis / 1000 % 60).toInt()
        val timeText = String.format("%02d:%02d", minutes, seconds)
        cookTimer.text = timeText
    }


}