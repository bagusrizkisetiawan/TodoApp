package com.dicoding.todoapp.ui.detail

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.ViewModelFactory
import com.dicoding.todoapp.utils.DateConverter
import com.dicoding.todoapp.utils.TASK_ID
import com.google.android.material.textfield.TextInputEditText

class DetailTaskActivity : AppCompatActivity() {

    private lateinit var title: TextInputEditText
    private lateinit var desc: TextInputEditText
    private lateinit var dueDate: TextInputEditText
    private lateinit var btnDelete: Button
    private lateinit var detailTaskViewModel: DetailTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        //TODO 11 : Show detail task and implement delete action

        //Assigning UI elements to variables by finding them using their respective IDs.
        title = findViewById(R.id.detail_ed_title)
        desc = findViewById(R.id.detail_ed_description)
        dueDate = findViewById(R.id.detail_ed_due_date)
        btnDelete = findViewById(R.id.btn_delete_task)

        // Initializing the ViewModel using a ViewModelProvider with a custom ViewModelFactory.
        detailTaskViewModel = ViewModelProvider(
            this,
            ViewModelFactory.getInstance(this)
        )[DetailTaskViewModel::class.java]

        // Setting the task ID for the ViewModel based on the intent extra received.
        detailTaskViewModel.setTaskId(intent.getIntExtra(TASK_ID, 0))

        // Observing changes in the task data using LiveData from the ViewModel.
        detailTaskViewModel.task.observe(this) { task ->
            // Checking if the observed task is not null.
            if (task != null) {
                title.setText(task.title)
                desc.setText(task.description)
                dueDate.setText(DateConverter.convertMillisToString(task.dueDateMillis))
            }
        }

        // Setting up a click listener for the delete button.
        btnDelete.setOnClickListener {
            detailTaskViewModel.deleteTask()

            finish()
        }


    }
}