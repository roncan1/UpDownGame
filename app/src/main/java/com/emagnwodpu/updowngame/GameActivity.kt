package com.emagnwodpu.updowngame

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    var indexAll = 0
    var indexCorrect = 0
    var chance = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        startGame()
        onClick()
    }

    fun startGame() {
        var d = intent.getIntExtra("difficulty", 1)
        if (d == 0) {
            indexAll = 40
            indexCorrect = Random.nextInt(40)+1
        } else if (d == 1) {
            indexAll = 60
            indexCorrect = Random.nextInt(60)+1
        } else {
            indexAll = 80
            indexCorrect = Random.nextInt(80)+1
        }

        var tvIndexAll = findViewById<TextView>(R.id.tv_length)
        tvIndexAll.text = "전체 크기 : $indexAll"
    }

    fun onClick() {
        var etNum = findViewById<EditText>(R.id.et_num)
        var btnGo = findViewById<AppCompatButton>(R.id.btn_go)
        var tvChance = findViewById<TextView>(R.id.tv_chance)
        btnGo.setOnClickListener(View.OnClickListener {
            val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            var tmp = Integer.parseInt(etNum.text.toString())
            if (tmp > indexCorrect && chance >= 2) {
                btnGo.text = "DOWN"
            } else if (tmp < indexCorrect && chance >= 2) {
                btnGo.text = "UP"
            } else if (tmp == indexCorrect && chance >= 2){
                Toast.makeText(this, "맞추셨습니다!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "실패하였습니다...", Toast.LENGTH_SHORT).show()
                finish()
            }
            chance--
            tvChance.text = "남은 기회 : $chance"
        })
    }
}
