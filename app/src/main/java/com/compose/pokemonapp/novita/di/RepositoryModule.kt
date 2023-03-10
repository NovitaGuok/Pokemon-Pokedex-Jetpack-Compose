package com.compose.pokemonapp.novita.di

import com.compose.pokemonapp.novita.data.detail.data_source.local.DetailLocalDataSource
import com.compose.pokemonapp.novita.data.detail.repository.DetailRepositoryImpl
import com.compose.pokemonapp.novita.data.home.data_source.remote.HomeRemoteDataSource
import com.compose.pokemonapp.novita.data.home.repository.HomeRepositoryImpl
import com.compose.pokemonapp.novita.data.my_pokemon.data_source.local.MyPokemonLocalDataSource
import com.compose.pokemonapp.novita.data.my_pokemon.repository.MyPokemonRepositoryImpl
import com.compose.pokemonapp.novita.domain.detail.repository.DetailRepository
import com.compose.pokemonapp.novita.domain.home.repository.HomeRepository
import com.compose.pokemonapp.novita.domain.my_pokemon.repository.MyPokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideHomeRepository(homeRemoteDataSource: HomeRemoteDataSource): HomeRepository {
        return HomeRepositoryImpl(homeRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideDetailRepository(detailLocalDataSource: DetailLocalDataSource): DetailRepository {
        return DetailRepositoryImpl(detailLocalDataSource)
    }

    @Provides
    @Singleton
    fun provideMyPokemonRepository(
        myPokemonLocalDataSource: MyPokemonLocalDataSource
    ): MyPokemonRepository {
        return MyPokemonRepositoryImpl(myPokemonLocalDataSource)
    }
}
