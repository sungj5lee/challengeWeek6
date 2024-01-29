package com.example.challengeweek6

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.challengeweek6.databinding.FragmentBookmarkBinding

class BookmarkList: Fragment() {
    private val binding by lazy { FragmentBookmarkBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter=TodoAdapter(TodoManager.getList().filter { it.bookmarked }.toMutableList())
        binding.rvBook.adapter=adapter.also {
            it.itemClick= object : TodoAdapter.ItemClick{
                override fun onClick(view: View, position: Int) {
                    val data = TodoManager.getList()[position]
                    val intent = Intent(activity, ItemDetail::class.java)
                    intent.putExtra("todolist", data)
                    intent.putExtra("id", position)
                    intent.putExtra("mode", 0)
                    startActivity(intent)
                }
            }
            it.switchClick = object : TodoAdapter.SwitchClick{
                override fun onClick(view: View, position: Int) {
                    TodoManager.toggleTodo(position)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}