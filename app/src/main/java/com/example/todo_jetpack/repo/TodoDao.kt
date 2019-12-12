package com.example.todo_jetpack.repo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todo_jetpack.models.Todo

@Dao
interface TodoDao {

    @Query("select * from Todo order by done DESC")
    fun todos(): LiveData<List<Todo>>

    @Insert
    fun insert(todo: Todo)

    @Update
    fun update(todo: Todo)

}