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

class R1ContinueActivity : AppCompatActivity() {
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
            1 -> {
                binding.cookStep.text = "No.$clickCount"
                setTimeS = 2400
                binding.cookTimer.text = "40:00"
                binding.cookStepText.text = "$clickCount. 버터가 말랑해지도록 실온에 둔 후 볼에 넣고 풀어준다."
                binding.beforeToPageBtn.visibility = View.INVISIBLE
            }
        }

        val recipe = intent.getStringExtra("Name")
        val recipeimg = intent.getIntExtra("Img", R.drawable.food3)


        binding.nextToPageBtn.setOnClickListener {
            clickCount++
            startBtn.text = "시작"
            stopBtn.text = "계속"
            resetTimer()

            if(clickCount == 11) {
                binding.nextToPageText.text = "종료하기 "
            }
            if(binding.nextToPageText.text.trim() == "종료하기") {
                binding.nextToPageBtn.setOnClickListener {
                    val intent = Intent(this, R1FinishActivity::class.java)
                    intent.putExtra("Name", recipe)
                    intent.putExtra("Img", recipeimg)
                    startActivity(intent)
                }
            }

            when(clickCount) {
                1-> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 2400
                    binding.cookTimer.text = "40:00"
                    binding.cookStepText.text = "$clickCount. 버터가 말랑해지도록 실온에 둔 후 볼에 넣고 풀어준다."
                    binding.beforeToPageBtn.visibility = View.INVISIBLE
                }
                2 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 설탕과 소금을 넣고 버터색이 약간 밝아질 때까지 주걱으로 잘 섞는다."
                    binding.beforeToPageBtn.visibility = View.VISIBLE
                }
                3 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 계랸을 2번에 나누어 넣으면서 섞어준다."
                }
                4 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 박력분과 베이킹파우더를 체 쳐서 넣는다."
                }
                5 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 반죽이 뭉쳐질 때까지 주걱을 수직으로 세워 자르듯 섞는다."
                }
                6 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 뭉쳐진 반죽을 살살 눌러서 매끈한 상태로 만든다.(너무 많이 치대지 않는다.)"
                }
                7 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 반죽을 종이호일에 넣어 약 0.5cm 두꼐로 균일하게 핀다.(비닐봉지도 가능하다.)"
                }
                8 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 2400
                    binding.cookTimer.text = "40:00"
                    binding.cookStepText.text = "$clickCount. 핀 반죽을 쟁반에 담아 40분간 냉장한다."
                }
                9 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 반죽에 모양틀을 찍어낸다."
                }
                10 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 900
                    binding.cookTimer.text = "15:00"
                    binding.cookStepText.text = "$clickCount. 오븐 170도 15분 예열 후 170도에서 13-15분간 굽는다."
                }
                11 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 오븐에서 꺼낸 후 5분간 식힌다."
                }
            }
        }

        binding.beforeToPageBtn.setOnClickListener {
            clickCount--
            binding.nextToPageText.text = "넘어가기 "

            when(clickCount) {
                1-> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 2400
                    binding.cookTimer.text = "40:00"
                    binding.cookStepText.text = "$clickCount. 버터가 말랑해지도록 실온에 둔 후 볼에 넣고 풀어준다."
                    binding.beforeToPageBtn.visibility = View.INVISIBLE
                }
                2 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 설탕과 소금을 넣고 버터색이 약간 밝아질 때까지 주걱으로 잘 섞는다."
                    binding.beforeToPageBtn.visibility = View.VISIBLE
                }
                3 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 계랸을 2번에 나누어 넣으면서 섞어준다."
                }
                4 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 박력분과 베이킹파우더를 체 쳐서 넣는다."
                }
                5 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 반죽이 뭉쳐질 때까지 주걱을 수직으로 세워 자르듯 섞는다."
                }
                6 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 뭉쳐진 반죽을 살살 눌러서 매끈한 상태로 만든다.(너무 많이 치대지 않는다.)"
                }
                7 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 반죽을 종이호일에 넣어 약 0.5cm 두꼐로 균일하게 핀다.(비닐봉지도 가능하다.)"
                }
                8 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 2400
                    binding.cookTimer.text = "40:00"
                    binding.cookStepText.text = "$clickCount. 핀 반죽을 쟁반에 담아 40분간 냉장한다."
                }
                9 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 반죽에 모양틀을 찍어낸다."
                }
                10 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 900
                    binding.cookTimer.text = "15:00"
                    binding.cookStepText.text = "$clickCount. 오븐 170도 15분 예열 후 170도에서 13-15분간 굽는다."
                }
                11 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 오븐에서 꺼낸 후 5분간 식힌다."
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
            1-> binding.cookTimer.text = "40:00"
            2 -> binding.cookTimer.text = "00:00"
            3 -> binding.cookTimer.text = "00:00"
            4 -> binding.cookTimer.text = "00:00"
            5 -> binding.cookTimer.text = "00:00"
            6 -> binding.cookTimer.text = "00:00"
            7 -> binding.cookTimer.text = "00:00"
            8 -> binding.cookTimer.text = "40:00"
            9 -> binding.cookTimer.text = "00:00"
            10 -> binding.cookTimer.text = "15:00"
            11 -> binding.cookTimer.text = "00:00"
        }
    }

    private fun updateTimerText() {
        val minutes = (remainingTimeInMillis / 1000 / 60).toInt()
        val seconds = (remainingTimeInMillis / 1000 % 60).toInt()
        val timeText = String.format("%02d:%02d", minutes, seconds)
        cookTimer.text = timeText
    }


}