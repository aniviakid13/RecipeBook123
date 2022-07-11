package com.codefresher.recipebook.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codefresher.recipebook.R
import com.codefresher.recipebook.adapter.PopularAdapter
import com.codefresher.recipebook.adapter.RecentAdapter
import com.codefresher.recipebook.adapter.TrendingAdapter
import com.codefresher.recipebook.model.PopularModel
import com.codefresher.recipebook.model.RecentModel
import com.codefresher.recipebook.model.TrendingModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {
    private var trendingList = arrayListOf<TrendingModel>()
    private var popularList = arrayListOf<PopularModel>()
    private var recentList = arrayListOf<RecentModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewHome = inflater.inflate(R.layout.fragment_home, container, false)

        postToList()

        viewHome.recyclerViewTrending.setHasFixedSize(false)
        viewHome.recyclerViewTrending.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        viewHome.recyclerViewTrending.adapter = TrendingAdapter(trendingList)

        viewHome.recyclerViewPopular.setHasFixedSize(false)
        viewHome.recyclerViewPopular.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        viewHome.recyclerViewPopular.adapter = PopularAdapter(popularList)

        viewHome.recyclerViewRecent.isNestedScrollingEnabled = false
        viewHome.recyclerViewRecent.setHasFixedSize(false)
        viewHome.recyclerViewRecent.layoutManager =  GridLayoutManager(activity,2,GridLayoutManager.VERTICAL,false)
        viewHome.recyclerViewRecent.adapter = RecentAdapter(recentList)



        return viewHome
    }


    private fun postToList() {
        trendingList.clear()
        for (i: Int in 1..6) {
            addTrendingList("The Ultimate Waffle", R.drawable.trending001)
        }
        popularList.clear()
        for (i: Int in 1..6) {
            addPopularList("The Ultimate Waffle", R.drawable.trending001)
        }
        recentList.clear()
        for (i: Int in 1..6) {
            addRecentList("The Ultimate Waffle", R.drawable.trending001)
        }

    }


    private fun addTrendingList(title: String, img: Int) {
        trendingList.add(TrendingModel(title, img))
    }

    private fun addPopularList(title: String, img: Int) {
        popularList.add(PopularModel(title, img))
    }

    private fun addRecentList(title: String, img: Int) {
        recentList.add(RecentModel(title, img))
    }

}