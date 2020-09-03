package com.example.notamedia

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_01.setOnClickListener(this)
    }

    private fun validarFormulario(): Boolean {
        if (et_nome.text.toString().isEmpty()) {
            et_nome.error = "*"
            return false
        } else if (et_nota1.text.toString().isEmpty()) {
            et_nota1.error = "*"
            return false
        } else if (et_nota2.text.toString().isEmpty()) {
            et_nota2.error = "*"
            return false
        }
        return true
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.bt_01 -> {
                if (validarFormulario()) {
                    val nome = et_nome.text
                    val nota1 = et_nota1.text.toString().toDouble()
                    val nota2 = et_nota2.text.toString().toDouble()
                    val media = (nota1 + nota2) / 2

                    if (media >= 5) {
                        tv_resultado.text = "${nome} Você foi aprovado!! Sua média é de: ${media}"
                        tv_resultado.setTextColor(Color.GREEN)
                        tv_resultado.visibility = View.VISIBLE
                    } else {
                        tv_resultado.text = "${nome} Você foi reprovado. Sua média é de: ${media}"
                        tv_resultado.setTextColor(Color.RED)
                        tv_resultado.visibility = View.VISIBLE
                    }
                } else {
                    Toast.makeText(
                        this,
                        "Por favor, preencha todos os campos!",
                        Toast.LENGTH_SHORT
                    ).show()
                    tv_resultado.text = "Por favor, preencha todos os campos!"
                    tv_resultado.setTextColor(Color.RED)
                    tv_resultado.visibility = View.VISIBLE
                }
            }
        }
    }
}

