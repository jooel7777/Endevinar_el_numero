package ad.cfp.endevina_el_nmero

import ad.cfp.endevina_el_nmero.databinding.ActivityResultatsBinding
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Resultats : AppCompatActivity() {
    private lateinit var binding: ActivityResultatsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultatsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intents = intent.getIntExtra("INTENTS", 0)
        binding.txtResultat.text = "Felicitats! Has encertat el número en $intents intents."

        binding.btnReiniciar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}