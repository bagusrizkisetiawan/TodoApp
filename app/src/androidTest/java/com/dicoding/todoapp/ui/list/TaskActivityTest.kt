package com.dicoding.todoapp.ui.list

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.add.AddTaskActivity
import org.junit.After
import org.junit.Before
import org.junit.Test

//TODO 16 : Write UI test to validate when user tap Add Task (+), the AddTaskActivity displayed
class TaskActivityTest {

    // Before test execution, launch TaskActivity and initialize Intent testing
    @Before
    fun start() {
        ActivityScenario.launch(TaskActivity::class.java)
        Intents.init()
    }

    // Test to validate that tapping on the "Add Task (+)" button opens AddTaskActivity
    @Test
    fun validateTapAddOnTaskActivity() {
        // Perform a click action on the FloatingActionButton with ID R.id.fab
        Espresso.onView(ViewMatchers.withId(R.id.fab)).perform(ViewActions.click())
        // Verify that the intended component of the launched intent is AddTaskActivity
        Intents.intended(IntentMatchers.hasComponent(AddTaskActivity::class.java.name))
    }

    // After the test execution, release resources used by Intent testing
    @After
    fun finish() {
        Intents.release()
    }
}