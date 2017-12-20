package br.com.disapps.homepet.di

import br.com.disapps.homepet.ui.comments.CommentsPresenter
import br.com.disapps.homepet.ui.details.HotelDetailsPresenter
import br.com.disapps.homepet.ui.hotel.HotelPresenter
import br.com.disapps.homepet.ui.hotels.HotelsPresenter
import br.com.disapps.homepet.ui.includeComment.IncludeCommentPresenter
import br.com.disapps.homepet.ui.login.LoginPresenter
import br.com.disapps.homepet.ui.map.MapPresenter
import br.com.disapps.homepet.ui.profile.ProfilePresenter
import br.com.disapps.homepet.ui.profile.edit.EditProfilePresenter
import br.com.disapps.homepet.ui.signup.SignupPresenter
import org.koin.android.module.AndroidModule

/**
 * Created by diefferson on 19/12/2017.
 */
class  PresenterModule : AndroidModule(){

    override fun context() = applicationContext{
        provide { CommentsPresenter(get()) }
        provide { HotelDetailsPresenter(get(), get(), get()) }
        provide { HotelPresenter(get()) }
        provide { HotelsPresenter(get()) }
        provide { IncludeCommentPresenter(get(), get()) }
        provide { LoginPresenter(get(), get()) }
        provide { ProfilePresenter(get()) }
        provide { MapPresenter(get()) }
        provide { EditProfilePresenter(get(), get()) }
        provide { SignupPresenter(get(), get()) }

    }

}