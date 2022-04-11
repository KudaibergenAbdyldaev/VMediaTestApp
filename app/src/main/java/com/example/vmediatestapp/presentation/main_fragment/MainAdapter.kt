package com.example.vmediatestapp.presentation.main_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.vmediatestapp.R
import com.example.vmediatestapp.databinding.ChannelItemBinding
import com.example.vmediatestapp.domain.ChannelAndProgram

class MainAdapter :
    ListAdapter<ChannelAndProgram, MainAdapter.ChannelViewHolder>(DiffUtilCallBack) {

    class ChannelViewHolder(private val binding: ChannelItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(channel: ChannelAndProgram) {
            val adapter = ProgramAdapter()
            binding.channel.text = channel.channel.callSign
            binding.recyclerview.adapter = adapter
            adapter.submitList(channel.programs)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        return ChannelViewHolder(
            ChannelItemBinding.bind(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.channel_item, parent, false
                )
            )
        )

    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    object DiffUtilCallBack : DiffUtil.ItemCallback<ChannelAndProgram>() {
        override fun areItemsTheSame(
            oldItem: ChannelAndProgram,
            newItem: ChannelAndProgram
        ): Boolean {
            return oldItem.channel == newItem.channel
        }

        override fun areContentsTheSame(
            oldItem: ChannelAndProgram,
            newItem: ChannelAndProgram
        ): Boolean {
            return oldItem == newItem
        }
    }

}