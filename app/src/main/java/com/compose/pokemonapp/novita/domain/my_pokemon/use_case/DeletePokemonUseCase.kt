package com.compose.pokemonapp.novita.domain.my_pokemon.use_case

import com.compose.pokemonapp.novita.domain.my_pokemon.repository.MyPokemonRepository
import javax.inject.Inject

class DeletePokemonUseCase @Inject constructor(
    private val myPokemonRepository: MyPokemonRepository
) {
    operator fun invoke(name: String) {
        myPokemonRepository.deletePokemon(name)
    }
}
