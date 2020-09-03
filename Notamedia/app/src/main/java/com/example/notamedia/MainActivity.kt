package com.example.notamedia

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun calcularMedia(componente:View){
        val nome = et_nome.text
        val nota1 = et_nota1.text.toString().toDouble()
        val nota2 = et_nota2.text.toString().toDouble()
        val media = (nota1 + nota2)/2

        if (media >=5){
            tv_resultado.text = "${nome} Você foi aprovado!! Sua média é de: ${media}"
            tv_resultado.setTextColor(Color.BLUE)
            tv_resultado.visibility = View.VISIBLE
        }
        else{
            tv_resultado.text = "${nome} Você foi reprovado. Sua média é de: ${media}"
            tv_resultado.setTextColor(Color.RED)
            tv_resultado.visibility = View.VISIBLE
        }
    }
}