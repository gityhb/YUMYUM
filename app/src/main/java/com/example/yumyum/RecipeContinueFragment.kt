package com.example.yumyum

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class RecipeContinueFragment : Fragment() {
    private lateinit var timerTextView: TextView
    private lateinit var startButton: Button
    private lateinit var stopButton: Button
    private var timer: CountDownTimer? = null
    private var isTimerRunning = false
    private var remainingTimeInMillis: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipe_continue, container, false)

        timerTextView = view.findViewById(R.id.timerTextView)
        startButton = view.findViewById(R.id.startButton)
        stopButton = view.findViewById(R.id.stopButton)

        stopButton.setOnClickListener {
            if (isTimerRunning) {
                stopTimer()
                stopButton.text = "계속"
            } else {
                if (remainingTimeInMillis > 0) {
                    startTimer(remainingTimeInMillis)
                    stopButton.text = "중지"
                }
            }
        }

        startButton.setOnClickListener {
            if (remainingTimeInMillis > 0) {
                resetTimer()
            } else {
                startTimer(12 * 60 * 1000) // 5분을 설정하려면 여기 값을 조정
            }
        }

        return view
    }

    private fun startTimer(durationInMillis: Long) {
        timer = object : CountDownTimer(durationInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                remainingTimeInMillis = millisUntilFinished
                updateTimerText()
            }

            override fun onFinish() {
                isTimerRunning = false
                startButton.text = "시작"
            }
        }.start()

        isTimerRunning = true
        startButton.text = "초기화"
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
        startButton.text = "시작"
    }

    private fun updateTimerText() {
        val minutes = (remainingTimeInMillis / 1000 / 60).toInt()
        val seconds = (remainingTimeInMillis / 1000 % 60).toInt()
        val timeText = String.format("%02d:%02d", minutes, seconds)
        timerTextView.text = timeText
    }
}

