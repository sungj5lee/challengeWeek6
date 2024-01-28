package com.example.challengeweek6

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.challengeweek6.databinding.FragmentBookmarkBinding

class BookmarkList: Fragment() {
    private val binding by lazy { FragmentBookmarkBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}