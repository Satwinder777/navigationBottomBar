package com.pbs.testnavgraph

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


//class MusicAdapter(private val musicArrayList: ArrayList<MusicData>,var context: Context):RecyclerView.Adapter<MusicAdapter.InnerClass>() {
class MusicAdapter(private val musicArrayList: ArrayList<MusicData>, var context: Context?):RecyclerView.Adapter<MusicAdapter.InnerClass>() {


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


//        var mediaPlayer: MediaPlayer? = null
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

       var  mediaPlayer = MediaPlayer.create(context,songs[currentSong])


        holder.playBtn.setOnClickListener{
            if (!mediaPlayer.isPlaying){
                holder.playBtn.setImageResource(R.drawable.paus_circle_24)
                mediaPlayer.start()
            }
            else{
                mediaPlayer.pause()
                holder.playBtn.setImageResource(R.drawable.play_circle_24)
            }

        }

        holder.nextBtn.setOnClickListener{
            if (mediaPlayer.isPlaying){
                holder.playBtn.setImageResource(R.drawable.paus_circle_24)
                mediaPlayer.pause()

                currentSong = currentSong+1
                Log.e("currentSong", "currentSong: "+currentSong )
            }
            else{

                currentSong = currentSong+1
                Log.e("currentSong", "currentSong:++ "+currentSong )
            }
            mediaPlayer = MediaPlayer.create(holder.songName.context,songs[currentSong])
            mediaPlayer.start()





        }
        holder.previousbtn.setOnClickListener{
            if (mediaPlayer.isPlaying){
                holder.playBtn.setImageResource(R.drawable.paus_circle_24)
                mediaPlayer.pause()
              if (currentSong<=songs.size){
                  currentSong = currentSong-1
              }
                else{
                  currentSong = 0
              }

//                Log.e("currentSong", "currentSong: "+currentSong )
            }

            mediaPlayer = MediaPlayer.create(holder.songName.context,songs[currentSong])
            mediaPlayer.start()





        }

    }
    class InnerClass(view: View):RecyclerView.ViewHolder(view){
        val songName = view.findViewById<TextView>(R.id.textView)
        val artistName = view.findViewById<TextView>(R.id.textView2)

        val img = view.findViewById<ImageView>(R.id.imageView)

        val previousbtn = view.findViewById<ImageView>(R.id.imageView2)
        val playBtn = view.findViewById<ImageView>(R.id.imageView3)
        val nextBtn = view.findViewById<ImageView>(R.id.imageView4)
    }
}


