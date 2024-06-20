package com.app.openart.home.hotbid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.openart.databinding.ItemHotBidBinding

class HotBidAdapter : RecyclerView.Adapter<HotBidAdapter.HotBidViewHolder>() {
    private var list: ArrayList<HotBidModel> = ArrayList()

    fun setData(list: ArrayList<HotBidModel>) {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotBidViewHolder {
        return HotBidViewHolder(
            ItemHotBidBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HotBidViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class HotBidViewHolder(val binding: ItemHotBidBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HotBidModel) {
            binding.ivImage.setImageResource((data.image ?: 0))
        }
    }


}