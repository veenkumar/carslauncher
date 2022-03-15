package com.veen.cars.fragment

import android.app.Application
import android.content.Intent
import android.content.pm.PackageManager
import android.view.View
import androidx.lifecycle.AndroidViewModel
import com.veen.cars.R
import com.veen.cars.model.AppInfo

class MainScreenFragmentViewModel(application: Application): AndroidViewModel(application) {

    fun getAppList(): ArrayList<AppInfo> {
        val pm: PackageManager = getApplication<Application>().packageManager;
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

    fun getPosition(view: View, position: Int){
        if (position %2 == 0) {
            view.setBackgroundResource(R.color.white);
        } else {
            view.setBackgroundResource(R.color.teal_200);
        }
    }
}