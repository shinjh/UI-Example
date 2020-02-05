package com.bgmsoft.shin.ui.main.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bgmsoft.shin.R
import com.bgmsoft.shin.extension.setImageFromUrl
import com.bgmsoft.shin.model.Task
import kotlinx.android.synthetic.main.item_recyclerview_default.view.*

class RvExampleDefaultAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // 유효하지 않은 위치에 대한 값
    private val INVALID_POSITION = -1

    // 내부 데이터
    private var tasks: ArrayList<Task> = arrayListOf()

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

        // 내부 데이터를 사용하여 각 아이템 값 설정
        holder.itemView.apply {
            tv_item_default_name.text = item.name
            tv_item_default_details.text = item.details
            iv_item_default_img.setImageFromUrl(item.image)
        }
    }

    // 내부 데이터 전체 값 갱신
    fun setTaskList(list: ArrayList<Task>) {
        tasks.clear()
        tasks.addAll(list)

        notifyDataSetChanged()
    }

    // 내부 데이터 값 추가
    fun addTask(task: Task) {
        tasks.add(task)

        notifyDataSetChanged()
    }

    // 내부 데이터 값 제거
    fun removeTask(position: Int) {
        tasks.removeAt(position)

        notifyDataSetChanged()
    }

    // View Holder
    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}