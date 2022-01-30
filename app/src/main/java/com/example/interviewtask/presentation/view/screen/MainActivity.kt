package com.example.interviewtask.presentation.view.screen

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.interviewtask.R
import com.example.interviewtask.data.model.MovieModel
import com.example.interviewtask.databinding.ActivityMainBinding
import com.example.interviewtask.presentation.view.adapter.MovieAdapter
import com.example.interviewtask.presentation.view.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        observers()
        initView()
    }

    /*Initialize Movie List Adapter*/
    private fun initView() {

        movieAdapter = MovieAdapter(object : MovieAdapter.MovieClickListener {
            override fun onItemClicked(movieModel: MovieModel) {
                /*Navigate to Movie Detail Screen*/
                startActivity(
                    MovieDetailActivity.getCallingIntent(
                        this@MainActivity,
                        movieModel
                    )
                )
            }

        })
        activityMainBinding.formList.adapter = movieAdapter
    }

    /*Observe Movie List from ViewModel*/
    private fun observers() {

        mainViewModel.movieListLiveData.observe(this, {

            movieAdapter.submitList(it)

        })
    }
}