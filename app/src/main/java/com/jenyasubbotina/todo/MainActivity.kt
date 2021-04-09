package com.jenyasubbotina.todo

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jenyasubbotina.todo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TaskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getTasks()
            .observe(this, object : Observer<List<Task?>?> {
                override fun onChanged(@Nullable taskEntries: List<Task?>?) {
                    adapter.setTodos(taskEntries)
                    adapter.notifyDataSetChanged()
                }
            })
    }
}