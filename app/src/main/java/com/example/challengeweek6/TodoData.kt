package com.example.challengeweek6

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TodoData (
    var title: String,
    var body: String,
    var bookmarked: Boolean
): Parcelable