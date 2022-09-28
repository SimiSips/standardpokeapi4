package dev.ronnie.standardbankpokeapi.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.ronnie.standardbankpokeapi.data.repositories.PokemonRepository
import dev.ronnie.standardbankpokeapi.utils.NetworkResource
import dev.ronnie.standardbankpokeapi.utils.extractId
import kotlinx.coroutines.flow.flow
import javax.inject.Inject




@HiltViewModel
class PokemonStatsViewModel @Inject constructor(private val pokemonRepository: PokemonRepository) :
    ViewModel() {

    suspend fun getSinglePokemon(url: String) = flow {
        val id = url.extractId()
        emit(NetworkResource.Loading)
        emit(pokemonRepository.getSinglePokemon(id))
    }

}