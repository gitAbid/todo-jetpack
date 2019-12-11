package com.example.todo_jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo_jetpack.models.Todo

class TodoViewModel : ViewModel() {
    private var todos: MutableLiveData<List<Todo>>

    init {
        todos = loadTodos()
    }

    private fun loadTodos(): MutableLiveData<List<Todo>> {

        return MutableLiveData(
            listOf(
                Todo("Loremm Ipsum 1"),
                Todo("Loremm Ipsum 2"),
                Todo("Loremm Ipsum 3"),
                Todo("Loremm Ipsum 4")
            )
        )
    }

    fun getTodos(): LiveData<List<Todo>> {
        return todos
    }

    fun updateData(index: Int, updates: Todo) {
        todos.value?.get(index)?.done = updates.done
        todos.value?.get(index)?.text = updates.text
    }


}