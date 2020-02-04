package com.bgmsoft.shin.ui.main.recyclerview

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bgmsoft.shin.R
import kotlinx.android.synthetic.main.rv_example_fragment.*

class RvExampleFragment : Fragment() {

    companion object {
        fun newInstance() = RvExampleFragment()
    }

    private lateinit var viewModel: RvExampleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rv_example_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RvExampleViewModel::class.java)
        // TODO: Use the ViewModel

        for (i in 0..10) {
            viewModel.taskList.add("index : $i ")
        }

        initRecyclerView()
    }

    fun initRecyclerView() {
        rv_example_recyclerview.adapter = RvExampleDefaultAdapter()
        (rv_example_recyclerview.adapter as RvExampleDefaultAdapter).apply {
            this.setTaskList(viewModel.taskList)
            this.notifyDataSetChanged()
        }

    }

}
