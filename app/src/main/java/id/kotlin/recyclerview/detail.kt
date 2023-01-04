package id.kotlin.recyclerview


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.example.sharedpref.api.RetrofitHelper
import com.example.sharedpref.api.TodoApi
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_feed.*
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



        delete.setOnClickListener(){
            if (ssid.equals(session_id)) {
                var query = "eq.$id"
                CoroutineScope(Dispatchers.Main).launch {
                    todoApi.delete(token = token , apiKey = apiKey , idQuery = query)
                    Toast.makeText(applicationContext, "Berhasil Menghapus Data", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, FeedActivity::class.java)
                    startActivity(intent)

                }

            }else {
                Toast.makeText(this, "Tidak Bisa Menghapus Postingan Orang Lain", Toast.LENGTH_SHORT).show()
            }

        }
            }
        }
