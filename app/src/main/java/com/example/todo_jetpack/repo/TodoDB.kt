package com.example.todo_jetpack.repo

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo_jetpack.models.Todo

@Database(entities = arrayOf(Todo::class), version = 1)
abstract class TodoDB : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}