package com.phincon.pokemonapp.novita.di

import com.phincon.pokemonapp.novita.data.detail.data_source.local.DetailLocalDataSource
import com.phincon.pokemonapp.novita.data.detail.data_source.local.DetailLocalDataSourceImpl
import com.phincon.pokemonapp.novita.data.detail.data_source.local.dao.DetailDao
import com.phincon.pokemonapp.novita.data.home.data_source.remote.HomeRemoteDataSource
import com.phincon.pokemonapp.novita.data.home.data_source.remote.HomeRemoteDataSourceImpl
import com.phincon.pokemonapp.novita.data.home.data_source.remote.service.HomeService
import com.phincon.pokemonapp.novita.data.my_pokemon.data_source.local.MyPokemonLocalDataSource
import com.phincon.pokemonapp.novita.data.my_pokemon.data_source.local.MyPokemonLocalDataSourceImpl
import com.phincon.pokemonapp.novita.data.my_pokemon.data_source.local.dao.MyPokemonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    @Provides
    @Singleton
    fun provideHomeRemoteDataSource(homeService: HomeService): HomeRemoteDataSource {
        return HomeRemoteDataSourceImpl(homeService)
    }

    @Provides
    @Singleton
    fun provideDetailLocalDataSource(detailDao: DetailDao): DetailLocalDataSource {
        return DetailLocalDataSourceImpl(detailDao)
    }

    @Provides
    @Singleton
    fun provideMyPokemonLocalDataSource(myPokemonDao: MyPokemonDao): MyPokemonLocalDataSource {
        return MyPokemonLocalDataSourceImpl(myPokemonDao)
    }
}
