package com.shahbozbek.todoappui

import com.shahbozbek.todoappui.data.Todo
import com.shahbozbek.todoappui.data.TodoDAO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val todoDao: TodoDAO
) {
    fun getAll(): List<Todo> = todoDao.getAll()
    fun getById(id: Int) = todoDao.getById(id)
    suspend fun insert(todo: Todo) = todoDao.insert(todo)
    fun deleteById(id: Int) = todoDao.deleteById(id)
    suspend fun update(todo: Todo) = todoDao.update(todo)
    fun deleteAll() = todoDao.deleteAll()
}