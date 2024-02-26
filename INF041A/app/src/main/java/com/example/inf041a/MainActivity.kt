package com.example.inf041a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var nameInput: EditText
    lateinit var surnameInput: EditText
    lateinit var emailInput: EditText
    lateinit var phoneInput: EditText
    lateinit var yachtInput: Spinner
    lateinit var allowInput: CheckBox
    lateinit var initialsRegex: Regex
    lateinit var emailRegex: Regex
    lateinit var phoneRegex: Regex
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameInput = findViewById(R.id.nameinput)
        surnameInput = findViewById(R.id.surnameinput)
        emailInput = findViewById(R.id.emailinput)
        phoneInput = findViewById(R.id.phoneinput)
        yachtInput = findViewById(R.id.yachtinput)
        allowInput = findViewById(R.id.allowinput)

        initialsRegex = Regex("""\w+""")
        emailRegex = Regex("""[\w\\._0-9]+@\w+\.\w+""")
        phoneRegex = Regex("""[0-9]{3}-[0-9]{3}-[0-9]{3}""")
    }

    fun onConfirm(view: View) {
        val name = nameInput.text.toString()
        val surname = surnameInput.text.toString()
        val email = emailInput.text.toString()
        val phone = phoneInput.text.toString()

        val initialsValidation: Boolean = initialsRegex.matches(name) && initialsRegex.matches(surname)
        val emailValidation: Boolean = emailRegex.matches(email)
        val phoneValidation: Boolean = phoneRegex.matches(phone)

        if (initialsValidation && emailValidation && phoneValidation) {
            val alertData: String = "Imię: ${name}; Nazwisko: ${name}; Email: ${email}, Telefon: ${phone}"
            val toastAlert = Toast.LENGTH_LONG
            val toastDialog = Toast.makeText(applicationContext, alertData, toastAlert)
            toastDialog.show()
        } else {
            val toastAlert = Toast.LENGTH_LONG
            val toastDialog = Toast.makeText(applicationContext, "Niepoprawnie wpisane dane", toastAlert)
            toastDialog.show()
        }
    }
}