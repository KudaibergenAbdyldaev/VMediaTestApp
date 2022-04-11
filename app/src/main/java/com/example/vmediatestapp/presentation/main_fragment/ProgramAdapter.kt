package com.example.vmediatestapp.presentation.main_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.vmediatestapp.R
import com.example.vmediatestapp.databinding.ProgramItemBinding
import com.example.vmediatestapp.domain.model.ProgramItem

class ProgramAdapter :
    ListAdapter<ProgramItem, ProgramAdapter.ProgramViewHolder>(DiffUtilCallBack) {

    class ProgramViewHolder(private val binding: ProgramItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(program: ProgramItem) {
            binding.program.text = program.name
        }
    }

    object DiffUtilCallBack : DiffUtil.ItemCallback<ProgramItem>() {
        override fun areItemsTheSame(
            oldItem: ProgramItem,
            newItem: ProgramItem
        ): Boolean {
            return oldItem.recentAirTime.id == newItem.recentAirTime.id
        }

        override fun areContentsTheSame(
            oldItem: ProgramItem,
            newItem: ProgramItem
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        return ProgramViewHolder(
            ProgramItemBinding.bind(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.program_item, parent, false
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ProgramViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

}