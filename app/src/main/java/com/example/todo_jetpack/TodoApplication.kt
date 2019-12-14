package com.example.todo_jetpack

import android.app.Application
import com.example.todo_jetpack.repo.Repository

class TodoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Repository.init(this)
    }
}