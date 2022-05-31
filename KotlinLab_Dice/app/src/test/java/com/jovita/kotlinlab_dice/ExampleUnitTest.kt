package com.jovita.kotlinlab_dice

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun generatenumberFromDice() {
        val dice = Dice(6)
        val rolled = dice.rollDice()
        assertTrue("The number is within dice sides",rolled in 1..6)
    }
}