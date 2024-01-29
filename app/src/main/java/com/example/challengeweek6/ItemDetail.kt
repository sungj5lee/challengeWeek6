package com.example.challengeweek6

import android.os.Build
import android.os.Bundle
import android.view.View.GONE
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.challengeweek6.databinding.ActivityItemBinding

class ItemDetail : AppCompatActivity() {
    private val binding by lazy { ActivityItemBinding.inflate(layoutInflater) }
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mode = intent.getIntExtra("mode", 0)
        if (mode==0){
            val data = intent.getParcelableExtra("todolist", TodoData::class.java)
            val position = intent.getIntExtra("id", 0)
            binding.etTitle.setText(data?.title)
            binding.etBody.setText(data?.body)
            binding.btnDelete.setOnClickListener {
                TodoManager.removeTodoData(position)
                finish()
            }
            binding.btnAdd.setOnClickListener {
                TodoManager.editTodo(position, binding.etTitle.text.toString(), binding.etBody.text.toString())
                finish()
            }
        }
        else{
            binding.btnDelete.visibility=GONE
            binding.btnAdd.text="등록"
            binding.btnAdd.setOnClickListener {
                TodoManager.addTodoData(TodoData(binding.etTitle.text.toString(), binding.etBody.text.toString(), false))
                finish()
            }
        }
    }
}