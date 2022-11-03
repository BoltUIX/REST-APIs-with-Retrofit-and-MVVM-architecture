package com.boltuix.mvvm.database

import com.boltuix.mvvm.model.Article
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val articleDao: ArticleDao
){
    suspend fun addToFavorite(favoriteArticle: Article) = articleDao.addToArticle(favoriteArticle)
    fun getArticle() = articleDao.getArticle()

    suspend fun findCount() = articleDao.findCount()

    suspend fun updateQty(qty: Int, idMovie: String) = articleDao.updateQty(qty,idMovie)
    suspend fun removeFromFavorite(id: String) { articleDao.removeArticle(id) }
}