package com.devserginho.fuelcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FuelResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fuel_result)

        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)

        val mediaAlcool = intent.getFloatExtra("EXTRA_RESULT_ALC", 0.0f)
        val mediaGasolina = intent.getFloatExtra("EXTRA_RESULT_GAS", 0.0f)

        val melhorOpcao = if (mediaAlcool < mediaGasolina) "Álcool" else "Gasolina"
        val economiaTotal: Float = if (melhorOpcao == "Álcool") {
            mediaGasolina - mediaAlcool
        } else {
            mediaAlcool - mediaGasolina
        }

        txtResultado.text = getString(R.string.resultado_text, melhorOpcao, economiaTotal)

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}