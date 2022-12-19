package com.phincon.pokemonapp.novita.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phincon.pokemonapp.novita.domain.model.Pokemon
import com.phincon.pokemonapp.novita.domain.use_case.GetPokemonListUseCase
import com.phincon.pokemonapp.novita.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(private val getPokemonListUseCase: GetPokemonListUseCase) :
    ViewModel() {
    private val _pokemonListState: MutableStateFlow<Resource<List<Pokemon>>> =
        MutableStateFlow(Resource.Init())
    val pokemonListState: MutableStateFlow<Resource<List<Pokemon>>> get() = _pokemonListState

    init {
        initLoading()
        getPokemonList()
    }

    private fun initLoading() {
        _pokemonListState.value = Resource.Loading()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            getPokemonListUseCase.invoke().collectLatest { res ->
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
                }
            }
        }
    }
}
