package com.efe.watchlist.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.efe.watchlist.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private val lock = Any()
        private const val DB_NAME = "MovieDatabase"
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(application: Application): MovieDatabase {
            synchronized(MovieDatabase.lock) {
                if(MovieDatabase.INSTANCE == null) {
                    MovieDatabase.INSTANCE =
                        Room.databaseBuilder(application, MovieDatabase::class.java, DB_NAME)
                            .build()
                }
            }
            return INSTANCE!!
        }


    }


}