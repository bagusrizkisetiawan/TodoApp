package com.dicoding.todoapp.data

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery

//TODO 2 : Define data access object (DAO)
@Dao
interface TaskDao {

    // Use @RawQuery to allow use of SQL queries
    @RawQuery(observedEntities = [Task::class])
    fun getTasks(query: SupportSQLiteQuery): DataSource.Factory<Int, Task>

    // Retrieve tasks by ID using LiveData
    @Query("SELECT * FROM tasks WHERE id = :taskId")
    fun getTaskById(taskId: Int): LiveData<Task>

    // Retrieve unfinished tasks that have a nearby due date
    @Query("SELECT * FROM tasks WHERE completed = 0 ORDER BY dueDateMillis ASC LIMIT 1")
    fun getNearestActiveTask(): Task

    // Insert a new task into the database
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: Task): Long

    // Insert several tasks at once into the database
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(vararg tasks: Task)

    // Delete the task from the database
    @Delete
    suspend fun deleteTask(task: Task)

    // Updates the task completion status based on the task ID
    @Query("UPDATE tasks SET completed = :completed WHERE id = :taskId")
    suspend fun updateCompleted(taskId: Int, completed: Boolean)

}
