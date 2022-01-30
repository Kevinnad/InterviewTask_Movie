package com.example.interviewtask.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.interviewtask.data.model.MovieModel
import com.example.interviewtask.databinding.MovieItemBinding

class MovieAdapter(val movieClickListener: MovieClickListener) : PagedListAdapter<MovieModel, MovieViewHolder>(MovieComperator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        return MovieViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),movieClickListener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    interface MovieClickListener{

       fun onItemClicked(movieModel: MovieModel)
    }

    object MovieComperator : DiffUtil.ItemCallback<MovieModel>() {
        override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel) =
            oldItem == newItem
    }
}