package com.pbs.testnavgraph

//class FruitAdapter {
//}
//package com.pbs.testnavgraph

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class VegAdapter(private val fruitArrayList: ArrayList<VegData>) :
    RecyclerView.Adapter<VegAdapter.InnerClass1>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            InnerClass1 {
        val itemView1 =
            LayoutInflater.from(parent.context).inflate(R.layout.fruit_view_item, parent, false)
        return InnerClass1(itemView1)
    }

    override fun getItemCount(): Int {
        return fruitArrayList.size
    }

    override fun onBindViewHolder(holder: InnerClass1, position: Int) {
        val currentItem = fruitArrayList[position]
        holder.vegName.text = currentItem.vegetableName.toString()
        holder.vegWeight.text = currentItem.weight.toString()
        holder.vegImg.setImageResource(currentItem.vegImgage)
        holder.perVegPrize.text = currentItem.totalcost.toString()




    }

    class InnerClass1(view: View) : RecyclerView.ViewHolder(view) {
        val vegName = view.findViewById<TextView>(R.id.textView5)
        val vegWeight = view.findViewById<TextView>(R.id.textView6)
        val incBtn = view.findViewById<Button>(R.id.button)
        val decBtn = view.findViewById<Button>(R.id.button2)
        val totalItem = view.findViewById<TextView>(R.id.textView8)
        val endBtn = view.findViewById<ImageView>(R.id.imageView7)
        val perVegPrize = view.findViewById<TextView>(R.id.textView7)
        val vegImg = view.findViewById<ImageView>(R.id.imageView6)
    }
}


