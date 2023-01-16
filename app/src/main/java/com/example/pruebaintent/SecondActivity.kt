package com.example.pruebaintent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // Recoge el Intent que ha iniciado la actividad
        val intent = getIntent()

        // Recoge el valor de tipo String pasado en el Intent
        val num1= intent.getIntExtra("n1", 0)
        val num2= intent.getIntExtra("n2",0)

        // Meto un nuevo dato en el intent
        intent.putExtra("suma",num1+num2);

        setResult(Activity.RESULT_OK, intent);   //una vez echo esto salta el metodo onActivityForResult

        // cierro la activity
        finish()
    }
}


