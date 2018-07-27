package be.flatmap.pokdex.features.list

import dagger.Subcomponent

@Subcomponent(modules = [PokemonListModule::class])
interface PokemonListComponent {
    fun inject(pokemonListFragment: PokemonListFragment)
}