package com.example.courselistapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Course(
    val id: Int,
    val title: String,
    val code: String,
    val creditHours: Int,
    val description: String,
    val prerequisites: String
) : Parcelable