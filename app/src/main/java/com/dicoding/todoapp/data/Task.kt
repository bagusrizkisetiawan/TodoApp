package com.dicoding.todoapp.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO 1 : Define a local database table using the schema in app/schema/tasks.json
//Declare a local database with the table name "tasks".
@Entity(tableName = "tasks")
data class Task(

    // Set the primary key to automatically generate a value (auto-generate)
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int = 0,

    // Set a column for the task title
    @NonNull
    @ColumnInfo(name = "title")
    val title: String,

    // Set columns for the task description
    @NonNull
    @ColumnInfo(name = "description")
    val description: String,

    // Set a column for the task due date
    @NonNull
    @ColumnInfo(name = "dueDateMillis")
    val dueDateMillis: Long,

    // Set a column for the task completion status,
    @NonNull
    @ColumnInfo(name = "completed")
    val isCompleted: Boolean = false
)
