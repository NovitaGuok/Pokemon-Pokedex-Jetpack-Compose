package com.compose.pokemonapp.novita.presentation.my_pokemon.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.pokemonapp.novita.domain.common.model.LazyGridData
import com.compose.pokemonapp.novita.domain.my_pokemon.use_case.DeletePokemonUseCase
import com.compose.pokemonapp.novita.domain.my_pokemon.use_case.GetMyPokemonListUseCase
import com.compose.pokemonapp.novita.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class MyPokemonViewModel @Inject constructor(
    private val getMyPokemonListUseCase: GetMyPokemonListUseCase,
    private val deletePokemonUseCase: DeletePokemonUseCase
) : ViewModel() {
    private val _myPokemonListState: MutableStateFlow<Resource<List<LazyGridData>>> =
        MutableStateFlow(Resource.Init())
    val myPokemonListState: MutableStateFlow<Resource<List<LazyGridData>>>
        get() = _myPokemonListState

    init {
        initLoading()
        getMyPokemonList()
    }

    private fun initLoading() {
        _myPokemonListState.value = Resource.Loading()
    }

    private fun getMyPokemonList() {
        viewModelScope.launch {
            getMyPokemonListUseCase.invoke().collectLatest {
                if (it.isEmpty()) {
                    _myPokemonListState.value = Resource.Empty()
                } else {
                    _myPokemonListState.value = Resource.Success(it as List<LazyGridData>)
                }
            }
        }
    }

    fun deletePokemon(name: String) {
        deletePokemonUseCase.invoke(name)
    }
}
