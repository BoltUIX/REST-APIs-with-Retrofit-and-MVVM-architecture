package com.boltuix.mvvm.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.boltuix.mvvm.model.Article

@Dao
interface ArticleDao {
    @Insert
    suspend fun addToArticle(article: Article)

    @Query("SELECT * FROM favorite_article")
    fun getArticle(): LiveData<List<Article>>

    @Query("SELECT count(*) FROM favorite_article")
    suspend fun findCount(): Int

    @Query("DELETE FROM favorite_article WHERE favorite_article.id = :id" )
    suspend fun removeArticle(id: String) : Int

    @Query("UPDATE favorite_article SET title=:qty WHERE id = :id")
    suspend fun updateQty(qty: Int, id: String)


}