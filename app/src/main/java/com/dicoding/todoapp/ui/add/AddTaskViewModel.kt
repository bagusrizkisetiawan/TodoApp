package com.dicoding.todoapp.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.todoapp.data.Task
import com.dicoding.todoapp.data.TaskRepository
import kotlinx.coroutines.launch

class AddTaskViewModel(private val taskRepository: TaskRepository): ViewModel() {
    //  Function to add tasks to the repository using coroutines.
    //  Use viewModelScope to ensure coroutines are related to the ViewModel lifecycle.
    fun addTask(task: Task) = viewModelScope.launch {
        taskRepository.insertTask(task)
    }
}