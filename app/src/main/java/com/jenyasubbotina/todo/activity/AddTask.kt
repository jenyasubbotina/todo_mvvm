package com.jenyasubbotina.todo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jenyasubbotina.todo.db.AppExecutors
import com.jenyasubbotina.todo.model.Task
import com.jenyasubbotina.todo.db.TodoDatabase
import com.jenyasubbotina.todo.databinding.ActivityAddTaskBinding
import com.jenyasubbotina.todo.viewmodel.AddTaskViewModel
import java.util.*

class AddTask : AppCompatActivity() {
    private val DEFAULT_TASK_ID = -1
    private val mTaskId = DEFAULT_TASK_ID
    private lateinit var mDb: TodoDatabase
    private lateinit var viewModel: AddTaskViewModel
    private lateinit var binding: ActivityAddTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.save.setOnClickListener { onSaveButtonClicked() }
        mDb = TodoDatabase.getInstance(this)
    }

    private fun onSaveButtonClicked() {
        val description: String = binding.taskDescription.text.toString()
        val date = Date()
        val task = Task(description, "Personal", date)
        AppExecutors.getInstance().diskIO()
            .execute {
                if (mTaskId === DEFAULT_TASK_ID) {
                    mDb.taskDao().insertTask(task)
                } else {
                    task.id = mTaskId.toLong()
                    viewModel.updateTask(task)
                }
                finish()
            }
    }
}