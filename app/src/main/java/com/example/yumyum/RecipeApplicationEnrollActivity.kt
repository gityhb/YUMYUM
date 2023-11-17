package com.example.yumyum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yumyum.databinding.ActivityRecipeApplicationEnrollBinding

internal interface DBContract {
    companion object {

    }
}
class RecipeApplicationEnrollActivity : AppCompatActivity() {
    lateinit var binding : ActivityRecipeApplicationEnrollBinding
    /*private var dbHelper:DBHelper? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = ActivityRecipeApplicationEnrollBinding.inflate(inflater, container, false)

    }

} //Activity