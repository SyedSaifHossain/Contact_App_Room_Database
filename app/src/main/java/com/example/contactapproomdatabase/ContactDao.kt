package com.example.contactapproomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface ContactDao {
        @Query("SELECT * FROM Contact_table")
        fun getAll():List<Contact>

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insert(contact : Contact)
    }
