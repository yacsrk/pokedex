package be.flatmap.pokdex

import android.app.Application
import be.flatmap.pokdex.di.ApplicationComponent
import be.flatmap.pokdex.di.ApplicationModule
import be.flatmap.pokdex.di.DaggerApplicationComponent

class PokemonApplication : Application() {
    companion object {
        lateinit var component: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

}