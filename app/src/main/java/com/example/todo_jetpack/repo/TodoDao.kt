package com.example.todo_jetpack.repo

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todo_jetpack.models.Todo

@Dao
interface TodoDao {

    @Query("select * from Todo order by done")
    fun getAll(): LiveData<List<Todo>>

    @Query("select * from Todo where id=:id")
    fun getById(id: Int): LiveData<Todo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(todo: Todo)

    @Update
    fun update(todo: Todo)

    @Delete
    fun delete(todo: Todo)

}