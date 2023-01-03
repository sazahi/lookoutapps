package id.kotlin.recyclerview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import id.kotlin.recyclerview.Api.RetrofitHelper
import id.kotlin.recyclerview.Api.TodoApi
import id.kotlin.recyclerview.Api.TodoData
import kotlinx.android.synthetic.main.activity_create.*
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class
create : AppCompatActivity() {

    lateinit var etUsername: EditText
    lateinit var etDescription: EditText

    val apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Impsc3N2cmV0cGJ6c25uYmZwaWpkIiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzA1ODMwMDUsImV4cCI6MTk4NjE1OTAwNX0.XzG93lsdOa4ap-NMu1cgquhdmywh1924-WnuM9f3fXs"
    val token = "Bearer $apiKey"

    val todoApi = RetrofitHelper.getInstance().create(TodoApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        supportActionBar?.hide()

        etUsername = findViewById(R.id.et_username)
        etDescription = findViewById(R.id.et_description)


        btn_back.setOnClickListener {
            val intent = Intent(this, start::class.java)
            startActivity(intent)
        }
        val sharedPreferences = getSharedPreferences(
            "app_preference", Context.MODE_PRIVATE
        )

        btn_submit.isEnabled = false
        etUsername.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int) {
                btn_submit.isEnabled = s.toString().trim{ it <= ' ' }.isNotEmpty()
            }
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int,
                                           after:Int) {
            }
            override fun afterTextChanged(s: Editable) {
            }
        })

        btn_submit.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                val ssid = sharedPreferences.getString("session_id", "[No session ID found]").toString()
                val data = TodoData(
                    username = etUsername.text.toString(),
                    description = etDescription.text.toString(),
                    session_id = ssid
                )
                val response = todoApi.create(token = token, apiKey = apiKey, todoData = data)

                Toast.makeText(
                    applicationContext,
                    "Posted!",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
            btn_submit.isEnabled = false
            btn_submit.isClickable = false
        }

    }
}
