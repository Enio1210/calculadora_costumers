package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity(){


    //lembre se
// coloca a logica em outra pasta ,,pro codigo ficar mais limpo.





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// numeros

        val um: TextView = findViewById(R.id.um)
        val dois: TextView = findViewById(R.id.dois)
        val tres: TextView = findViewById(R.id.tres)
        val quatro: TextView = findViewById(R.id.quatro)
        val cinco: TextView = findViewById(R.id.cinco)
        val seis: TextView = findViewById(R.id.seis)
        val sete: TextView = findViewById(R.id.sete)
        val oito: TextView = findViewById(R.id.oito)
        val nove: TextView = findViewById(R.id.nove)
        val zero: TextView = findViewById(R.id.zero)
        val zero_d:TextView= findViewById(R.id.dois_zeros)
// sinais
        val adicao: TextView = findViewById(R.id.adicao)
        val multiplicacao: TextView = findViewById(R.id.multiplicacao)
        val divisao: TextView = findViewById(R.id.divisao)
        val subtracao: TextView = findViewById(R.id.subtracao)
        val igual: TextView = findViewById(R.id.igual)
        val porcentagem: TextView = findViewById(R.id.porcentagem)


        // textVIew
        val ponto:TextView= findViewById(R.id.ponto)

        val clear:ImageView= findViewById(R.id.apaga)
        val clear_all:TextView= findViewById(R.id.apagar_tudo)

        var result: TextView = findViewById(R.id.result)
        val expression: TextView = findViewById(R.id.expression)



// avalia a expressao ,,

        igual.setOnClickListener {
            try {
                val expressionStr = expression
                val expression = ExpressionBuilder(expressionStr.text.toString()).build()
                val resultado = expression.evaluate()
                val longResult=resultado.toLong()
                if(resultado==longResult.toDouble())

                    result.text = longResult.toString()
                else
                    result.text=result.toString()
            } catch (e: Exception) {
                Log.d("Exception", ":" + e.message)
            }
        }

        // funcionalidades de limpeza em uma calculadora

        clear_all.setOnClickListener{
            expression.text=""
            result.text=""
        }
        clear.setOnClickListener{
            val string= expression.text.toString()
            if(string.isNotEmpty()){
                expression.text= string.substring(0,string.length-1)
            }
            result.text=""
        }


        // porcentagens
        fun appendenExpression(string: String, canClear: Boolean) {

            if(result.text.isNotEmpty()){
                expression.text=""
            }

            if (canClear) {
                result.text = ""
                expression.append(string)
            } else {
                expression.append(result.text)
                result.append(string)
                result.text = ""
            }
        }

        porcentagem.setOnClickListener {
            appendenExpression("%", false)
        }



        // clique dos botoes

        um.setOnClickListener {
            appendenExpression("1", true)
        }
        dois.setOnClickListener {
            appendenExpression("2", true)
        }
        tres.setOnClickListener {
            appendenExpression("3", true)
        }
        quatro.setOnClickListener {
            appendenExpression("4", true)
        }
        cinco.setOnClickListener {
            appendenExpression("5", true)
        }
        seis.setOnClickListener {
            appendenExpression("6", true)
        }
        sete.setOnClickListener {
            appendenExpression("7", true)
        }
        oito.setOnClickListener {
            appendenExpression("8", true)
        }
        nove.setOnClickListener {
            appendenExpression("9", true)
        }
        zero.setOnClickListener {
            appendenExpression("0", true)
        }
        zero_d.setOnClickListener {
            appendenExpression("00", true)
        }

        // operacao

        adicao.setOnClickListener {
            appendenExpression("+", true)
        }

        subtracao.setOnClickListener {
            appendenExpression("-", true)
        }
        multiplicacao.setOnClickListener {
            appendenExpression("*", true)
        }
        divisao.setOnClickListener {
            appendenExpression("/", true)
        }
        porcentagem.setOnClickListener {
            appendenExpression("%", true)
        }
        ponto.setOnClickListener {
            appendenExpression(".", true)
        }

    }



}


