package be.flatmap.pokdex.features.list

import be.flatmap.pokdex.model.api.PokemonApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PokemonListPresenter @Inject constructor(
        override val view: PokemonListContract.View,
        private val pokemonApi: PokemonApi
) : PokemonListContract.Presenter {

    override fun init() {
        pokemonApi
                .getAllPokemons()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onError = Throwable::printStackTrace,
                        onSuccess = {
                            view.showPokemons(it.results)
                            view.hideLoader()
                        }
                )
    }
}