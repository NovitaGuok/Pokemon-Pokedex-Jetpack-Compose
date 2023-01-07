package com.compose.pokemonapp.novita.domain.home.use_case

import com.compose.pokemonapp.novita.di.IoDispatcher
import com.compose.pokemonapp.novita.domain.common.model.Pokemon
import com.compose.pokemonapp.novita.domain.home.repository.HomeRepository
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetPokemonListUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(offset: Int): Flow<Result<List<Pokemon>>> {
        return flow {
            val data = homeRepository.getPokemonList(offset)
            emit(Result.success(data))
        }.catch { e ->
            emit(Result.failure(e))
        }.flowOn(ioDispatcher)
    }
}
