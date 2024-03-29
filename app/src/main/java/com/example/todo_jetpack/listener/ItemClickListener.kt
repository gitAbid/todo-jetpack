package com.example.todo_jetpack.listener

import com.example.todo_jetpack.models.Todo

interface ItemClickListener {
    fun onClick(todo: Todo)
    fun onDelete(todo: Todo)
}