package com.compose.pokemonapp.novita.domain.detail.use_case

import com.compose.pokemonapp.novita.di.IoDispatcher
import com.compose.pokemonapp.novita.domain.common.model.SpecificPokemon
import com.compose.pokemonapp.novita.domain.home.repository.HomeRepository
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetSpecificPokemonUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(name: String): Flow<Result<SpecificPokemon>> {
        return flow {
            val data = homeRepository.getSpecificPokemon(name)
            emit(Result.success(data))
        }.catch { e ->
            emit(Result.failure(e))
        }.flowOn(ioDispatcher)
    }
}
