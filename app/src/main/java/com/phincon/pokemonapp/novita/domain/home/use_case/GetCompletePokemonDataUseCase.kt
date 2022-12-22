package com.phincon.pokemonapp.novita.domain.home.use_case

import com.phincon.pokemonapp.novita.di.IoDispatcher
import com.phincon.pokemonapp.novita.domain.detail.use_case.GetSpecificPokemonUseCase
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCompletePokemonDataUseCase @Inject constructor(
    private val getSpecificPokemonUseCase: GetSpecificPokemonUseCase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(pokemonList: List<com.phincon.pokemonapp.novita.domain.common.model.Pokemon>): Flow<Result<List<com.phincon.pokemonapp.novita.domain.common.model.SpecificPokemon>>> {
        return flow<Result<List<com.phincon.pokemonapp.novita.domain.common.model.SpecificPokemon>>> {
            val completePokemonDataList = mutableListOf<com.phincon.pokemonapp.novita.domain.common.model.SpecificPokemon>()

            pokemonList.onEach { pokemon ->
                getSpecificPokemonUseCase.invoke(pokemon.name).collectLatest {
                    when {
                        it.isSuccess -> {
                            completePokemonDataList.add(it.getOrNull() ?: com.phincon.pokemonapp.novita.domain.common.model.SpecificPokemon())
                        }
                        it.isFailure -> {
                            completePokemonDataList.addAll(emptyList())
                        }
                    }
                }
            }
            emit(Result.success(completePokemonDataList))
        }.catch { e ->
            emit(Result.failure(e))
        }.flowOn(ioDispatcher)
    }
}
