package com.example.challengeweek6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.challengeweek6.databinding.ActivityItemBinding

class ItemDetail : AppCompatActivity() {
    private val binding by lazy { ActivityItemBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}