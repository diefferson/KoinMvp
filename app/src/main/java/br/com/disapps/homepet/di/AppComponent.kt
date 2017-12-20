package br.com.disapps.homepet.di

/**
 * Created by diefferson on 19/12/2017.
 */
object AppComponent{
    fun modules() = listOf(
            AppModule.module,
            PresenterModule.module
    )
}