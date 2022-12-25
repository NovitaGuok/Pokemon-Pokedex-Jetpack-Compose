package com.phincon.pokemonapp.novita.presentation.detail.viewmodel

import androidx.lifecycle.ViewModel
import com.phincon.pokemonapp.novita.domain.common.model.SpecificPokemon
import com.phincon.pokemonapp.novita.domain.detail.use_case.GetSpecificPokemonUseCase
import com.phincon.pokemonapp.novita.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getSpecificPokemonUseCase: GetSpecificPokemonUseCase
) : ViewModel() {
    private val _pokemonState: MutableStateFlow<Resource<SpecificPokemon>> =
        MutableStateFlow(Resource.Init())
    val pokemonState: MutableStateFlow<Resource<SpecificPokemon>> get() = _pokemonState

    init {
        initLoading()
    }

    private fun initLoading() {
        _pokemonState.value = Resource.Loading()
    }

    fun getPokemonByName(name: String) {
        runBlocking {
            getSpecificPokemonUseCase.invoke(name).cancellable().collectLatest { res ->
                when {
                    res.isSuccess -> {
                        _pokemonState.value = Resource.Success(res.getOrNull())
                    }
                    res.isFailure -> {
                        _pokemonState.value = Resource.Error(
                            res.exceptionOrNull().toString(),
                            _pokemonState.value.data
                        )
                    }
                }
            }
        }
    }
}
