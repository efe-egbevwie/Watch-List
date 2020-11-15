package com.efe.watchlist.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.efe.watchlist.model.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: Movie)

    @Query("select * from movie")
    fun getAll(): LiveData<List<Movie>>

    @Query("delete from movie where id = :id ")
    fun delete(id: Int)

    @Query("delete from movie where watched = :watched ")
    fun deleteMovies(watched: Boolean)

    @Update
    fun updateMovie(movie: Movie)
}