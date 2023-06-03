package com.example.laboratorio_05.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*data class MovieModel(
    val name: String,
    val category: String,
    val description: String,
    val qualification: String
)*/


@Entity(tableName = "movie_table")
data class MovieModel(
    @PrimaryKey(autoGenerate = true) val movieId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "qualification") val qualification: String
)

{
constructor(name: String, category: String, description: String, qualification: String) :
        this(0, name, category, description, qualification)
}