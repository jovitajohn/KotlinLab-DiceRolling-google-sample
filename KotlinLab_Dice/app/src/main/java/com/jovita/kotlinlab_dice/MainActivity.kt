package com.jovita.kotlinlab_dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rollButon: Button = findViewById(R.id.btn_roll)
        rollButon.setOnClickListener { rollDice() }
    }

    /* rolls the dic andd displays number */
    private fun rollDice() {
        val myFirsDice = Dice(6)
        val message: TextView = findViewById(R.id.txt_messaage)
        //displaying num on screen
        message.text = myFirsDice.rollDice().toString()
    }
}

class Dice(private val numOfSides: Int) {
    fun rollDice(): Int {
        return (1..numOfSides).random()
    }
}