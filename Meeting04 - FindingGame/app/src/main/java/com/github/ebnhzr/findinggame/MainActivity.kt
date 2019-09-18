package com.github.ebnhzr.findinggame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.github.ebnhzr.findinggame.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val bigStarOnResId = 17301516
    private val bigStarOffResId = 17301515
    private lateinit var selectedView: View
    private var selectedId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val boxesId: List<Int> = listOf(
            binding.boxOneText.id,
            binding.boxSevenText.id,
            binding.boxTwoText.id,
            binding.boxThreeText.id,
            binding.boxFourText.id,
            binding.boxFiveText.id,
            binding.boxSixText.id,
            binding.boxEightText.id,
            binding.boxNineText.id
        )
        selectedId = boxesId[Random.nextInt(0, 9)]
        Log.d("ActivityMain :: ", "SelectedID: ${selectedId}; From: ${boxesId}")
        setListeners()
    }

    private fun setBehavior(view: View) {
        if(view.id == selectedId) {
            setButtonBackground(view, bigStarOnResId)
            selectedView = view
            winHandler()
        } else setButtonBackground(view, bigStarOffResId)
    }

    private fun setButtonBackground(view: View, buttonIcon: Int) {
        view.setBackgroundResource(buttonIcon)
    }

    private fun winHandler() {
        Toast.makeText(this, "YOU FOUND IT!", Toast.LENGTH_LONG).show()
        selectedView.setOnClickListener {
            resetAll()
        }
    }

    private fun resetAll() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val boxesId: List<Int> = listOf(
            binding.boxOneText.id,
            binding.boxTwoText.id,
            binding.boxThreeText.id,
            binding.boxFourText.id,
            binding.boxFiveText.id,
            binding.boxSixText.id,
            binding.boxSevenText.id,
            binding.boxEightText.id,
            binding.boxNineText.id

        )
        selectedId = boxesId[Random.nextInt(0, 9)]
        Log.d("ActivityMain :: ", "SelectedID: ${selectedId}; From: ${boxesId}")

        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
        val boxSixText = findViewById<TextView>(R.id.box_six_text)
        val boxSevenText = findViewById<TextView>(R.id.box_seven_text)
        val boxEightText = findViewById<TextView>(R.id.box_eight_text)
        val boxNineText = findViewById<TextView>(R.id.box_nine_text)

        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText, boxSixText, boxSevenText, boxEightText, boxNineText)

        for (item in clickableViews) {
            item.setOnClickListener {
                setBehavior(it)
            }
            item.setBackgroundColor(Color.WHITE)
        }
    }

    private fun setListeners() {
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
        val boxSixText = findViewById<TextView>(R.id.box_six_text)
        val boxSevenText = findViewById<TextView>(R.id.box_seven_text)
        val boxEightText = findViewById<TextView>(R.id.box_eight_text)
        val boxNineText = findViewById<TextView>(R.id.box_nine_text)


        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText, boxSixText, boxSevenText, boxEightText, boxNineText)

        for (item in clickableViews) {
            item.setOnClickListener {
                setBehavior(it)
            }
        }
    }
}