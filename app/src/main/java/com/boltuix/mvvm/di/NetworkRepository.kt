package com.boltuix.mvvm.di

import com.boltuix.mvvm.api.ApiService
import com.boltuix.mvvm.model.NewResponse
import com.boltuix.mvvm.utils.Resource
import retrofit2.Response
import javax.inject.Inject

/*
class NetworkRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getTopHeadlines(country: String, apiKey: String): Response<NewResponse> {
        return apiService.getTopHeadlines(country, apiKey)
    }
}
*/

class NetworkRepository @Inject constructor(private val apiService: ApiService): BaseRepo() {
    suspend fun getTopHeadlines(country: String, apiKey: String): Resource<NewResponse> {
        return safeApiCall {
            apiService.getTopHeadlines(country, apiKey)
        }
    }
}