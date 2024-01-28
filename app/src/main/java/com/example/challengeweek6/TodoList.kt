package com.example.challengeweek6

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengeweek6.databinding.FragmentTodoBinding

class TodoList: Fragment() {
    private val binding by lazy { FragmentTodoBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter=TodoAdapter(TodoManager.getList())
        binding.rvTodo.adapter=adapter.also {
            it.itemClick= object : TodoAdapter.ItemClick{
                override fun onClick(view: View, position: Int) {
                    val data = TodoManager.getList()[position]
                    val intent = Intent(activity, ItemDetail::class.java)
                    intent.putExtra("todolist", data)
                    intent.putExtra("mode", 0)
                    startActivity(intent)
                }
            }
            it.switchClick = object : TodoAdapter.SwitchClick{
                override fun onClick(view: View, position: Int) {
                    TodoManager.toggleTodo(position)
                }
            }
        }
        binding.rvTodo.layoutManager= LinearLayoutManager(requireContext())
        binding.rvTodo.addItemDecoration(DividerItemDecoration(binding.rvTodo.getContext(), DividerItemDecoration.VERTICAL))

        binding.fabAdd.setOnClickListener {
            val intent = Intent(activity, ItemDetail::class.java)
            intent.putExtra("mode", 1)
            startActivity(intent)
        }
    }
}