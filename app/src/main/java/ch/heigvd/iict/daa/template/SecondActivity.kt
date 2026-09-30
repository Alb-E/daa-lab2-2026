package ch.heigvd.iict.daa.template

import android.content.Intent
import android.os.Bundle
import ch.heigvd.iict.daa.template.databinding.ActivitySecondBinding
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener {
            val fieldValue = binding.editTextName.text.toString()
            val data = Intent()
            data.putExtra(ASK_FOR_NAME_RESULT_KEY, fieldValue)
            setResult(RESULT_OK, data)
            finish()
        }
    }

    companion object {
        val ASK_FOR_NAME_RESULT_KEY = "NAME_KEY"
    }
}