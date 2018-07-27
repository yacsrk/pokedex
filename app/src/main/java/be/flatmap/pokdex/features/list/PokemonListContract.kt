package be.flatmap.pokdex.features.list

import be.flatmap.pokdex.model.PokemonInfo

interface PokemonListContract {

    interface Presenter {
        val view: View
        fun init()
    }

    interface View {
        fun showPokemons(pokemons: List<PokemonInfo>)
        fun hideLoader()
        fun showLoader()
    }

}