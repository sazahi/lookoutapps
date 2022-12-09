package id.kotlin.recyclerview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_start.*
import kotlin.random.Random


class start : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        supportActionBar?.hide()



        btn_post.setOnClickListener {
            val intent = Intent(this, create::class.java)
            startActivity(intent)
        }



        btn_start.setOnClickListener {
//            val uniqueInt = Random.nextInt(9999999)

//            var id = uniqueInt.toString()

//            val sharedPreference = getSharedPreferences(
//                "app_preference", Context.MODE_PRIVATE
//            )
//            var editor = sharedPreference.edit()
//            editor.putString("name", id)
//            editor.commit()

            val intent = Intent(this, MainActivity::class.java)
//            intent.putExtra("result", id)
            startActivity(intent)
        }
    }
}