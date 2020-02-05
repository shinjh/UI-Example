package com.bgmsoft.shin.ui.main.recyclerview

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bgmsoft.shin.R
import com.bgmsoft.shin.extension.setImageFromUrl
import com.bgmsoft.shin.model.Task
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.item_recyclerview_default.view.*

class RvExampleDefaultAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_HEADER = 0

    private val TYPE_ITEM = 1

    private val TYPE_FOOTER = 2

    // 아이템 데이터 리스트
    private var tasks: ArrayList<Task> = arrayListOf()

    // 선택 데이터 리스트
    private var selectedItems: SparseBooleanArray = SparseBooleanArray()

    // 아이템 동작과 외부를 연결하기 위한 콜백
    private var listener: OnItemInteractionListener? = null

    // onCreateViewHolder에서 inflate하는 부분을 간단하게 하기 위해 추가
    private fun ViewGroup.inflate(layoutRes: Int): View = LayoutInflater.from(context).inflate(layoutRes, this, false)

    // 각 View의 Type에 따른 ViewHolder 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> HeaderViewHolder(parent.inflate(R.layout.item_recyclerview_header))
            TYPE_FOOTER -> FooterViewHolder(parent.inflate(R.layout.item_recyclerview_footer))
            else -> TaskViewHolder(parent.inflate(R.layout.item_recyclerview_default))
        }
    }

    // 아이템의 전체 갯수 + Header(1) + Footer(1)
    override fun getItemCount(): Int {
        return tasks.size + 2
    }

    // 아이템의 타입을 반환 (position은 0 기반이므로 [전체 갯수 - 1]일 경우에 Footer 타입 반환)
    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_HEADER
            itemCount - 1 -> TYPE_FOOTER
            else -> TYPE_ITEM
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // Holder에 따른 Binding 처리
        when (holder) {
            is HeaderViewHolder -> {
                holder.itemView.setOnClickListener {
                    listener?.onClickHeader()

                    Snackbar.make(it, "Header is Clicked!!", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
            }
            is FooterViewHolder -> {
                holder.itemView.setOnClickListener {
                    listener?.onClickFooter()

                    Snackbar.make(it, "Footer is Clicked!!", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
            }
            else -> {
                val item = tasks[position - 1]

                // 아이 데이터를 사용하여 각 아이템 값 설정
                holder.itemView.apply {
                    tv_item_default_name.text = item.name
                    tv_item_default_details.text = item.details
                    iv_item_default_img.setImageFromUrl(item.image)

                    setOnClickListener {
                        if (selectedItems.get(position)) {
                            // VISIBLE -> INVISIBLE
                            selectedItems.delete(position)

                            cl_item_expand.visibility = View.GONE

                        } else {
                            // INVISIBLE -> VISIBLE
                            selectedItems.put(position, true)

                            cl_item_expand.visibility = View.VISIBLE
                        }
                    }
                }
            }
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
        tasks.removeAt(position - 1)

        notifyDataSetChanged()
    }

    fun setOnItemInteractionListener(listener: OnItemInteractionListener) {
        this.listener = listener
    }

    interface OnItemInteractionListener {
        fun onClickHeader()
        fun onClickFooter()
    }

    /**
     * Item Type에 따른 View Holder Class
     */
    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}