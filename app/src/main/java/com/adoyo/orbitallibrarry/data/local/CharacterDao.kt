package com.adoyo.orbitallibrarry.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface CharacterDao {

    @Upsert
    fun upsertAll(character: List<CharacterEntity>)


    @Query("SELECT * FROM characterentity")
    fun pagingSource(): PagingSource<Int, CharacterEntity>

    @Query("Delete from characterentity")
    fun deleteAll()
}