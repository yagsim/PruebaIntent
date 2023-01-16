package com.example.pruebaintent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val RESULTADO_UNO = 1
    val RESULTADO_DOS = 2
    val RESULTADO_TRES = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navegador: Button= findViewById(R.id.navegador)
        navegador.setOnClickListener{
            val navegador=Intent(Intent.ACTION_VIEW)
            val url="http://www.google.com"
            navegador.data= Uri.parse(url)
            startActivity(navegador)
        }
        val llamar: Button= findViewById(R.id.llamar)
        llamar.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            // rellenamos el intent con el número
            intent.data = Uri.parse("tel:" + llamar.text)
            // llamamos a la activity treléfono
            startActivity(intent)

        }
        val boton: Button = findViewById(R.id.button)
        boton.setOnClickListener() {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("n1", 6)
            intent.putExtra("n2", 2)
            startActivityForResult(intent, RESULTADO_UNO)   //RESULTADO_UNO es el requestCode que recibe abajo
            intent.putExtra("numero1", 4)
            intent.putExtra("numero2", 9)
            startActivityForResult(intent, RESULTADO_DOS)
            intent.putExtra("numero1", 1)
            intent.putExtra("numero2", 5)
            startActivityForResult(intent, RESULTADO_TRES)
        }

    }

    @Deprecated("Deprecated a partir de API 30")
    // recoje el intent cuando hacemos setResult() en la SecondActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {  //request=ResultadoUno,resultCodeResultOk
        super.onActivityResult(requestCode, resultCode, data)
        // Definimos el text view para mostrar el dato que nos manda la Second
        val sumaUno = findViewById<TextView>(R.id.resultado1)
        val sumaDos = findViewById<TextView>(R.id.resultado2)
        val sumaTres = findViewById<TextView>(R.id.resultado3)
        // Comprueba que el resultado es OK
        if (resultCode != Activity.RESULT_OK ||data==null) return
        // Puedo distinguir diferentes acciones según el requestCode
            when (requestCode) {
                RESULTADO_UNO -> {
                    // si el intent no es null muestro el resultado
                    sumaUno.text = data.getIntExtra("suma",0).toString()
                }
                RESULTADO_DOS -> {
                    // si el intent no es null muestro el resultado
                    sumaDos.text = data.getIntExtra("suma",0).toString()
                }
                RESULTADO_TRES -> {
                    // si el intent no es null muestro el resultado
                    sumaTres.text = data.getIntExtra("suma",0).toString()
                }
                // Other result codes
                else -> {}
            }

    }
}