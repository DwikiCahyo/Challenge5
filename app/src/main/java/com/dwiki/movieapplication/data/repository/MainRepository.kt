package com.dwiki.movieapplication.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.dwiki.movieapplication.data.api.ApiService
import com.dwiki.movieapplication.data.responsemodel.ResponseTrendingMovieWeek
import com.dwiki.movieapplication.data.responsemodel.ResponseUpcomingMovie
import com.dwiki.movieapplication.util.Resources
import kotlinx.coroutines.delay
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService
) {

    fun trendingMovieWeek(token:String):LiveData<Resources<ResponseTrendingMovieWeek>> = liveData {
        emit(Resources.loading(null))
        delay(1000)
        try {
            val response = apiService.getTrendingMovieWeek(token)
            if (response.isSuccessful){
                emit(Resources.success(response.body()))
                Log.d(TAG,"succes trending movie week: ${response.message()}")
            } else {
                emit(Resources.error(response.errorBody()?.string(),null))
                Log.e(TAG,"error trending movie week : ${response.errorBody()?.string()}")
            }

        } catch (e:Exception){
            emit(Resources.error(e.message.toString(),null))
            Log.e(TAG,"error connect api : ${e.cause.toString()}")
        }
    }

    fun upcomingMovie(token: String):LiveData<Resources<ResponseUpcomingMovie>> = liveData {
        emit(Resources.loading(null))
        try {
            val response = apiService.getUpcomingMovie(token)
            if (response.isSuccessful){
                emit(Resources.success(response.body()))
                Log.d(TAG,"succes upcoming movie week: ${response.message()}")
            } else {
                emit(Resources.error(response.errorBody()?.string(),null))
                Log.e(TAG,"error upcoming movie week : ${response.errorBody()?.string()}")
            }
        } catch (e:Exception){
            emit(Resources.error(e.message.toString(),null))
            Log.e(TAG,"error connect api : ${e.cause.toString()}")
        }
    }



    companion object{
        private const val TAG = "MainRepository"
    }
}