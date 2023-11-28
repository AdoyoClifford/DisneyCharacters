package com.adoyo.orbitallibrarry.data.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CharacterEntity::class], version = 2, autoMigrations = [AutoMigration(from = 1, to = 2)] )
abstract class CharacterDatabase: RoomDatabase() {
    abstract val dao: CharacterDao
}