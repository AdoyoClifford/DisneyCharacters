package com.adoyo.orbitallibrarry.data.repository

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.adoyo.orbitallibrarry.data.local.CharacterDatabase
import com.adoyo.orbitallibrarry.data.local.CharacterEntity
import com.adoyo.orbitallibrarry.data.remote.CharacterApi
import com.adoyo.orbitallibrarry.data.remote.mappers.toCharacter
import com.adoyo.orbitallibrarry.data.remote.mappers.toCharacterEntity
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class CharacterMediator @Inject constructor(
    private val characterApi: CharacterApi,
    private val characterDb: CharacterDatabase
) : RemoteMediator<Int, CharacterEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CharacterEntity>
    ): MediatorResult {
        return try {

            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }
            val remoteCharacters = characterApi.getAllCharacters(
                pageCount = state.config.pageSize,
                page = loadKey,
//                pageCount = loadKey,
//                page = state.config.pageSize,
            )

            characterDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    characterDb.dao.deleteAll()
                }
                val characterEntities = remoteCharacters.data.map { it.toCharacterEntity() }
                characterDb.dao.upsertAll(characterEntities).also {
                    println("Kuna $it")
                }

            }



            MediatorResult.Success(
                endOfPaginationReached = remoteCharacters.data.isEmpty()
            )

        } catch (e: Exception) {
            println("Hello $e")
            MediatorResult.Error(e)
        }
    }

}