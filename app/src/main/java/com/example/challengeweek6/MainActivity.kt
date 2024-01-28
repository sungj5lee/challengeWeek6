package com.example.challengeweek6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.challengeweek6.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewPager()
    }

    private fun initViewPager() {
        val tabTextList = listOf("Todo", "Bookmark")

        //ViewPager2 Adapter 셋팅
        var viewPager2Adapter = ViewPager2Adapter(this)
        viewPager2Adapter.addFragment(TodoList())
        viewPager2Adapter.addFragment(BookmarkList())

        //Adapter 연결
        binding.mainVp.apply {
            adapter = viewPager2Adapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {})
        }

        //ViewPager, TabLayout 연결
        TabLayoutMediator(binding.mainTablay, binding.mainVp) { tab, position ->
            tab.text = tabTextList[position]
        }.attach()
    }
}