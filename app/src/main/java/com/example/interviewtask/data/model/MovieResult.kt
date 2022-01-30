package com.example.interviewtask.data.model


data class MovieResult(
    val dates: Dates,
    val page: String,
    val results: List<MovieModel>,
    val total_pages: Int,
    val total_results: Int
)

data class Dates(val maximum: String, val minimum: String)