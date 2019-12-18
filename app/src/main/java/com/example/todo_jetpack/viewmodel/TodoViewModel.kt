package com.example.todo_jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.todo_jetpack.models.Todo
import com.example.todo_jetpack.repo.Repository
import com.example.todo_jetpack.repo.TodoDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {
    val db: TodoDB?
    init {
        db=Repository.db
    }

    fun getTodos(): LiveData<List<Todo>>? {
        return db?.todoDao()?.getAll()
    }

    fun updateData(todo: Todo) {
        GlobalScope.launch(Dispatchers.IO) {
            db?.todoDao()?.update(todo)
        }

    }

    fun addTodo(todo: Todo) {
        GlobalScope.launch(Dispatchers.IO) {
            db?.todoDao()?.insert(todo)
        }
    }

    fun deleteTodo(todo: Todo) {
        GlobalScope.launch(Dispatchers.IO) {
            db?.todoDao()?.delete(todo)
        }
    }


}