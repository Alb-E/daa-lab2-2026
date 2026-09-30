package ch.heigvd.iict.daa.template

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ch.heigvd.iict.daa.template.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val getName = registerForActivityResult(PickNameContract()) { name ->
        // on reçoit le résultat de la seconde activité ici
        username = getString(R.string.welcome_user, name)
        binding.textViewWelcome.text = username
    }
    private var username: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        // depuis android 15 (sdk 35), le mode edge2edge doit être activé
        enableEdgeToEdge()

        // on spécifie le layout à afficher
        setContentView(binding.root)

        // comme edge2edge est activé, l'application doit garder un espace suffisant pour la barre système
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        username = binding.textViewWelcome.text.toString()
        binding.buttonEdit.setOnClickListener {
            getName.launch(null)
        }

    }

    // Restoration
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("USERNAME_VALUE", username)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        username = savedInstanceState.getString("USERNAME_VALUE", getString(R.string.welcome))
        binding.textViewWelcome.text = username
    }

}