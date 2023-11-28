package com.adoyo.orbitallibrarry.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characterentity")
data class CharacterEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val  imageUrl: String?
)