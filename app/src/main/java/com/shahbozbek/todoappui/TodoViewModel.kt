package com.shahbozbek.todoappui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shahbozbek.todoappui.data.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    fun getAll(): List<Todo> = repository.getAll()
    fun getById(id: Int) = repository.getById(id)
    fun insert(todo: Todo) {
        viewModelScope.launch {
            repository.insert(todo)
        }
    }
    fun deleteById(id: Int) = repository.deleteById(id)
    fun update(todo: Todo) {
        viewModelScope.launch {
            repository.update(todo)
        }
    }
    fun deleteAll() = repository.deleteAll()

}