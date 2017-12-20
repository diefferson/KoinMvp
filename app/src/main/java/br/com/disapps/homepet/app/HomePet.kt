package br.com.disapps.homepet.app

import android.app.Application
import br.com.disapps.homepet.di.AppComponent
import org.koin.android.ext.android.startKoin

/**
* Created by diefferson.santos on 23/08/17.
*/
class HomePet : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin(this, AppComponent.modules())
    }

    companion object {
        var instance: HomePet? = null
            private set
    }
}