package com.example.coronavirus

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var change = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mostrarRiesgo = findViewById<ImageButton>(R.id.riesgo_button)
        mostrarRiesgo.setOnClickListener{
            riesgo(mostrarRiesgo)

        }
        val infoVirus = findViewById<Button>(R.id.virusButton)
        infoVirus.setOnClickListener{
            var num = Intent(this,Activity2::class.java)
            intent.putExtra("eleccion", 0)
        }
        val infoSintomas = findViewById<Button>(R.id.sintomasButton)
        sintomasButton.setOnClickListener{
            var num = Intent(this,Activity2::class.java)
            intent.putExtra("eleccion", 1)
        }
        val infoIndicaciones = findViewById<Button>(R.id.indicacionesButton)
        infoIndicaciones.setOnClickListener{
            var num = Intent(this,Activity2::class.java)
            intent.putExtra("eleccion", 2)
        }

    }

    private fun riesgo(view: View){

        if (!change){
            val editText1 = findViewById<EditText>(R.id.nombre_edit)
            val nombre = editText1.text.toString()

            val editText2 = findViewById<EditText>(R.id.edad_edit)
            val edad = Integer.parseInt(editText2.text.toString())
            val TextView2 = findViewById<TextView>(R.id.informacion)

            editText1.visibility = View.GONE
            editText2.visibility = View.GONE
            TextView2.visibility = View.VISIBLE

            if (edad <= 15){
                val TextView1 = findViewById<TextView>(R.id.informacion).apply {
                    text = "$nombre, por tu rango de edad estas en bajo riesgo si contraes el virus"
                }
            } else if (edad >= 50){
                val TextView1 = findViewById<TextView>(R.id.informacion).apply {
                    text = "$nombre, por tu rango de edad estas en un muy alto riesgo si contraes el virus"
                }
            }  else {
                val TextView1 = findViewById<TextView>(R.id.informacion).apply {
                    text = "$nombre, por tu rango de edad estas en alto riesgo si contraes el virus"
                }
            }

            change = true

            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        } else {
            val editText1 = findViewById<EditText>(R.id.nombre_edit)
            val editText2 = findViewById<EditText>(R.id.edad_edit)
            val TextView2 = findViewById<TextView>(R.id.informacion)

            editText1.visibility = View.VISIBLE
            editText2.visibility = View.VISIBLE
            TextView2.visibility = View.GONE

            change = false
        }

    }
}
