package com.example.footballapps.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footballapps.db.entity.AllSportsLocal
import com.example.footballapps.model.AllSport

@Dao
interface AllSportsDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insetInAllSports (sports: List<AllSportsLocal>)

    @Query("SELECT * from all_sports")
    fun fetchAllLeague(): LiveData<AllSportsLocal>
}