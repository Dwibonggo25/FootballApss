package com.example.footballapps.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footballapps.db.entity.Favorites
import io.reactivex.Observable

@Dao
interface FavoritesDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInfavorites (data: Favorites)

    @Query ("SELECT * FROM favorites")
    suspend fun selectAllFavorites (): LiveData <List<Favorites>>
}