package com.example.footballapps.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footballapps.db.entity.Leagues
import com.example.footballapps.db.relation.NextMatchAndLeagues

@Dao
interface LeaguesDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLeagues (list: List<Leagues>)

    @Query ("SELECT * from leagues")
    fun fetchnextMacthAndLeagues (): LiveData<List<NextMatchAndLeagues>>
}