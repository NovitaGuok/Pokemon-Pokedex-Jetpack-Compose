package com.phincon.pokemonapp.novita.di

import com.phincon.pokemonapp.novita.data.home.data_source.remote.HomeRemoteDataSource
import com.phincon.pokemonapp.novita.data.home.repository.HomeRepositoryImpl
import com.phincon.pokemonapp.novita.domain.home.repository.HomeRepository
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
}
