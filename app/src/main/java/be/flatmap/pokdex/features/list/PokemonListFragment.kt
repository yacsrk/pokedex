package be.flatmap.pokdex.features.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import be.flatmap.pokdex.PokemonApplication
import be.flatmap.pokdex.R
import be.flatmap.pokdex.model.PokemonInfo
import kotlinx.android.synthetic.main.fragment_pokemon_list.*
import javax.inject.Inject

class PokemonListFragment : Fragment(), PokemonListContract.View {

    @Inject
    lateinit var presenter: PokemonListContract.Presenter

    private val pokemonsAdapter = PokemonAdapter()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonNamesRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = pokemonsAdapter
            setHasFixedSize(true)
        }
        PokemonApplication.component.plus(PokemonListModule(this)).inject(this)
        presenter.init()
    }

    override fun showPokemons(pokemons: List<PokemonInfo>) {
        pokemonNamesRecyclerView.visibility = View.VISIBLE
        pokemonsAdapter.pokemons = pokemons
    }

    override fun hideLoader() {
        progressBar.visibility = View.GONE
    }

    override fun showLoader() {
        progressBar.visibility = View.VISIBLE
    }
}