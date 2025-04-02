package ad.cfp.endevina_el_nmero

import ad.cfp.endevina_el_nmero.databinding.ActivityJocBinding
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Joc : AppCompatActivity() {

    private lateinit var binding: ActivityJocBinding
    private var numeroAleatori = 0
    private var intents = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJocBinding.inflate(layoutInflater)
        setContentView(binding.root)

        numeroAleatori = (1..100).random()

        binding.btnComencar.setOnClickListener { comprovarInput() }
        binding.btnTornarInici.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun comprovarInput() {
        val numero = binding.inputNumero.text.toString().toIntOrNull()

        if (numero == null || numero !in 1..100) {
            mostrarMissatge("Introdueix un número vàlid!")
        } else {
            intents++
            comprovarNumero(numero)
        }
    }

    private fun comprovarNumero(numero: Int) {
        when {
            numero > numeroAleatori -> mostrarMissatge("Número massa alt!")
            numero < numeroAleatori -> mostrarMissatge("Número massa baix!")
            else -> {
                val intent = Intent(this, Resultats::class.java)
                intent.putExtra("INTENTS", intents)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun mostrarMissatge(missatge: String) {
        Toast.makeText(this, missatge, Toast.LENGTH_SHORT).show()
    }
}
