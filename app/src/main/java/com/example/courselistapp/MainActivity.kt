package com.example.courselistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.courselistapp.ui.theme.CourseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val courses = listOf(
            Course(
                id = 1,
                title = "Introduction to Kotlin",
                code = "CS101",
                creditHours = 3,
                description = "Learn the basics of Kotlin programming.",
                prerequisites = "None"
            ),
            Course(
                id = 2,
                title = "Advanced Jetpack Compose",
                code = "CS202",
                creditHours = 4,
                description = "Master advanced UI techniques with Compose.",
                prerequisites = "CS101 or equivalent"
            ),
            Course(
                id = 3,
                title = "Android App Development",
                code = "CS303",
                creditHours = 3,
                description = "Build full Android apps from scratch.",
                prerequisites = "CS101, CS202"
            ),
            Course(
                id = 4,
                title = "Data Structures and Algorithms",
                code = "CS204",
                creditHours = 4,
                description = "Explore key data structures and algorithmic techniques.",
                prerequisites = "CS101"
            ),
            Course(
                id = 5,
                title = "Mobile App Security",
                code = "CS305",
                creditHours = 3,
                description = "Learn security practices for mobile applications.",
                prerequisites = "CS303"
            ),
            Course(
                id = 6,
                title = "Software Engineering Principles",
                code = "CS406",
                creditHours = 4,
                description = "Understand software design and development methodologies.",
                prerequisites = "CS204, CS303"
            )
        )
        setContent {
            CourseAppTheme {
                CourseListScreen(courses = courses)
            }
        }
    }
}