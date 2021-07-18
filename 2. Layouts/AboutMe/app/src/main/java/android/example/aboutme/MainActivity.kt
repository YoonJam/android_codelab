package android.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var nicknameEdit: EditText
    private lateinit var nicknameText: TextView
    private lateinit var doneButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doneButton = findViewById(R.id.done_button)
        nicknameEdit = findViewById(R.id.nickname_edit)
        nicknameText = findViewById(R.id.nickname_text)

        doneButton.setOnClickListener {
            addNickname(it)
        }

        nicknameText.setOnClickListener {
            updateNickname(it)
        }
    }

    private fun addNickname(view: View) {
        nicknameText.text = nicknameEdit.text
        nicknameText.visibility = View.VISIBLE
        nicknameEdit.visibility = View.GONE
        view.visibility = View.GONE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname (view: View) {
        nicknameEdit.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        nicknameEdit.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nicknameEdit, 0)


    }
}