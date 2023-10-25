package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }

    fun clickable(view: View) {
        val buttonSelected = view as ImageButton
        var calld=0
        when(buttonSelected.id)
        {
            R.id.imageButton  -> calld = 1
            R.id.imageButton2 -> calld = 2
            R.id.imageButton3 -> calld = 3
            R.id.imageButton4 -> calld = 4
            R.id.imageButton5 -> calld = 5
            R.id.imageButton6 -> calld = 6
            R.id.imageButton7 -> calld = 7
            R.id.imageButton8 -> calld = 8
            R.id.imageButton9 -> calld = 9
        }
        play(calld,buttonSelected)
        winner()
        reSetGame()
    }
    //To Restart the Game
    private fun reSetGame() {
        binding.button.setOnClickListener{
            recreate()
        }
    }

    private fun winner() {
        var winner = 0
        //for first row
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))
        {
            winner = 1
        }
        //second row
        if(player1.contains(4) && player1.contains(5) && player1.contains(6))
        {
            winner = 1
        }
        // third row
        if(player1.contains(7) && player1.contains(8) && player1.contains(9))
        {
            winner = 1
        }

        //first column
        if(player1.contains(1) && player1.contains(4) && player1.contains(7))
        {
            winner = 1
        }
        //second column
        if(player1.contains(2) && player1.contains(5) && player1.contains(8))
        {
            winner = 1
        }

        //third column
        if(player1.contains(3) && player1.contains(6) && player1.contains(9))
        {
            winner = 1
        }

        //diagonal 1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9))
        {
            winner = 1
        }
        //diagonal 2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7))
        {
            winner = 1
        }

        //for player 2

        //for first row
        if(player2.contains(1) && player2.contains(2) && player2.contains(3))
        {
            winner = 2
        }
        //second row
        if(player2.contains(4) && player2.contains(5) && player2.contains(6))
        {
            winner = 2
        }
        // third row
        if(player2.contains(7) && player2.contains(8) && player2.contains(9))
        {
            winner = 2
        }

        //first column
        if(player2.contains(1) && player2.contains(4) && player2.contains(7))
        {
            winner = 2
        }
        //second column
        if(player2.contains(2) && player2.contains(5) && player2.contains(8))
        {
            winner = 2
        }

        //third column
        if(player2.contains(3) && player2.contains(6) && player2.contains(9))
        {
            winner = 2
        }

        //diagonal 1
        if(player2.contains(1) && player2.contains(5) && player2.contains(9))
        {
            winner = 2
        }
        //diagonal 2
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if(winner==1)
        {
            Toast.makeText(this,"Player one win",Toast.LENGTH_SHORT).show()
        }
        else if (winner==2)
        {
            Toast.makeText(this,"Player two win",Toast.LENGTH_SHORT).show()
        }
    }

    var currentPlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    private fun play(calld: Int, buttonSelected: ImageButton) {
        if(currentPlayer == 1) {
            buttonSelected.setBackgroundResource(R.drawable.green_o)
            player1.add(calld)
            currentPlayer=2
        }
        else{
            buttonSelected.setBackgroundResource(R.drawable.red_x)
            player2.add(calld)
            currentPlayer=1
        }

    }
}