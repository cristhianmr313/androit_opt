package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //0->nada, 1->suma, 2->resta, 3->multiplicacion, 4->divicion
    var oper: Int=0
    var numero1:Double =0.0
    lateinit var tv_num1:TextView
    lateinit var tv_num2:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)
        val btnBorrar: Button = findViewById(R.id.btnBorrar)
        val btnIgual: Button = findViewById(R.id.btnIgual)

        btnIgual.setOnClickListener {
            var number2:Double= tv_num2.text.toString().toDouble()
            var resp: Double=0.0
            when(oper){
            1->resp = numero1 + number2
            2->resp = numero1 - number2
            3->resp = numero1 * number2
            4->resp = numero1 / number2
        }
            tv_num2.setText(resp.toString())
            tv_num1.setText("")
        }





        btnBorrar.setOnClickListener {
            tv_num1.setText("")
            tv_num2.setText("")
            numero1=0.0
            oper=0
        }
    }

    fun presionarDigito(view: View){
      // val tv_num2:TextView = findViewById( R.id.tv_num2)
        var num2:String = tv_num2.text.toString()

        when(view.id){
           R.id.butt0->tv_num2.setText(num2 + "0")
            R.id.butt1->tv_num2.setText(num2 + "1")
            R.id.butt2->tv_num2.setText(num2 + "2")
            R.id.butt3->tv_num2.setText(num2 + "3")
            R.id.butt4->tv_num2.setText(num2 + "4")
            R.id.butt5->tv_num2.setText(num2 + "5")
            R.id.butt6->tv_num2.setText(num2 + "6")
            R.id.butt7->tv_num2.setText(num2 + "7")
            R.id.butt8->tv_num2.setText(num2 + "8")
            R.id.butt9->tv_num2.setText(num2 + "9")
            R.id.buttPunto->tv_num2.setText(num2 + '.')
        }
    }

    fun clicOperacion(view:View){
        numero1=tv_num2.text.toString().toDouble()
        var num2_text:String=tv_num2.text.toString()
        tv_num2.setText("")

        when(view.id){
            R.id.suma ->{
                tv_num1.setText(num2_text + "+")
                oper =1
            }
            R.id.resta ->{
                tv_num1.setText(num2_text + "-")
                oper =2
            }
            R.id.multiplicacion ->{
                tv_num1.setText(num2_text + " *")
                oper =3
            }
            R.id.division ->{
                tv_num1.setText(num2_text + "/")
                oper =4
            }
        }

    }
}