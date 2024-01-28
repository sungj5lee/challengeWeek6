package com.example.challengeweek6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeweek6.databinding.ListItemBinding

class TodoAdapter(val mItems: MutableList<TodoData>) : RecyclerView.Adapter<TodoAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    interface SwitchClick {
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null
    var switchClick: SwitchClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        holder.switch.setOnClickListener {
            switchClick?.onClick(it, position)
        }
        holder.title.text = mItems[position].title
        holder.switch.isChecked=mItems[position].bookmarked
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.txtItem
        val switch = binding.swchItem
    }
}