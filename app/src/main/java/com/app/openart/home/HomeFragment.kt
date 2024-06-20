package com.app.openart.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.openart.R
import com.app.openart.databinding.FragmentHomeBinding
import com.app.openart.home.hotbid.HotBidAdapter
import com.app.openart.home.hotbid.HotBidModel
import com.app.openartfake.liveauction.LiveAuctionAdapter
import com.app.openartfake.liveauction.LiveAuctionModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        setUpHotBidRecyclerView()
        // layout Manager for hot bid recycler view
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvHotBid.layoutManager = layoutManager
        // Sự kiện OnClickListener cho icBackArrow để cuộn tới sau
        binding.icBackArrow.setOnClickListener {
            val newPosition = layoutManager.findFirstVisibleItemPosition() - 1
            if (newPosition >= 0) {
                binding.rvHotBid.smoothScrollToPosition(newPosition)
            }
        }

        // Sự kiện OnClickListener cho icFwArrow để cuộn tới trước
        binding.icFwArrow.setOnClickListener {
            val newPosition = layoutManager.findFirstVisibleItemPosition() + 1
            val totalItemCount = binding.rvHotBid.adapter?.itemCount ?: 0
            if (newPosition < totalItemCount) {
                binding.rvHotBid.smoothScrollToPosition(newPosition)
            }
        }
    }


    private fun setUpRecyclerView() {
        val list = arrayListOf(
            LiveAuctionModel(
                R.drawable.img_rectangle_2,
                R.drawable.img_profile,
                "Silent Color",
                "Pawel Czerwinski",
                R.drawable.ic_heart,
                "2.00 ETH"
            ),
            LiveAuctionModel(
                R.drawable.img_rectangle_3,
                R.drawable.img_profile,
                "George",
                "Pawel Czerwinski",
                R.drawable.ic_heart,
                "2.00 ETH"
            ),
            LiveAuctionModel(
                R.drawable.img_rectangle_4,
                R.drawable.img_profile,
                "Silent Color",
                "Pawel Czerwinski", R.drawable.ic_heart,
                "2.00 ETH"

            ),
            LiveAuctionModel(
                R.drawable.img_rectangle_5,
                R.drawable.img_profile,
                "Silent Color",
                "Pawel Czerwinski", R.drawable.ic_heart,
                "2.00 ETH"

            ),
            LiveAuctionModel(
                R.drawable.img_rectangle_6,
                R.drawable.img_profile,
                "Silent Color",
                "Pawel Czerwinski",
                R.drawable.ic_heart,
                "2.00 ETH"
            ),
        )
        val liveAuctionAdapter = LiveAuctionAdapter()
        liveAuctionAdapter.setData(list)
        binding.rvLiveAuction.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = liveAuctionAdapter
            layoutManager = layoutManager
        }
    }

    private fun setUpHotBidRecyclerView() {
        val list = arrayListOf(
            HotBidModel(
                R.drawable.img_rectangle_7,
            ),
            HotBidModel(
                R.drawable.img_rectangle_7,
            ),
            HotBidModel(
                R.drawable.img_rectangle_7,
            ),
            HotBidModel(
                R.drawable.img_rectangle_7,
            ),
            HotBidModel(
                R.drawable.img_rectangle_7,
            ),
            HotBidModel(
                R.drawable.img_rectangle_7,
            ),
            HotBidModel(
                R.drawable.img_rectangle_7,
            )
        )
        val hotBidAdapter = HotBidAdapter()
        hotBidAdapter.setData(list)
        binding.rvHotBid.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = hotBidAdapter
            layoutManager = layoutManager
        }

    }

}