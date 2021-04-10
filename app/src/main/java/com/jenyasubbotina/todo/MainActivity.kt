package com.jenyasubbotina.todo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jenyasubbotina.todo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val adapter: TaskAdapter = TaskAdapter(this, null)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tasks.layoutManager = LinearLayoutManager(this)
        binding.add.setOnClickListener { startActivity(Intent(this, AddTask::class.java))}
        setupViewModel()
        binding.tasks.adapter = adapter
    }

    private fun setupViewModel() {
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getTasks().observe(
            this,
            object : Observer<List<Task?>?> {
                override fun onChanged(taskEntries: List<Task?>?) {
                    adapter.setTodos(taskEntries)
                    adapter.notifyDataSetChanged()
                }
            })
    }
}
