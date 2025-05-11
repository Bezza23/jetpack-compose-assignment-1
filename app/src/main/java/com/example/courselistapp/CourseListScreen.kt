package com.example.courselistapp

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CourseListScreen(courses: List<Course>) {
    val expandedStates = rememberSaveable {
        mutableStateMapOf<Int, Boolean>().apply {
            courses.forEach { course -> put(course.id, false) }
        }
    }

    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(courses) { course ->  // Changed to direct items iteration
            CourseCard(
                course = course,
                isExpanded = expandedStates[course.id] ?: false,
                onExpandToggle = { id ->
                    expandedStates[id] = !(expandedStates[id] ?: false)
                }
            )
        }
    }
}