package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var dice1Image: ImageView
    private lateinit var dice2Image: ImageView
    private lateinit var rollButton: Button
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollButton = findViewById(R.id.roll_button)
        dice1Image = findViewById(R.id.dice1_image)
        dice2Image = findViewById(R.id.dice2_image)
        clearButton = findViewById(R.id.clear_button)

        rollButton.setOnClickListener { rollDice() }
        clearButton.setOnClickListener { clearDice() }
    }

    private fun rollDice() {
        dice1Image.setImageResource(getRandomDiceImage())
        dice2Image.setImageResource(getRandomDiceImage())
    }

    private fun clearDice() {
        dice1Image.setImageResource(R.drawable.empty_dice)
        dice2Image.setImageResource(R.drawable.empty_dice)
    }

    private fun getRandomDiceImage(): Int {
        return when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

}