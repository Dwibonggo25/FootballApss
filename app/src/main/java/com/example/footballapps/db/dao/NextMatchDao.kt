package com.example.footballapps.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footballapps.db.entity.NextEvent

@Dao
interface NextMatchDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertAllNextMatch (data: List<NextEvent>)

    @Query("SELECT * From next_match")
    fun fetchAllMatch (): LiveData<List<NextEvent>>
}