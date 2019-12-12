package com.example.todo_jetpack.repo

import android.content.Context
import androidx.room.Room

class Repository {

    companion object {
        var db: TodoDB? = null

        fun init(context: Context) {
            if (db == null) {
                db = Room.databaseBuilder(
                    context,
                    TodoDB::class.java, "todo.db"
                ).fallbackToDestructiveMigration()
                    .build()
            }

        }

    }

}