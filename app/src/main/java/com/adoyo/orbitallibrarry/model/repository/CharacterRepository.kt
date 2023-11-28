package com.adoyo.orbitallibrarry.model.repository

import com.adoyo.orbitallibrarry.model.Character
import com.adoyo.orbitallibrarry.util.Resource
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharacters(): Flow<Resource<List<Character>>>
}