package com.example.coronavirus

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*


class MainActivity : AppCompatActivity() {

    var activar = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mostrarRiesgo = findViewById<ImageButton>(R.id.riesgo_button)
        mostrarRiesgo.setOnClickListener{
            riesgo(mostrarRiesgo)
        }

    }

    private fun riesgo(view: View){

        if (!activar){
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
                    text = "$nombre, Por tu rango de edad estas en bajo riesgo si contraes el virus"
                }
            } else if (edad >= 50){
                val TextView1 = findViewById<TextView>(R.id.informacion).apply {
                    text = "$nombre, Por tu rango de edad estas en un muy alto riesgo si contraes el virus"
                }
            }  else {
                val TextView1 = findViewById<TextView>(R.id.informacion).apply {
                    text = "$nombre, Por tu rango de edad estas en alto riesgo si contraes el virus"
                }
            }

            activar = true

            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        } else {
            val editText1 = findViewById<EditText>(R.id.nombre_edit)
            val editText2 = findViewById<EditText>(R.id.edad_edit)
            val TextView2 = findViewById<TextView>(R.id.informacion)

            editText1.visibility = View.GONE
            editText2.visibility = View.GONE
            TextView2.visibility = View.VISIBLE

            activar = false
        }

    }
}
