package com.adoyo.orbitallibrarry.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.adoyo.orbitallibrarry.data.local.CharacterDatabase
import com.adoyo.orbitallibrarry.data.local.CharacterEntity
import com.adoyo.orbitallibrarry.data.remote.CharacterApi
import com.adoyo.orbitallibrarry.data.repository.CharacterMediator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCharacterApi(): CharacterApi {
        return Retrofit.Builder().baseUrl(CharacterApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create()).build().create()
    }

    @Provides
    @Singleton
    fun provideCharacterDatabase(@ApplicationContext context: Context): CharacterDatabase {
        return Room.databaseBuilder(context, CharacterDatabase::class.java, "character_db")
            .addMigrations( )
            .build()
    }

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun providePager(
        characterDb: CharacterDatabase,
        characterApi: CharacterApi
    ): Pager<Int, CharacterEntity> {
        return Pager(
            config = PagingConfig(
                pageSize = 20
            ),
            remoteMediator = CharacterMediator(
                characterDb = characterDb,
                characterApi = characterApi
            ),
            pagingSourceFactory = {
                characterDb.dao.pagingSource()
            }
        )
    }
}