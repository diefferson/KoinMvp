package br.com.disapps.homepet.di

import org.koin.android.module.AndroidModule

/**
 * Created by diefferson on 19/12/2017.
 */
object AppComponent{
    fun modules() : List<AndroidModule> {
        return  listOf(AppModule(), PresenterModule())
    }
}