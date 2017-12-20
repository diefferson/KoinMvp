package br.com.disapps.homepet.di

import android.app.Application
import br.com.disapps.homepet.app.HomePet
import br.com.disapps.homepet.data.cache.HotelRepository
import br.com.disapps.homepet.data.prefs.Preferences
import br.com.disapps.homepet.data.ws.RestApi
import br.com.disapps.homepet.data.ws.RestClient
import org.koin.android.module.AndroidModule

/**
 * Created by diefferson on 19/12/2017.
 */
class  AppModule : AndroidModule(){

    override fun context() = applicationContext{
        provide { provideApp() }
        provide { provideRestApi(get()) }
        provide { providePreferences(get()) }
        provide { provideHotelRepository(get(), get(), get())}
    }

    fun provideApp(): HomePet = HomePet.instance!!

    fun provideRestApi(preferences: Preferences) = RestClient(preferences).api

    fun providePreferences(app: Application) =  Preferences(app)

    fun provideHotelRepository(app: Application,preferences: Preferences, restApi: RestApi) : HotelRepository =
            HotelRepository( preferences , app.cacheDir, restApi)

}