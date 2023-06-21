package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.Description

class StatisticsUtilsTest {
    @Test
    fun getActiveAndCompletedStats_onNotCompletedTask_returnHundredZero() {
        //when
        val tasks = listOf(
                Task("Test", "test", false)
        )
        //given
        val result = getActiveAndCompletedStats(tasks)
        //then
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f, result.activeTasksPercent)

    }


    @Test
    fun getActiveAndCompletedStats_onCompletedTask_returnZeroHundred() {
        //when
        val tasks = listOf<Task>(
                Task("Test", "test", true)
        )
        //given
        val result = getActiveAndCompletedStats(tasks)
        //then
        assertEquals(0f, result.activeTasksPercent)
        assertEquals(100f, result.completedTasksPercent)
    }


    @Test
    fun getActiveAndCompletedStats_onMultipleTasks_returnCorrectPercentages() {
        //when
        val tasks = listOf<Task>(
                Task("Test1", "Test1", true),
                Task("Test2", "Test2", true),
                Task("Test3", "Test3", false),
                Task("Test4", "Test4", false),
                Task("Test5", "Test5", false)
        )
        //given
        val result = getActiveAndCompletedStats(tasks)
        //then
        assertEquals(60f, result.activeTasksPercent)
        assertEquals(40f, result.completedTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_onEmptyTaskList_returnZeroPercent() {
        // Given
        val tasks = emptyList<Task>()

        // When
        val result = getActiveAndCompletedStats(tasks)

        // Then
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_onNullTaskList_returnZeroPercent() {
        // Given
        val tasks: List<Task>? = null

        // When
        val result = getActiveAndCompletedStats(tasks)

        // Then
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }

}