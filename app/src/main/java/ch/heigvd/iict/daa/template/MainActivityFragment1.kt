package ch.heigvd.iict.daa.template

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ch.heigvd.iict.daa.template.databinding.ActivityMainFragment1Binding
import ch.heigvd.iict.daa.template.fragments.ColorFragment
import ch.heigvd.iict.daa.template.fragments.CounterFragment

class MainActivityFragment1 : AppCompatActivity() {
    private lateinit var binding: ActivityMainFragment1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFragment1Binding.inflate(layoutInflater)

        // depuis android 15 (sdk 35), le mode edge2edge doit être activé
        enableEdgeToEdge()

        // on spécifie le layout à afficher
        setContentView(binding.root)

        // comme edge2edge est activé, l'application doit garder un espace suffisant pour la barre système
        ViewCompat.setOnApplyWindowInsetsListener(binding.mainFragment1) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}