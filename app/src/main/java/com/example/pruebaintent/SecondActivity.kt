package com.example.pruebaintent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // Recoge el Intent que ha iniciado la actividad
        val intent = getIntent()

        // En cada text view inserto el numero aleatorio 1 y el 2
        val valUno = findViewById<TextView>(R.id.val1)
        val num1= intent.getIntExtra("numero1", 0)  //recojo el numero1 del main
        valUno.text=num1.toString()

        val valDos = findViewById<TextView>(R.id.val2)
        val num2= intent.getIntExtra("numero2",0)//recojo el numero2 del main
        valDos.text=num2.toString()

        val resIntro=findViewById<EditText>(R.id.SUMA)



        val boton: Button = findViewById(R.id.button2)  //al darle al boton compruebo
        boton.setOnClickListener {
            val res : Int = resIntro.text.toString().toInt()
            intent.putExtra("sumaIntro", res)

            setResult(Activity.RESULT_OK, intent);   //una vez echo esto salta el metodo onActivityForResult
            // cierro la activity
            finish()
        }


    }

}


