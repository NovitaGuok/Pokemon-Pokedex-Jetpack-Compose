package com.phincon.pokemonapp.novita.di

import com.phincon.pokemonapp.novita.domain.repository.HomeRepository
import com.phincon.pokemonapp.novita.domain.use_case.GetPokemonListUseCase
import com.phincon.pokemonapp.novita.domain.use_case.GetSpecificPokemonUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetPokemonListUseCase(
        homeRepository: HomeRepository,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): GetPokemonListUseCase {
        return GetPokemonListUseCase(homeRepository, ioDispatcher)
    }

    @Provides
    @Singleton
    fun provideGetSpecificPokemonUseCase(
        homeRepository: HomeRepository,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): GetSpecificPokemonUseCase {
        return GetSpecificPokemonUseCase(homeRepository, ioDispatcher)
    }
}
