package com.example.interviewtask.presentation.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.interviewtask.data.model.MovieModel
import com.example.interviewtask.databinding.MovieItemBinding
import com.example.interviewtask.utils.Constant.IMAGE_BASE_URL
import com.squareup.picasso.Picasso

class MovieViewHolder(
    val movieItemBinding: MovieItemBinding,
    val movieSubmitListener: MovieAdapter.MovieClickListener
) : RecyclerView.ViewHolder(movieItemBinding.root) {

    fun bind(item: MovieModel?) {

        if (item != null) {
            movieItemBinding.movieModel = item

            movieItemBinding.root.setOnClickListener {
                movieSubmitListener.onItemClicked(item)
            }
        }

    }


}