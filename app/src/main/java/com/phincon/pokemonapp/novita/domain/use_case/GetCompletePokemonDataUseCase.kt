package com.phincon.pokemonapp.novita.domain.use_case

import com.phincon.pokemonapp.novita.di.IoDispatcher
import com.phincon.pokemonapp.novita.domain.model.Pokemon
import com.phincon.pokemonapp.novita.domain.model.SpecificPokemon
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
    suspend operator fun invoke(pokemonList: List<Pokemon>): Flow<Result<List<SpecificPokemon>>> {
        return flow<Result<List<SpecificPokemon>>> {
            val completePokemonDataList = mutableListOf<SpecificPokemon>()

            pokemonList.onEach { pokemon ->
                getSpecificPokemonUseCase.invoke(pokemon.name).collectLatest {
                    when {
                        it.isSuccess -> {
                            completePokemonDataList.add(it.getOrNull() ?: SpecificPokemon())
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
