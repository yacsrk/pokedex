package be.flatmap.pokdex.model

data class PokemonListResponse(
    val count: Int,
    val previous: String,
    val results: List<PokemonInfo>
)