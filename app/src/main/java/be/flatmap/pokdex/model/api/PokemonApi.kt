package be.flatmap.pokdex.model.api

import be.flatmap.pokdex.model.PokemonListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface PokemonApi {

    @GET("/api/v2/pokemon")
    fun getAllPokemons(): Single<PokemonListResponse>

    companion object {
        const val BASE_URL = "http://pokeapi.co"
    }

}