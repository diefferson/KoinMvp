package br.com.disapps.homepet.di

import android.app.Application
import br.com.disapps.homepet.app.HomePet
import br.com.disapps.homepet.data.cache.HotelRepository
import br.com.disapps.homepet.data.prefs.Preferences
import br.com.disapps.homepet.data.ws.RestApi
import br.com.disapps.homepet.data.ws.RestClient
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

/**
 * Created by diefferson on 19/12/2017.
 */
object  AppModule{

    val module: Module = applicationContext{
        provide { provideApp() }
        provide { provideRestApi(get()) }
        provide { providePreferences(get()) }
        provide { provideHotelRepository(get(), get(), get())}
    }

    private fun provideApp(): HomePet = HomePet.instance!!

    private fun provideRestApi(preferences: Preferences) = RestClient(preferences).api

    private fun providePreferences(app: Application) =  Preferences(app)

    private fun provideHotelRepository(app: Application,preferences: Preferences, restApi: RestApi) : HotelRepository =
            HotelRepository( preferences , app.cacheDir, restApi)
}