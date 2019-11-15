package com.example.footballapps.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.footballapps.db.entity.AllSportsLocal

@Dao
interface AllSportsDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insetInAllSports (sports: List<AllSportsLocal>)

    @Query("SELECT * from all_sports")
    suspend fun fetchAllLeague(): List<AllSportsLocal>

}