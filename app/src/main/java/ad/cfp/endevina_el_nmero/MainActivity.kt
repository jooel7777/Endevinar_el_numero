package ad.cfp.endevina_el_nmero

import ad.cfp.endevina_el_nmero.databinding.ActivityMainBinding
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIniciar.setOnClickListener {
            startActivity(Intent(this, Joc::class.java))
            finish()
        }

    }
}

private fun ActivityMainBinding.onCreate(bundle: Bundle?) {}
wfeghrtj