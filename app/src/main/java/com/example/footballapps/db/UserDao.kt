package com.example.footballapps.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footballapps.model.AllSport

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserData (fund: User )

    @Query ("")
    fun fetchAllLeague () : LiveData<AllSport>
}