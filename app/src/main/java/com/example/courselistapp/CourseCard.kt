package com.example.courselistapp

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courselistapp.ui.theme.CourseAppTheme

@Composable
fun CourseCard(
    course: Course,
    isExpanded: Boolean,
    onExpandToggle: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onExpandToggle(course.id) }
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy))
                .background(MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = course.title, style = MaterialTheme.typography.headlineSmall)
                Text(
                    text = "Code: ${course.code}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    text = "Credit Hours: ${course.creditHours}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            if (isExpanded) {
                Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
                    Text(
                        text = "Description: ${course.description}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Prerequisites: ${course.prerequisites}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseCardPreviewLight() {
    CourseAppTheme(darkTheme = false) {
        CourseCard(
            course = Course(
                id = 1,
                title = "Introduction to Kotlin",
                code = "CS101",
                creditHours = 3,
                description = "Learn the basics of Kotlin programming.",
                prerequisites = "None"
            ),
            isExpanded = false,
            onExpandToggle = {}
        )
    }
}

@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CourseCardPreviewDark() {
    CourseAppTheme(darkTheme = true) {
        CourseCard(
            course = Course(
                id = 1,
                title = "Introduction to Kotlin",
                code = "CS101",
                creditHours = 3,
                description = "Learn the basics of Kotlin programming.",
                prerequisites = "None"
            ),
            isExpanded = true,
            onExpandToggle = {}
        )
    }
}