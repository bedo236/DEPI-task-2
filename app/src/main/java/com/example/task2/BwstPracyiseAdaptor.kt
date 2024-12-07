package com.example.task2


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.task2.databinding.RvMovieItemBinding


class BwstPracyiseAdaptor: RecyclerView.Adapter<BwstPracyiseAdaptor.ViewHolder>() {


    private var itemsList: List<Movie> = emptyList()
    var onItemClick: OnItemClick <String>? = null


    class ViewHolder(val binding: RvMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie){
            binding.movieTitle.text = movie.title
            binding.movieRating.text = movie.rating.toString()
            binding.movieDescription.text = movie.description
            binding.movieDate.text = "Published: ${movie.publishDate}"
            binding.movieImage.setImageResource(movie.imageResId)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            RvMovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = itemsList[position]


        holder.bind(movie)


//        holder.itemView.setOnClickListener {
//            onItemClick?.onItemClick(movie, position)  // Pass the movie and position to the onItemClick handler
//        }
    }



    override fun getItemCount(): Int = itemsList.size

    fun updateList(newList: List<Movie>){
        val diffUtilCallBack = MyDiffUtil(oldList = this.itemsList, newList = newList)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtilCallBack)
        this.itemsList = newList
        diffUtilResult.dispatchUpdatesTo(this)
    }
}
