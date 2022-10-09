package com.example.mathgame1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

    class MainActivity : AppCompatActivity() {

    //variables
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button

    lateinit var buttons: Array<Button>

    lateinit var resultTextView: TextView

    var firstButtonPressed = false
    var firstValue = 0
    var secondValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //buttons array
        buttons = arrayOf(
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4)
        )

        for (button in buttons)
        {
            button.setOnClickListener()
            {
                view : View ->
                checkQuestion(view)
            }
        }

        resultTextView = findViewById(R.id.resultTextView)

        //do generateQuestion() function
        generateQuestion()
    }
        //generate question on load
    fun generateQuestion()
    {
        //refresh value
        firstButtonPressed = false
        firstValue = 0
        secondValue = 0

        var randomGenerator = Random(System.currentTimeMillis())


        //random generator stuff
        var result      = randomGenerator.nextInt(10, 20)
        var firstCorrectValue  = randomGenerator.nextInt(1, result-1)
        var secondCorrectValue = result - firstCorrectValue

        resultTextView.text = result.toString()

        var firstRandomValue = randomGenerator.nextInt(1, result-1)
        var secondRandomValue = randomGenerator.nextInt(1, result-1)


        var arrayInt = arrayOf(0, 1, 2, 3)
        arrayInt.shuffle(randomGenerator)

        //correct values
        buttons[arrayInt[0]].text = firstCorrectValue.toString()
        buttons[arrayInt[1]].text = secondCorrectValue.toString()

        //random (incorrect) values
        buttons[arrayInt[2]].text = firstRandomValue.toString()
        buttons[arrayInt[3]].text = secondRandomValue.toString()

        for (x in arrayInt) println(x)
    }

    private fun checkQuestion(view : View)
    {
        var buttonPressed = view as Button

        println(buttonPressed.text)

        //results here, second button value here
        if (firstButtonPressed)
        {
            secondValue = buttonPressed.text.toString().toInt()
            var result = firstValue + secondValue
            println(result)

            generateQuestion()
        }

        //check the first button value
        else
        {
            firstValue = buttonPressed.text.toString().toInt()
            firstButtonPressed = true
        }
    }
}