package be.flatmap.pokdex.features.list

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [PokemonListModule.BindingModule::class])
class PokemonListModule(
        private val pokemonListView: PokemonListContract.View
) {

    @Provides
    fun providePokemonListView(): PokemonListContract.View {
        return pokemonListView
    }

    @Module
    abstract inner class BindingModule {
        @Binds
        abstract fun bindListPresenter(presenter: PokemonListPresenter): PokemonListContract.Presenter
    }

}