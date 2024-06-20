package com.app.openartfake.liveauction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.openart.databinding.ItemLiveAuctionBinding

class LiveAuctionAdapter : RecyclerView.Adapter<LiveAuctionAdapter.LiveAuctionViewHolder>() {
    private var list: ArrayList<LiveAuctionModel> = ArrayList()

    fun setData(list: ArrayList<LiveAuctionModel>) {
        this.list = list
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): LiveAuctionViewHolder {
        return LiveAuctionViewHolder(
            ItemLiveAuctionBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LiveAuctionViewHolder, position: Int) {
        holder.onBind(list[position])
    }
    inner class LiveAuctionViewHolder(private val binding: ItemLiveAuctionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: LiveAuctionModel) {
            binding.ivImage1.setImageResource((data.image ?: 0))
            binding.ivProfile.setImageResource((data.profile ?: 0))
            binding.ivHeart.setImageResource((data.heart ?: 0))
            binding.tvImage1Title.text = data.title
            binding.tvProfileName.text = data.author
            binding.tvPrice.text = data.price
        }
    }
}