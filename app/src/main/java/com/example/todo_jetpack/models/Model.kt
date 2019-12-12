package com.example.todo_jetpack.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
open class Todo(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null, var text: String, var done: Boolean = false
)