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

class R2ContinueActivity : AppCompatActivity() {
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
                setTimeS = 1800
                binding.cookTimer.text = "30:00"
                binding.cookStepText.text = "$clickCount. 설탕, 소금, 베이킹파우더, 중력분을 섞어 30분간 냉장한다."
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
                    setTimeS = 1800
                    binding.cookTimer.text = "30:00"
                    binding.cookStepText.text = "$clickCount. 설탕, 소금, 베이킹파우더, 중력분을 섞어 30분간 냉장한다."
                    binding.beforeToPageBtn.visibility = View.INVISIBLE
                }
                2 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 1800
                    binding.cookTimer.text = "30:00"
                    binding.cookStepText.text = "$clickCount. 버터를 1cm x 1cm씩 깍둑썰어서 30분간 냉장한다."
                    binding.beforeToPageBtn.visibility = View.VISIBLE
                }
                3 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 1800
                    binding.cookTimer.text = "30:00"
                    binding.cookStepText.text = "$clickCount. 계란과 우유를 섞어서 30분간 냉장한다."
                }
                4 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 냉장시킨 가루를 체 쳐서 볼에 넣는다."
                }
                5 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 차가운 버터를 넣고 쌀알만큼 작아질 때까지 다진다.(버터가 녹지 않도록 신속하게 하는 것이 중요하다.)"
                }
                6 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 가운데 홈을 파서 수분재료(계란+우유)를 넣어 흡수시킨 후 다시 다진다."
                }
                7 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 날가루가 보이지 않으면 사각형으로 대충 뭉친다.(손을 사용하지 않는다.)"
                }
                8 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 2400
                    binding.cookTimer.text = "40:00"
                    binding.cookStepText.text = "$clickCount. 사각형을 반으로 잘라 포개 겹치는 것을 3-4회 반복한다."
                }
                9 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 3600
                    binding.cookTimer.text = "60:00"
                    binding.cookStepText.text = "$clickCount. 반죽을 랩에 싸서 1시간 냉장한다."
                }
                10 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 75-85g 정도로 잘라 반죽을 접어 까준다는 느낌으로 모양을 만든다."
                }
                11 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 달걀물을 반죽 표면 위에 얇게 바른다."
                }
                12 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 1200
                    binding.cookTimer.text = "20:00"
                    binding.cookStepText.text = "$clickCount. 오븐 190도 10분 예열 후 180도에서 20분간 굽는다."
                }
            }
        }

        binding.beforeToPageBtn.setOnClickListener {
            clickCount--

            when(clickCount) {
                1-> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 1800
                    binding.cookTimer.text = "30:00"
                    binding.cookStepText.text = "$clickCount. 설탕, 소금, 베이킹파우더, 중력분을 섞어 30분간 냉장한다."
                    binding.beforeToPageBtn.visibility = View.INVISIBLE
                }
                2 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 1800
                    binding.cookTimer.text = "30:00"
                    binding.cookStepText.text = "$clickCount. 버터를 1cm x 1cm씩 깍둑썰어서 30분간 냉장한다."
                    binding.beforeToPageBtn.visibility = View.VISIBLE
                }
                3 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 1800
                    binding.cookTimer.text = "30:00"
                    binding.cookStepText.text = "$clickCount. 계란과 우유를 섞어서 30분간 냉장한다."
                }
                4 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 냉장시킨 가루를 체 쳐서 볼에 넣는다."
                }
                5 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 차가운 버터를 넣고 쌀알만큼 작아질 때까지 다진다.(버터가 녹지 않도록 신속하게 하는 것이 중요하다.)"
                }
                6 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 가운데 홈을 파서 수분재료(계란+우유)를 넣어 흡수시킨 후 다시 다진다."
                }
                7 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 날가루가 보이지 않으면 사각형으로 대충 뭉친다.(손을 사용하지 않는다.)"
                }
                8 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 2400
                    binding.cookTimer.text = "40:00"
                    binding.cookStepText.text = "$clickCount. 사각형을 반으로 잘라 포개 겹치는 것을 3-4회 반복한다."
                }
                9 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 3600
                    binding.cookTimer.text = "60:00"
                    binding.cookStepText.text = "$clickCount. 반죽을 랩에 싸서 1시간 냉장한다."
                }
                10 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 75-85g 정도로 잘라 반죽을 접어 까준다는 느낌으로 모양을 만든다."
                }
                11 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 0
                    binding.cookTimer.text = "00:00"
                    binding.cookStepText.text = "$clickCount. 달걀물을 반죽 표면 위에 얇게 바른다."
                }
                12 -> {
                    binding.cookStep.text = "No.$clickCount"
                    setTimeS = 1200
                    binding.cookTimer.text = "20:00"
                    binding.cookStepText.text = "$clickCount. 오븐 190도 10분 예열 후 180도에서 20분간 굽는다."
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
            1 -> binding.cookTimer.text = "30:00"
            2 -> binding.cookTimer.text = "30:00"
            3 -> binding.cookTimer.text = "30:00"
            4 -> binding.cookTimer.text = "00:00"
            5 -> binding.cookTimer.text = "00:00"
            6 -> binding.cookTimer.text = "00:00"
            7 -> binding.cookTimer.text = "00:00"
            8 -> binding.cookTimer.text = "40:00"
            9 -> binding.cookTimer.text = "60:00"
            10 -> binding.cookTimer.text = "00:00"
            11 -> binding.cookTimer.text = "00:00"
            12 -> binding.cookTimer.text = "20:00"
        }
    }

    private fun updateTimerText() {
        val minutes = (remainingTimeInMillis / 1000 / 60).toInt()
        val seconds = (remainingTimeInMillis / 1000 % 60).toInt()
        val timeText = String.format("%02d:%02d", minutes, seconds)
        cookTimer.text = timeText
    }


}