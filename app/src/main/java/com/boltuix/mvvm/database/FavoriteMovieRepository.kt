package com.boltuix.mvvm.database

import com.boltuix.mvvm.database.FavoriteMovieDao
import com.boltuix.mvvm.model.Article
import com.boltuix.mvvm.model.NewResponse
import javax.inject.Inject

class FavoriteMovieRepository @Inject constructor(
    private val favoriteMovieDao: FavoriteMovieDao
){
    suspend fun addToFavorite(favoriteMovie: Article) = favoriteMovieDao.addToFavorite(favoriteMovie)
   /* fun getFavoriteMovies() = favoriteMovieDao.getFavoriteMovie()
   // suspend fun checkMovie(id: String) = favoriteMovieDao.checkMovie(id)
    suspend fun findCount() = favoriteMovieDao.findCount()
   // suspend fun findPrice() = favoriteMovieDao.findPrice()
    suspend fun updateQty(qty: Int, idMovie: String) = favoriteMovieDao.updateQty(qty,idMovie)
    suspend fun removeFromFavorite(id: String) { favoriteMovieDao.removeFromFavorite(id) }*/
}