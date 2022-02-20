package com.veen.cars.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.icu.lang.UCharacter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.veen.cars.R
import com.veen.cars.adapter.AppListAdapter
import com.veen.cars.databinding.FragmentMainScreenBinding
import com.veen.cars.model.AppInfo

class MainScreenFragment() : Fragment() {
    private lateinit var v: View

    var position: Int = 0

    constructor(p: Int):this() {
        position = p;
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_main_screen, container, false);

        if (position %2 == 0) {
            v.setBackgroundResource(R.color.white);
        } else {
            v.setBackgroundResource(R.color.teal_200);
        }

        val apps = getAppList();

        val listView: RecyclerView = v.findViewById(R.id.list_view);
        listView.apply {
            layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
            adapter = AppListAdapter(apps)
        }

        val adapter: AppListAdapter = listView.adapter as AppListAdapter;

        adapter.onItemClick = { appInfo ->

            // do something with your item
            Log.d("TAG", appInfo.packageName)
            val launchIntent =
                this.context?.packageManager?.getLaunchIntentForPackage(appInfo.packageName)
            startActivity(launchIntent)
        }

        return v;
    }

    fun getAppList(): ArrayList<AppInfo> {
        val pm: PackageManager = requireContext().packageManager;
        val appsList = ArrayList<AppInfo>()

        val i = Intent(Intent.ACTION_MAIN, null)
        i.addCategory(Intent.CATEGORY_LAUNCHER)

        val allApps = pm.queryIntentActivities(i, 0)
        for (ri in allApps) {
            val label = ri.loadLabel(pm).toString();
            val packageName = ri.activityInfo.packageName
            val icon = ri.activityInfo.loadIcon(pm)
            val app = AppInfo(label, packageName, icon)
            appsList.add(app)
        }
        return appsList;
    }


    companion object {
        fun getInstance(position: Int): MainScreenFragment {
            val instance = MainScreenFragment(position);
            // instance.position = position;
            return instance
        }
    }
}