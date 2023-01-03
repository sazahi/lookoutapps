package id.kotlin.recyclerview


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import id.kotlin.recyclerview.Api.RetrofitHelper
import id.kotlin.recyclerview.Api.TodoApi
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class detail : AppCompatActivity() {

    val apiKey = ""
    val token = "Bearer $apiKey"

    val todoApi = RetrofitHelper.getInstance().create(TodoApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()


        val sharedPreferences = getSharedPreferences(
            "app_preference", Context.MODE_PRIVATE
        )
        val ssid = sharedPreferences.getString("session_id", "[No session ID found]").toString()

        var intent = intent
        val aUsername = intent.getStringExtra("iUsername")
        val aDescription = intent.getStringExtra("iDescription")
        val id = intent.getStringExtra("ID")
        val session_id = intent.getStringExtra("iSSID")

        username.text = aUsername
        description.text = aDescription

        fun deleteItem(id: String) {
            CoroutineScope(Dispatchers.Main).launch {
                todoApi.delete(token=token, apiKey=apiKey, idQuery=id)


            }
        }

        delete.setOnClickListener(){
                var queryId = "eq.$id"
                deleteItem(queryId)

                Toast.makeText(
                    applicationContext,
                    "Delete Post ",
                    Toast.LENGTH_SHORT
                ).show()

                val intent = Intent(this, FeedActivity::class.java)
                startActivity(intent)

        }

    }
}
