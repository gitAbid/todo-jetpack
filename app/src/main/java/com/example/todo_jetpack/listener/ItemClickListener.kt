package com.example.todo_jetpack.listener

import com.example.todo_jetpack.models.Todo

interface ItemClickListener {
    fun onClick(index: Int, todo: Todo)
}