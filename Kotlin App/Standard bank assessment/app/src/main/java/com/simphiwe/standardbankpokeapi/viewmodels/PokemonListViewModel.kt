package dev.ronnie.standardbankpokeapi.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.ronnie.standardbankpokeapi.data.repositories.DataStoreRepository
import dev.ronnie.standardbankpokeapi.data.repositories.PokemonRepository
import dev.ronnie.standardbankpokeapi.model.PokemonResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    dataStoreRepository: DataStoreRepository
) :
    ViewModel() {

    val isDialogShown = dataStoreRepository.isDialogShownFlow

    private var currentResult: Flow<PagingData<PokemonResult>>? = null
    fun getPokemons(searchString: String?): Flow<PagingData<PokemonResult>> {
        val newResult: Flow<PagingData<PokemonResult>> =
            pokemonRepository.getPokemon(searchString).cachedIn(viewModelScope)
        currentResult = newResult
        return newResult
    }
}