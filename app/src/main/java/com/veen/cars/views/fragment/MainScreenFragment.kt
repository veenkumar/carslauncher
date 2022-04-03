package com.veen.cars.views.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.veen.cars.R
import com.veen.cars.model.AppInfo
import com.veen.cars.utils.AppClick
import com.veen.cars.views.adapter.AppListAdapter

class MainScreenFragment() : Fragment(), AppClick {
    private lateinit var mainScreenFragmentViewModel: MainScreenFragmentViewModel
    private lateinit var v: View
    var position: Int = 0

    constructor(p: Int) : this() {
        position = p
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_main_screen, container, false)

        mainScreenFragmentViewModel =
            ViewModelProvider(this)[MainScreenFragmentViewModel::class.java]
        mainScreenFragmentViewModel.getPosition(v, position)
        val apps = mainScreenFragmentViewModel.getAppList()

        val listView: RecyclerView = v.findViewById(R.id.list_view)
        listView.apply {
            layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
            adapter = AppListAdapter(apps, this@MainScreenFragment)
        }

        val adapter: AppListAdapter = listView.adapter as AppListAdapter

        adapter.onItemClick = { appInfo ->

            // do something with your item
            Log.d("TAG", appInfo.packageName)
            val launchIntent =
                this.context?.packageManager?.getLaunchIntentForPackage(appInfo.packageName)
            startActivity(launchIntent)
        }

        return v
    }

    companion object {
        fun getInstance(position: Int): MainScreenFragment {
            val instance = MainScreenFragment(position)
            // instance.position = position;
            return instance
        }
    }

    override fun onClick(appInfo: AppInfo) {
        Toast.makeText(requireContext(), "Disabled", Toast.LENGTH_SHORT).show()
    }
}