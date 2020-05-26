package com.texnopos.redbook.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.texnopos.redbook.data.model.Animal

@Dao
interface AnimalDao {
    @Query("SELECT * FROM book")
    fun getAllAnimals() : List<Animal>
}