package com.example.coronavirus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.coronavirus.databinding.Activity2Binding


class Activity2 : AppCompatActivity() {

    private lateinit var binding: Activity2Binding
    private lateinit var topic: Topic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_2)
        var eleccion = intent.extras?.getInt("eleccion") as Int

        mostrarInformacion(eleccion)
    }

    fun mostrarInformacion(eleccion: Int){
        when(eleccion){
            0 -> topic = Topic(getString(R.string.Virus_Titulo),getString(R.string.Virus_Subtitulo),getString(R.string.Virus))
            1 -> topic = Topic(getString(R.string.Sintomas_Titulo),getString(R.string.Sintomas_Subtitulo),getString(R.string.Sintomas))
            2 -> topic = Topic(getString(R.string.Indicaciones_Titulo),getString(R.string.Indicaciones_Subtitulo),getString(R.string.Indicaciones))
            else -> topic = Topic("","","")
        }
        binding.topic = topic
    }
}
