package com.emagnwodpu.updowngame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    var indexAll = 0
    var indexCorrect = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    fun startGame() {
        var d = intent.getIntExtra("difficulty", 1)
        if (d == 0) {
            indexAll = 30
            indexCorrect = Random.nextInt(30)+1
        } else if (d == 1) {
            indexAll = 50
            indexCorrect = Random.nextInt(50)+1
        } else {
            indexAll = 70
            indexCorrect = Random.nextInt(70)+1
        }
    }

    fun onClick() {
        var etNum = findViewById<EditText>(R.id.et_num)
        var btnGo = findViewById<AppCompatButton>(R.id.btn_go)
        btnGo.setOnClickListener(View.OnClickListener {
            var tmp = Integer.parseInt(etNum.text.toString())
            if (tmp > indexCorrect) {
                
            }
        })
    }
}