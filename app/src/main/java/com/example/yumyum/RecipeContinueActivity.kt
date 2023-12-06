package com.example.yumyum

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeContinueActivity : AppCompatActivity() {
    private lateinit var cookTimer: TextView
    private lateinit var startBtn: Button
    private lateinit var stopBtn: Button
    private var timer: CountDownTimer? = null
    private var isTimerRunning = false
    private var remainingTimeInMillis: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_continue)

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
                startTimer(600 * 1000) // 5분을 설정하려면 여기 값을 조정
            }
        }

        val backButton: ImageView = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            startActivity(Intent(this, RecipeStartActivity::class.java))
        }

        /*val nextButton: Button = findViewById(R.id.next_btn)
        nextButton.setOnClickListener {
            startActivity(Intent(this, RecipeFinishActivity::class.java))
        }*/

    }


    private fun startTimer(durationInMillis: Long) {
        timer = object : CountDownTimer(durationInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                remainingTimeInMillis = millisUntilFinished
                updateTimerText()
            }

            override fun onFinish() {
                isTimerRunning = false
                startBtn.text = "시작"
            }
        }.start()

        isTimerRunning = true
        startBtn.text = "초기화"
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
    }

    private fun updateTimerText() {
        val minutes = (remainingTimeInMillis / 1000 / 60).toInt()
        val seconds = (remainingTimeInMillis / 1000 % 60).toInt()
        val timeText = String.format("%02d:%02d", minutes, seconds)
        cookTimer.text = timeText
    }


}