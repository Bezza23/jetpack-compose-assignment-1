package com.example.courselistapp

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CourseListScreen(courses: List<Course>) {
    // 1. Create a custom saver for the map
    val mapSaver = remember {
        listSaver<MutableMap<Int, Boolean>, Any>(
            save = { map ->
                map.entries.map { entry -> listOf(entry.key, entry.value) }
            },
            restore = { restored ->
                mutableMapOf<Int, Boolean>().apply {
                    (restored as List<List<Any>>).forEach { item ->
                        put(item[0] as Int, item[1] as Boolean)
                    }
                }
            }
        )
    }

    // 2. Use rememberSaveable with the custom saver
    val expandedStates = rememberSaveable(saver = mapSaver) {
        mutableStateMapOf<Int, Boolean>().apply {
            courses.forEach { course -> put(course.id, false) }
        }
    }

    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(courses) { course ->
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