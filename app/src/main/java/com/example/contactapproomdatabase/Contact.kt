package com.example.contactapproomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact_table")

    data class Contact(
        @PrimaryKey(autoGenerate = true)
        val Id : Int?,
        @ColumnInfo(name = "name")
        val name : String,
        @ColumnInfo(name = "email")
        val email : String?,
        @ColumnInfo(name = "contact")
        val contact: Int?

    )