package com.phincon.pokemonapp.novita.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phincon.pokemonapp.novita.domain.model.SpecificPokemon
import com.phincon.pokemonapp.novita.domain.use_case.GetCompletePokemonDataUseCase
import com.phincon.pokemonapp.novita.domain.use_case.GetPokemonListUseCase
import com.phincon.pokemonapp.novita.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    private val getPokemonCompletePokemonDataUseCase: GetCompletePokemonDataUseCase
) : ViewModel() {
    private val _pokemonListState: MutableStateFlow<Resource<List<SpecificPokemon>>> =
        MutableStateFlow(Resource.Init())
    val pokemonListState: MutableStateFlow<Resource<List<SpecificPokemon>>>
        get() = _pokemonListState

    init {
        initLoading()
        getPokemonList()
    }

    private fun initLoading() {
        _pokemonListState.value = Resource.Loading()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            getPokemonListUseCase.invoke().flatMapLatest { pokemonListRes ->
                when {
                    pokemonListRes.isSuccess -> {
                        getPokemonCompletePokemonDataUseCase.invoke(
                            pokemonListRes.getOrNull().orEmpty()
                        )
                    }
                    else -> {
                        getPokemonCompletePokemonDataUseCase.invoke(emptyList())
                    }
                }
            }.collectLatest { res ->
                when {
                    res.isSuccess -> {
                        _pokemonListState.value = Resource.Success(res.getOrNull())
                    }
                    res.isFailure -> {
                        _pokemonListState.value = Resource.Error(
                            res.exceptionOrNull().toString(),
                            _pokemonListState.value.data
                        )
                    }
                    else -> {}
                }
            }
        }
    }
}
