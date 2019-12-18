package com.example.todo_jetpack.ui

import android.content.res.Configuration
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_jetpack.R
import com.example.todo_jetpack.adapter.TodoAdapter
import com.example.todo_jetpack.listener.ItemClickListener
import com.example.todo_jetpack.models.Todo
import com.example.todo_jetpack.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ItemClickListener {
    lateinit var viewModel: TodoViewModel

    lateinit var todoAdapter: TodoAdapter
    override fun onClick(todo: Todo) {
        viewModel.updateData(todo)
    }

    override fun onDelete(todo: Todo) {
        viewModel.deleteTodo(todo)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(TodoViewModel::class.java)
        todoAdapter = TodoAdapter(listOf(), this)
        rcvTodoList.apply {
            setHasFixedSize(true)
            val orientation = resources.configuration.orientation
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            } else {
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
            adapter = todoAdapter
        }
        viewModel.getTodos()?.observe(this, Observer {
            runOnUiThread {
                todoAdapter.updateDate(it)
            }
        })

        etTodo.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                btnSave.isEnabled = text?.length != 0
            }

        })
        btnSave.isEnabled = false

        btnSave.setOnClickListener {
            val todo = Todo(text = etTodo.text.toString())
            viewModel.addTodo(todo)
            etTodo.text.clear()
        }


    }
}
