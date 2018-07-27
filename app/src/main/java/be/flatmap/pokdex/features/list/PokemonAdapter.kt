package be.flatmap.pokdex.features.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import be.flatmap.pokdex.R
import be.flatmap.pokdex.model.PokemonInfo

class PokemonAdapter : RecyclerView.Adapter<PokemonViewHolder>() {

    var pokemons = emptyList<PokemonInfo>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon_name, parent, false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount() = pokemons.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val upperString = pokemons[position].name.substring(0, 1).toUpperCase() + pokemons[position].name.substring(1)
        holder.nameTextView.text = upperString
    }
}