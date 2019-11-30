package com.example.footballapps.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footballapps.db.entity.AllSportsLocal
import com.example.footballapps.db.entity.PreviousMatchLocal

@Dao
interface PreviousMatchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserPreviousMatch(sports: List<PreviousMatchLocal>)

    @Query ("SELECT * FROM previous_match")
    fun selectAllPreviousMatch() : LiveData<List<PreviousMatchLocal>>
}