package com.example.fuelcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPrecoAlcool: EditText = findViewById(R.id.precoAlcool)
        val edtPrecoGasolina: EditText = findViewById(R.id.precoGasolina)
        val edtKmAlcool: EditText = findViewById(R.id.KM_Alcool)
        val edtKmGasolina: EditText = findViewById(R.id.KM_Gasolina)

        btnCalcular.setOnClickListener{

            val precoAlcoolStr: String = edtPrecoAlcool.text.toString()
            val precoGasolinaStr: String = edtPrecoGasolina.text.toString()
            val KmAlcoolStr: String = edtKmAlcool.text.toString()
            val KmGasolinaStr: String = edtKmGasolina.text.toString()

            if (precoAlcoolStr.isNotEmpty() && precoGasolinaStr.isNotEmpty() && KmAlcoolStr.isNotEmpty() && KmGasolinaStr.isNotEmpty()){
                val PrecoAlcool: Float = precoAlcoolStr.toFloat()
                val PrecoGasolina: Float = precoGasolinaStr.toFloat()
                val KmAlcool: Float = KmAlcoolStr.toFloat()
                val KmGasolina: Float = KmGasolinaStr.toFloat()

                val mediaAlcool: Float = KmAlcool / PrecoAlcool
                val mediaGasolina: Float = KmGasolina / PrecoGasolina

                val intent = Intent(this, FuelResult::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT_ALC", mediaAlcool)
                        putExtra("EXTRA_RESULT_GAS", mediaGasolina)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }

        }
    }
}