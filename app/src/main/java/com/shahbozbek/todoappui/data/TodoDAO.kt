package com.shahbozbek.todoappui.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDAO {
    @Query("SELECT * FROM todo_app")
    fun getAll(): List<Todo>

    @Query("SELECT * FROM todo_app WHERE id = :id")
    fun getById(id: Int): Todo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: Todo)

    @Query("DELETE FROM todo_app WHERE id = :id")
    fun deleteById(id: Int)

    @Update
    suspend fun update(todo: Todo)

    @Query("DELETE FROM todo_app")
    fun deleteAll()

}