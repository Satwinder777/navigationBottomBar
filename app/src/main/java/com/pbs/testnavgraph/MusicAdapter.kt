package com.pbs.testnavgraph

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



//class MusicAdapter(private val musicArrayList: ArrayList<MusicData>,var context: Context):RecyclerView.Adapter<MusicAdapter.InnerClass>() {
class MusicAdapter(private val musicArrayList: ArrayList<MusicData>):RecyclerView.Adapter<MusicAdapter.InnerClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            InnerClass {
        var itemView1 = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,parent,false)
        return InnerClass(itemView1)
    }

    override fun getItemCount(): Int {
        return musicArrayList.size
    }

    override fun onBindViewHolder(holder: InnerClass, position: Int) {


        val currentItem = musicArrayList[position]
        holder.songName.text = currentItem.musicName.toString()
        holder.artistName.text = currentItem.artistName
        holder.img.setBackgroundResource(currentItem.img)


        var mediaPlayer: MediaPlayer? = null
        var songs = arrayOf(R.raw.levels,
            R.raw.two,
            R.raw.fuck_em_all,
            R.raw.levels,
            R.raw.two,
            R.raw.fuck_em_all,
            R.raw.levels,
            R.raw.two,
            R.raw.fuck_em_all,
            R.raw.levels,
            R.raw.two,
            R.raw.fuck_em_all

        )
        var currentSong = 0


        holder.btn2.setOnClickListener{


            var mediaPlayer = MediaPlayer.create(it.context, songs[1])

            mediaPlayer.start()


            holder.btn2.setImageResource(R.drawable.paus_circle_24)
//            if (mediaPlayer.isPlaying) {
//                mediaPlayer.pause()
//            } else {
//                mediaPlayer.start()
//            }





        }
        holder.btn3.setOnClickListener{


         currentSong++
             var mediaPlayer = MediaPlayer.create(it.context, songs[currentSong])

//            mediaPlayer.setDataSource(songs[currentSong])
            mediaPlayer.start()
        }
        holder.btn1.setOnClickListener{


            currentSong--
            var mediaPlayer = MediaPlayer.create(it.context, songs[currentSong])

//            mediaPlayer.setDataSource(songs[currentSong])
            mediaPlayer.start()
        }




    }
    class InnerClass(view: View):RecyclerView.ViewHolder(view){
        val songName = view.findViewById<TextView>(R.id.textView)
        val artistName = view.findViewById<TextView>(R.id.textView2)

        val img = view.findViewById<ImageView>(R.id.imageView)

        val btn1 = view.findViewById<ImageView>(R.id.imageView2)
        val btn2 = view.findViewById<ImageView>(R.id.imageView3)
        val btn3 = view.findViewById<ImageView>(R.id.imageView4)
    }
}


