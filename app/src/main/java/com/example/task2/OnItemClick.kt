package com.example.task2

interface OnItemClick <String> {
    fun onItemClick(item: String, position: Int)
}

interface OnMovieClick <Movie> {
    fun onItemClick(item: Movie, position: Int)
}