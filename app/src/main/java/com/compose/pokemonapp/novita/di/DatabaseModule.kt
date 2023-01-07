package com.compose.pokemonapp.novita.di

import android.app.Application
import androidx.room.Room
import com.compose.pokemonapp.novita.data.detail.data_source.local.dao.DetailDao
import com.compose.pokemonapp.novita.data.my_pokemon.data_source.local.dao.MyPokemonDao
import com.compose.pokemonapp.novita.db.AppDb
import com.compose.pokemonapp.novita.util.Constant.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDb(app: Application): AppDb {
        return Room.databaseBuilder(app, AppDb::class.java, DB_NAME)
            .fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }

    @Provides
    fun provideDetailDao(appDatabase: AppDb): DetailDao {
        return appDatabase.detailDao()
    }

    @Provides
    fun provideMyPokemonDao(appDatabase: AppDb): MyPokemonDao {
        return appDatabase.myPokemonDao()
    }
}
