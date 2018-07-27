package be.flatmap.pokdex.di

import be.flatmap.pokdex.features.list.PokemonListComponent
import be.flatmap.pokdex.features.list.PokemonListModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun plus(module: PokemonListModule): PokemonListComponent
}