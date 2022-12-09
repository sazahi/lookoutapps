package id.kotlin.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val  itemlist : ArrayList<Model>)
    : RecyclerView.Adapter<Adapter.itemviewholder>(){

    class itemviewholder (view : View) : RecyclerView.ViewHolder(view){
        val textView1 : TextView = view.findViewById(R.id.item_title)
        val textView2 : TextView = view.findViewById(R.id.item_details)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemviewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_model, parent, false)
        return itemviewholder(view)
    }

    override fun onBindViewHolder(holder: itemviewholder, position: Int) {
        val item = itemlist[position]
        holder.textView1.text = item.Username
        holder.textView2.text = item.Description
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }
}


