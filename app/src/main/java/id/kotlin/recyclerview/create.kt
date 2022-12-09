package id.kotlin.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create.*
import kotlinx.android.synthetic.main.activity_start.*

class create : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        supportActionBar?.hide()

        btn_back.setOnClickListener {
            val intent = Intent(this, start::class.java)
            startActivity(intent)
        }
    }
}