package com.boltuix.mvvm.utils

/*
sealed class DataHandler<T>(
    val data: T? = null,
    val message: String? = null
) {
    class SUCCESS<T>(data: T) : DataHandler<T>(data)
    class ERROR<T>(data: T? = null, message: String) : DataHandler<T>(data, message)
    class LOADING<T> : DataHandler<T>()

}
*/

/*
sealed class DataHandler<T>(
    val data: T? = null,
    val message: String? = null
) {
    // We'll wrap our data in this 'Success'
    // class in case of success response from api
    class Success<T>(data: T) : DataHandler<T>(data = data)

    // We'll pass error message wrapped in this 'Error'
    // class to the UI in case of failure response
    class Error<T>(errorMessage: String) : DataHandler<T>(message = errorMessage)

    // We'll just pass object of this Loading
    // class, just before making an api call
    class Loading<T> : DataHandler<T>()
}*/

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {

    // We'll wrap our data in this 'Success'
    // class in case of success response from api
    class Success<T>(data: T) : Resource<T>(data = data)

    // We'll pass error message wrapped in this 'Error'
    // class to the UI in case of failure response
    class Error<T>(errorMessage: String) : Resource<T>(message = errorMessage)

    // We'll just pass object of this Loading
    // class, just before making an api call
    class Loading<T> : Resource<T>()
}