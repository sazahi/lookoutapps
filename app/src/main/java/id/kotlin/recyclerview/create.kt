package id.kotlin.recyclerview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Trace.isEnabled
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.sharedpref.api.RetrofitHelper
import com.example.sharedpref.api.TodoApi
import com.example.sharedpref.api.TodoData
import kotlinx.android.synthetic.main.activity_create.*
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class create : AppCompatActivity() {

    lateinit var etUsername: EditText
    lateinit var etDescription: EditText

    val apiKey = ""
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
        

        btn_submit.setOnClickListener {
            if (etUsername.text.toString().isNullOrEmpty() || etDescription.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "Isi Terlebih Dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                CoroutineScope(Dispatchers.Main).launch {
                    val ssid = sharedPreferences.getString("session_id", "[No session ID found]")
                        .toString()
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
                    btn_submit.isEnabled = false
                    btn_submit.isClickable = false
                }
            }


        }

    }
}
