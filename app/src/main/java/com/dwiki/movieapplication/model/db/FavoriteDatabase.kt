package com.dwiki.movieapplication.model.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [Favorite::class],
    version = 1
)
abstract class FavoriteDatabase:RoomDatabase() {
    abstract fun getFavoriteDao():FavoriteDAO
}