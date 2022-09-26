package com.emagnwodpu.updowngame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    var difficulty: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rgDifficulty = findViewById<RadioGroup>(R.id.rg_difficulty)
        rgDifficulty.setOnCheckedChangeListener { group, id ->
            when(id) {
                R.id.rb_difficult_easy -> difficulty = 0
                R.id.rb_difficult_normal -> difficulty = 1
                R.id.rb_difficult_hard -> difficulty = 2
            }
        }

        var btnStart = findViewById<AppCompatButton>(R.id.btn_start)
        btnStart.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("difficulty", difficulty)
            startActivity(intent)
        })
    }

}