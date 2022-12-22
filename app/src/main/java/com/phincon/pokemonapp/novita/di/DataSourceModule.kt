package com.phincon.pokemonapp.novita.di

import com.phincon.pokemonapp.novita.data.home.data_source.remote.HomeRemoteDataSource
import com.phincon.pokemonapp.novita.data.home.data_source.remote.HomeRemoteDataSourceImpl
import com.phincon.pokemonapp.novita.data.home.data_source.remote.service.HomeService
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
}
