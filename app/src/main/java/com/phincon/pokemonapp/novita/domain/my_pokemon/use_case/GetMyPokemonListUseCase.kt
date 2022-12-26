package com.phincon.pokemonapp.novita.domain.my_pokemon.use_case

import com.phincon.pokemonapp.novita.domain.common.model.MyPokemon
import com.phincon.pokemonapp.novita.domain.my_pokemon.repository.MyPokemonRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetMyPokemonListUseCase @Inject constructor(
    private val myPokemonRepository: MyPokemonRepository
) {
    operator fun invoke(): Flow<List<MyPokemon>> {
        return myPokemonRepository.getMyPokemonList()
    }
}
