package za.ac.iiemsa.myicetask3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtName = findViewById<EditText>(R.id.edtName)
        val txtResults = findViewById<TextView>(R.id.txtResults)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnClear = findViewById<Button>(R.id.btnClear)


        btnCalculate.setOnClickListener {

            val numberstr = edtName.text.toString()

            if (numberstr.isEmpty()) {
                Toast.makeText(this, "please enter a number", Toast.LENGTH_SHORT).show()
            }
            val number = numberstr.toInt()
            var result = ""

            for (i in 1..10) {
                result += "$number *$1 = ${number * i}\n"

            }
            txtResults.text = result

        }
        btnClear.setOnClickListener {
            txtResults.text =""
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}