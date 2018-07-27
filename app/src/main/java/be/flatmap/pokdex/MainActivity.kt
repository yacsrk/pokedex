package be.flatmap.pokdex

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import be.flatmap.pokdex.features.list.PokemonListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, PokemonListFragment())
                    .commit()
        }
    }
}
