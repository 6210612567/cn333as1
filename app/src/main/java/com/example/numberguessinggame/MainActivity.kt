package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var textCount: TextView
    lateinit var editText: EditText
    lateinit var imageButtonCheck: ImageButton
    lateinit var btnReset: Button

    var random: Int = nextInt(1, 1000)
    var count: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        textCount = findViewById(R.id.textCount)
        editText = findViewById(R.id.editText)
        imageButtonCheck = findViewById(R.id.imageButtonCheck)
        btnReset = findViewById(R.id.buttonReset)


        imageButtonCheck.setOnClickListener{
            val number: Int = editText.text.toString().toInt()

            if (number < random )
            {
                textView.text = "HINT: It's to lower!"
                editText.text.clear()
                count += 1
            }
            else if (number > random )
            {
                textView.text = "Hint: It's to higher!"
                editText.text.clear()
                count += 1
            }
            else
            {
                textView.text = "Congratulations , your number is correct!"
                textCount.text = "You have played $count times"
            }
        }
        btnReset.setOnClickListener{
            random = nextInt(1, 1000)
            count = 0
            textCount.text = ""
            textView.text = ""
            editText.text.clear()
        }

    }
}