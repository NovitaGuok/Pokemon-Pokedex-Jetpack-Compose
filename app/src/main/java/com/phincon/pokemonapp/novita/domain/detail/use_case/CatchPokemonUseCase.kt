package com.phincon.pokemonapp.novita.domain.detail.use_case

import com.phincon.pokemonapp.novita.domain.common.model.MyPokemon
import com.phincon.pokemonapp.novita.domain.detail.repository.DetailRepository
import javax.inject.Inject

class CatchPokemonUseCase @Inject constructor(
    private val detailRepository: DetailRepository
) {
    operator fun invoke(pokemon: MyPokemon) {
        detailRepository.catchPokemon(pokemon)
    }

    fun updateOwnedValue(name: String) {
        detailRepository.updateOwnedValue(name)
    }

    fun isPokemonExist(name: String): Boolean {
        return detailRepository.isPokemonExist(name)
    }
}
