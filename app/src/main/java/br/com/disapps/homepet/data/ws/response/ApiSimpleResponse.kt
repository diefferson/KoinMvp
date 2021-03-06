package br.com.disapps.homepet.data.ws.response

import br.com.disapps.homepet.data.model.*

/**
 * Created by diefferson.santos on 31/08/17.
 */
abstract class ApiSimpleResponse<T>(
            var message: String = "",
            var count: Int = 0,
            var next: Int = 0,
            var previous: Int = 0,
            var content: T? = null
        ){

    class AuthResponse: ApiSimpleResponse<Auth>()
    class CoordinateResponse : ApiSimpleResponse<Coordinate>()
    class HotelResponse : ApiSimpleResponse<Hotel> ()
    class SignUpResponse : ApiSimpleResponse<String>()
    class UserResponse : ApiSimpleResponse<User>()

}

