package id.kotlin.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.kotlin.recyclerview.Api.RetrofitHelper
import id.kotlin.recyclerview.Api.TodoApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btn_back
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {


    lateinit var recyclerview : RecyclerView
    lateinit var Adapter : Adapter


//    private var layoutManager: RecyclerView.LayoutManager? = null
//    private var adapter: RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>? = null

    val apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Impsc3N2cmV0cGJ6c25uYmZwaWpkIiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzA1ODMwMDUsImV4cCI6MTk4NjE1OTAwNX0.XzG93lsdOa4ap-NMu1cgquhdmywh1924-WnuM9f3fXs"
    val token = "Bearer $apiKey"

    val Items = ArrayList<Model>()
    val todoApi = RetrofitHelper.getInstance().create(TodoApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        recyclerview = findViewById(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
//        layoutManager = LinearLayoutManager(this)
//        recyclerView.layoutManager = layoutManager

//        adapter = RecycleViewAdapter(this, R.layout.cardview, Items)
//        recyclerView.adapter = adapter



        CoroutineScope(Dispatchers.Main).launch {
            val response = todoApi.get(token=token, apiKey=apiKey)

            response.body()?.forEach {
                Items.add(
                    Model(
                        Id=it.id,
                        Username =it.username,
                        Description=it.description
                    )
                )
            }
        }

        Adapter = Adapter(Items)
        recyclerview.adapter = Adapter

        btn_back.setOnClickListener {
            val intent = Intent(this, start::class.java)
            startActivity(intent)
        }
    }
}