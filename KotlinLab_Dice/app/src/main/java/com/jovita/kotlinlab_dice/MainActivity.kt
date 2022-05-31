package com.jovita.kotlinlab_dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rollButon: Button = findViewById(R.id.btn_roll)
        rollButon.setOnClickListener { rollDice() }

        //Calling dice methord for an initial number
        rollDice()
    }

    /* rolls the dic andd displays dice image */
    private fun rollDice() {
        val myLuckyNumber = 2
        val myFirsDice = Dice(6)
        val mySecondDice = Dice(6)
        val firstDiceRoll = myFirsDice.rollDice()
        val secondDiceRoll = mySecondDice.rollDice()

        if (firstDiceRoll+secondDiceRoll == myLuckyNumber)
            Toast.makeText(this, "Hooray! Its your Lucky number!!", Toast.LENGTH_SHORT).show()
        setDiceUi(firstDiceRoll,secondDiceRoll)
    }

    fun setDiceUi(firstRoll:Int,secondRoll : Int){
        // finding image resource for the random number
        val firstImageResourcex = getImage(firstRoll)
        val secondImageResource = getImage(secondRoll)

        //displaying num on screen
        val diceImage1: ImageView = findViewById(R.id.img_first_dice)
        diceImage1.setBackgroundResource(firstImageResourcex)
        //content description
        diceImage1.contentDescription = firstRoll.toString()

        val diceImage2: ImageView = findViewById(R.id.img_second_dice)
        diceImage2.setBackgroundResource(secondImageResource)
        //content description
        diceImage2.contentDescription = secondRoll.toString()
    }

    fun getImage(diceNumber : Int) : Int{
        // finding image resource for the random number
        val imageResource = when (diceNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_1
        }
        return imageResource
    }
}

class Dice(private val numOfSides: Int) {
    fun rollDice(): Int {
        return (1..numOfSides).random()
    }
}