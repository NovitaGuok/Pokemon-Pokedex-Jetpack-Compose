package com.compose.pokemonapp.novita.di

import com.compose.pokemonapp.novita.domain.detail.repository.DetailRepository
import com.compose.pokemonapp.novita.domain.detail.use_case.CatchPokemonUseCase
import com.compose.pokemonapp.novita.domain.detail.use_case.GetSpecificPokemonUseCase
import com.compose.pokemonapp.novita.domain.home.repository.HomeRepository
import com.compose.pokemonapp.novita.domain.home.use_case.GetCompletePokemonDataUseCase
import com.compose.pokemonapp.novita.domain.home.use_case.GetPokemonListUseCase
import com.compose.pokemonapp.novita.domain.my_pokemon.repository.MyPokemonRepository
import com.compose.pokemonapp.novita.domain.my_pokemon.use_case.DeletePokemonUseCase
import com.compose.pokemonapp.novita.domain.my_pokemon.use_case.GetMyPokemonListUseCase
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

    @Provides
    @Singleton
    fun provideGetCompletePokemonDataUseCase(
        getSpecificPokemonUseCase: GetSpecificPokemonUseCase,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): GetCompletePokemonDataUseCase {
        return GetCompletePokemonDataUseCase(
            getSpecificPokemonUseCase,
            ioDispatcher
        )
    }

    @Provides
    @Singleton
    fun provideGetMyPokemonListUseCase(
        myPokemonRepository: MyPokemonRepository,
    ): GetMyPokemonListUseCase {
        return GetMyPokemonListUseCase(myPokemonRepository)
    }

    @Provides
    @Singleton
    fun provideCatchPokemonUseCase(detailRepository: DetailRepository): CatchPokemonUseCase {
        return CatchPokemonUseCase(detailRepository)
    }

    @Provides
    @Singleton
    fun provideDeletePokemonUseCase(
        myPokemonRepository: MyPokemonRepository
    ): DeletePokemonUseCase {
        return DeletePokemonUseCase(myPokemonRepository)
    }
}
