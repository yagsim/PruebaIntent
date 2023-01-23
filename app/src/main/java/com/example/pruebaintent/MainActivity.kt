package com.example.pruebaintent

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private val RESULTADO_UNO = 1
    private val REQUEST_IMAGE_CAPTURE = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val camara: Button = findViewById(R.id.camara)
        camara.setOnClickListener() {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)

        }


        val boton: Button = findViewById(R.id.button)
        boton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val random = kotlin.random.Random
            intent.putExtra("numero1", random.nextInt(0,100))
            intent.putExtra("numero2", random.nextInt(0,100))
            startActivityForResult(intent,RESULTADO_UNO)   //RESULTADO_UNO es el requestCode que recibe abajo

        }
    }


        @Deprecated("Deprecated a partir de API 30")
        // recoje el intent cuando hacemos setResult() en la SecondActivity
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {  //request=ResultadoUno,resultCodeResultOk
            super.onActivityResult(requestCode, resultCode, data)
            val imageView = findViewById<ImageView>(R.id.imageView)
            // Definimos el text view para mostrar el dato que nos manda la Second


            // Comprueba que el resultado es OK
            if (resultCode != Activity.RESULT_OK || data == null) return   //debemos recoger el data
            // Puedo distinguir diferentes acciones según el requestCode
            when (requestCode) {
                RESULTADO_UNO -> {
                    val sumaUno = findViewById<TextView>(R.id.resultado1)//recogemos textView
                    val num1 = data.getIntExtra("num1", 0)
                    val num2 = data.getIntExtra("num2", 0)
                    val suma = num1 + num2
                    val resIntro = data.getIntExtra("suma", 0)

                    //comprobación de la suma manual
                    if (suma == resIntro) {
                        sumaUno.text = "SUMA CORRECTA"
                    } else {
                        sumaUno.text = "SUMA INCORRECTA"
                    }
                }
                REQUEST_IMAGE_CAPTURE->{
                    val imageBitmap = data.extras!!.get("data") as Bitmap
                    imageView.setImageBitmap(imageBitmap)
                }

                // Other result codes
                else -> {}
            }

        }

    }

