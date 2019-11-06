package com.github.ebnhzr.movietrackr.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "movie_rating_table")
data class Movie (
    @PrimaryKey (autoGenerate = true)
    var movieId: Long = 0L,

    @ColumnInfo (name = "movie_name")
    var movieName: String = "",

    @ColumnInfo (name = "rating_info")
    var rating: Int = -1
)