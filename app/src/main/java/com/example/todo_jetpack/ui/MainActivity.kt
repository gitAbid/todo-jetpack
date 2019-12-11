package com.example.todo_jetpack.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_jetpack.R
import com.example.todo_jetpack.adapter.TodoAdapter
import com.example.todo_jetpack.listener.ItemClickListener
import com.example.todo_jetpack.models.Todo
import com.example.todo_jetpack.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ItemClickListener {
    lateinit var viewModel: TodoViewModel

    override fun onClick(index: Int, todo: Todo) {
        viewModel.updateData(index, todo)
    }

    lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(TodoViewModel::class.java)
        todoAdapter = TodoAdapter(listOf(), this)
        rcvTodoList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = todoAdapter
        }
        viewModel.getTodos().observe(this, Observer {
            todoAdapter.updateDate(it)
        })


    }
}
