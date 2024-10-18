package com.example.lessononeapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lessononeapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val text = findViewById<TextView>(R.id.textView1)
        val num = findViewById<TextView>(R.id.textView2)

        val messageText = intent.getStringExtra("text")
        val numText = intent.getIntExtra("num", 1)
        text.text = messageText
        num.text = numText.toString()

        val btn: Button = findViewById(R.id.btnCapOrWom)
        val tv: TextView = findViewById(R.id.capOrWom)

        btn.setOnClickListener {
            if (binding.cap.isChecked) tv.text = "Capybara it's cool animal"
            else if (binding.wom.isChecked) tv.text = "Wombat it's cool animal"
            else tv.text = "Сhoose an answer"
        }
    }
}