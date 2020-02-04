package com.bgmsoft.shin.ui.main.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bgmsoft.shin.R
import kotlinx.android.synthetic.main.item_recyclerview_default.view.*

class RvExampleDefaultAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var tasks: ArrayList<String> = arrayListOf()

    init {
        tasks = arrayListOf()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview_default, parent, false)

        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = tasks[position]

        holder.itemView.tv_item_recyclerview_default.text = item
    }

    fun setTaskList(list: ArrayList<String>) {
        tasks.clear()
        tasks.addAll(list)

        notifyDataSetChanged()
    }

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}