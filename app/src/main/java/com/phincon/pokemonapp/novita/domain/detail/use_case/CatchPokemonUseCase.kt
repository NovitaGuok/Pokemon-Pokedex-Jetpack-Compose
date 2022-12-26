package com.phincon.pokemonapp.novita.domain.detail.use_case

import com.phincon.pokemonapp.novita.domain.common.model.Pokemon
import com.phincon.pokemonapp.novita.domain.detail.repository.DetailRepository
import javax.inject.Inject

class CatchPokemonUseCase @Inject constructor(
    private val detailRepository: DetailRepository
) {
    operator fun invoke(pokemon: Pokemon) {
        detailRepository.catchPokemon(pokemon)
    }
}
