package com.boltuix.mvvm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boltuix.mvvm.database.FavoriteMovieRepository
import com.boltuix.mvvm.di.NetworkRepository
import com.boltuix.mvvm.model.Article
import com.boltuix.mvvm.model.NewResponse
import com.boltuix.mvvm.utils.Constants.API_KEY
import com.boltuix.mvvm.utils.Constants.COUNTRY_CODE
/*import com.boltuix.mvvm.utils.DataHandler*/
import com.boltuix.mvvm.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
 class OnlineViewModel @Inject constructor(private val networkRepository: NetworkRepository,private val databaseRepository: FavoriteMovieRepository) : ViewModel() {

/*    private val _topHeadlines: MutableStateFlow<DataHandler<NewResponse>> = MutableStateFlow(DataHandler.Loading())
    val topHeadlines: StateFlow <DataHandler<NewResponse>> = _topHeadlines

    fun getTopHeadlines() {
        _topHeadlines.value = DataHandler.Loading()
        viewModelScope.launch {
            try{
                val response = networkRepository.getTopHeadlines(COUNTRY_CODE, API_KEY)
                if (response.isSuccessful) {
                    response.body()?.let {
                        // In case of success response we are returning Resource.Success object by passing our data in it.
                        _topHeadlines.value = DataHandler.Success(it)
                    }
                }
                else{
                    // Simply returning api's own failure message
                  _topHeadlines.value = DataHandler.Error(response.errorBody().toString())
                }
            }
            catch (e: HttpException) {
                // Returning HttpException's message
                // wrapped in Resource.Error
                _topHeadlines.value = DataHandler.Error(errorMessage = e.message ?: "Something went wrong")
            } catch (e: IOException) {
                // Returning no internet message
                // wrapped in Resource.Error
                _topHeadlines.value = DataHandler.Error(errorMessage = e.message ?: "Please check your network connection")
            }
            catch (e: Exception) {
                // Returning 'Something went wrong' in case
                // of unknown error wrapped in Resource.Error
                _topHeadlines.value = DataHandler.Error(errorMessage = e.message ?:  "Something went wrong")
            }
        }
    }*/


    private val _topHeadlines: MutableStateFlow<Resource<NewResponse>> = MutableStateFlow(Resource.Loading())
    val topHeadlines: StateFlow <Resource<NewResponse>> = _topHeadlines
    fun getTopHeadlines()= viewModelScope.launch {
        // Firstly we are posting Loading state in mutableLiveData
        _topHeadlines.value = Resource.Loading()
        // Posting success response as it becomes ready
        _topHeadlines.value = networkRepository.getTopHeadlines(COUNTRY_CODE, API_KEY)
    }


    //databaseRepository


    fun addToFavorite(movie: Article){
        CoroutineScope(Dispatchers.IO).launch {
            databaseRepository.addToFavorite(movie)
        }
    }



}