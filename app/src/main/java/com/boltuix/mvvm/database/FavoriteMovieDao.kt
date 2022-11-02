package com.boltuix.mvvm.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.boltuix.mvvm.model.Article
import com.boltuix.mvvm.model.NewResponse

@Dao
interface FavoriteMovieDao {
    @Insert
    suspend fun addToFavorite(favoriteMovie: Article)

  /*  @Query("SELECT * FROM favorite_movie")
    fun getFavoriteMovie(): LiveData<List<Result>>

    @Query("SELECT count(*) FROM favorite_movie")
    suspend fun findCount(): Int

    @Query("DELETE FROM favorite_movie WHERE favorite_movie.product_id = :id" )
    suspend fun removeFromFavorite(id: String) : Int

    @Query("UPDATE favorite_movie SET product_qty=:qty WHERE product_id = :id")
    suspend fun updateQty(qty: Int, id: String)*/

}