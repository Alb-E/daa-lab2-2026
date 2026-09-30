package ch.heigvd.iict.daa.template

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class PickNameContract : ActivityResultContract<Void?, String?>() {
    override fun createIntent(context: Context, input: Void?) =
        Intent(context, SecondActivity::class.java)

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        if (resultCode != Activity.RESULT_OK) {
            return null
        }
        return intent?.getStringExtra(SecondActivity.ASK_FOR_NAME_RESULT_KEY)
    }
}
