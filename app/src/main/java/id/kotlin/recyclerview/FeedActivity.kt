package id.kotlin.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.kotlin.recyclerview.Api.RetrofitHelper
import id.kotlin.recyclerview.Api.TodoApi
import kotlinx.android.synthetic.main.activity_feed.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FeedActivity : AppCompatActivity() {

    lateinit var recyclerview : RecyclerView
    lateinit var adapter : Adapter


    val apiKey = ""
    val token = "Bearer $apiKey"

    val Items = ArrayList<DataViewModel>()
    val todoApi = RetrofitHelper.getInstance().create(TodoApi::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_feed)
        supportActionBar?.hide()


        recyclerview = findViewById(R.id.RecyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        getItem()

        back.setOnClickListener {
            val intent = Intent(this, start::class.java)
            startActivity(intent)
        }



        btn_post.setOnClickListener {
            val intent = Intent(this, create::class.java)
            startActivity(intent)
        }

    }

    fun getItem() {
        CoroutineScope(Dispatchers.Main).launch {
            val response = todoApi.get(token = token, apiKey = apiKey)
            var Items = ArrayList<DataViewModel>()

            response.body()?.forEach {
                Items.add(
                    DataViewModel(
                        Id = it.id,
                        Username = it.username,
                        Description = it.description,
                        Created_at = it.created_at,
//                            Session_id = it.session_id,
                    )
                )
            }
            adapter = Adapter(Items)
            recyclerview.adapter = adapter
        }
    }
    override fun onResume() {
        super.onResume()
        getItem()
    }
}
