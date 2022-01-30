package com.example.interviewtask.presentation.view.screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.interviewtask.R
import com.example.interviewtask.data.model.MovieModel
import com.example.interviewtask.databinding.MovieDetailsBinding
import com.example.interviewtask.utils.Constant.MOVIE_MODEL

class MovieDetailActivity : AppCompatActivity() {

    var movieModel: MovieModel? = null
    lateinit var movieDetailsBinding: MovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieDetailsBinding = DataBindingUtil.setContentView(this, R.layout.movie_details)

        getIntentData()
        initView()
    }

    companion object {

        fun getCallingIntent(context: Context, movieModel: MovieModel): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(MOVIE_MODEL, movieModel)
            return intent
        }
    }

    fun getIntentData() {
        movieModel = intent?.getParcelableExtra<MovieModel>(MOVIE_MODEL)
    }

    fun initView() {
        if (movieModel != null) {
            movieDetailsBinding.movieModel = movieModel
        }
    }

}