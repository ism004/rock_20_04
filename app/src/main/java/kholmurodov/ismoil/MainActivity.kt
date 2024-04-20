package kholmurodov.ismoil

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import android.graphics.Color
import androidx.annotation.ColorInt;


class MainActivity : AppCompatActivity() {
    private var userChoice: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val choices = listOf("Камень", "Ножницы", "Бумага", "Ящерица", "Спок")

        val buttonPlay = findViewById<Button>(R.id.btnPlay)
        val buttonRock = findViewById<Button>(R.id.btnRock)
        val buttonScissors = findViewById<Button>(R.id.btnScissors)
        val buttonPaper = findViewById<Button>(R.id.btnPaper)
        val buttonLizard = findViewById<Button>(R.id.btnLizard)
        val buttonSpock = findViewById<Button>(R.id.btnSpock)

        // Установка слушателей для кнопок выбора
        buttonRock.setOnClickListener { userChoice = "Камень" }
        buttonScissors.setOnClickListener { userChoice = "Ножницы" }
        buttonPaper.setOnClickListener { userChoice = "Бумага" }
        buttonLizard.setOnClickListener { userChoice = "Ящерица" }
        buttonSpock.setOnClickListener { userChoice = "Спок" }

        buttonPlay.setOnClickListener {
            if (userChoice == null) {
                Toast.makeText(this, "Пожалуйста, сделайте выбор", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val computerChoice = choices.random()

            val result = when {
                (userChoice == "Камень" && computerChoice == "Ножницы") ||
                        (userChoice == "Ножницы" && computerChoice == "Бумага") ||
                        (userChoice == "Бумага" && computerChoice == "Камень") ||
                        (userChoice == "Камень" && computerChoice == "Ящерица") ||
                        (userChoice == "Ящерица" && computerChoice == "Спок") ||
                        (userChoice == "Спок" && computerChoice == "Ножницы") ||
                        (userChoice == "Ножницы" && computerChoice == "Ящерица") ||
                        (userChoice == "Ящерица" && computerChoice == "Бумага") ||
                        (userChoice == "Бумага" && computerChoice == "Спок") ||
                        (userChoice == "Спок" && computerChoice == "Камень") -> "Победил пользователь"
                else -> "Победил компьютер"
            }

            // Определение цветов
            val greenColor = resources.getColor(android.R.color.holo_green_light)
            val redColor = resources.getColor(android.R.color.holo_red_light)

            // Изменение цвета кнопок в зависимости от результата
            // Изменение цвета кнопок в зависимости от результата
            if (result == "Победил пользователь") {
                when (userChoice) {
                    "Камень" -> buttonRock.setBackgroundColor(Color.GREEN)
                    "Ножницы" -> buttonScissors.setBackgroundColor(Color.GREEN)
                    "Бумага" -> buttonPaper.setBackgroundColor(Color.GREEN)
                    "Ящерица" -> buttonLizard.setBackgroundColor(Color.GREEN)
                    "Спок" -> buttonSpock.setBackgroundColor(Color.GREEN)
                }
                when (computerChoice) {
                    "Камень" -> buttonRock.setBackgroundColor(Color.RED)
                    "Ножницы" -> buttonScissors.setBackgroundColor(Color.RED)
                    "Бумага" -> buttonPaper.setBackgroundColor(Color.RED)
                    "Ящерица" -> buttonLizard.setBackgroundColor(Color.RED)
                    "Спок" -> buttonSpock.setBackgroundColor(Color.RED)
                }
            } else {
                when (computerChoice) {
                    "Камень" -> buttonRock.setBackgroundColor(Color.GREEN)
                    "Ножницы" -> buttonScissors.setBackgroundColor(Color.GREEN)
                    "Бумага" -> buttonPaper.setBackgroundColor(Color.GREEN)
                    "Ящерица" -> buttonLizard.setBackgroundColor(Color.GREEN)
                    "Спок" -> buttonSpock.setBackgroundColor(Color.GREEN)
                }
                when (userChoice) {
                    "Камень" -> buttonRock.setBackgroundColor(Color.RED)
                    "Ножницы" -> buttonScissors.setBackgroundColor(Color.RED)
                    "Бумага" -> buttonPaper.setBackgroundColor(Color.RED)
                    "Ящерица" -> buttonLizard.setBackgroundColor(Color.RED)
                    "Спок" -> buttonSpock.setBackgroundColor(Color.RED)
                }
            }


            Toast.makeText(this, "$result\nВыбор пользователя: $userChoice\nВыбор компьютера: $computerChoice", Toast.LENGTH_LONG).show()
        }
    }
}
