package com.veen.cars.adapter

import android.content.ComponentName
import android.content.pm.PackageManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.veen.cars.R
import com.veen.cars.activity.HomeActivity
import com.veen.cars.model.AppInfo

class AppListAdapter(private val list: List<AppInfo>)
    : RecyclerView.Adapter<AppListAdapter.AppInfoViewHolder>(){

    var onItemClick: ((AppInfo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppInfoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AppInfoViewHolder(inflater, parent);
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AppInfoViewHolder, position: Int) {

        val appInfo: AppInfo = list[position]
        holder.bind(appInfo)
    }


    inner class AppInfoViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.app_info_list_item, parent, false)) {

        val labelView = itemView.findViewById<TextView>(R.id.label)
        val iconView = itemView.findViewById<ImageView>(R.id.icon)
        val iconLayout = itemView.findViewById<ConstraintLayout>(R.id.iconLayout)

        fun bind(appInfo: AppInfo) {
            labelView?.text = appInfo.label
            iconView?.setImageDrawable(appInfo.icon)

            iconLayout.setOnClickListener {
                onItemClick?.invoke(list[adapterPosition])
            }

            labelView.setOnClickListener {
                onItemClick?.invoke(list[adapterPosition])
            }

            iconLayout.setOnLongClickListener {view->
                Toast.makeText(view.context, "Disabled", Toast.LENGTH_SHORT).show()
                val p: PackageManager = view.context.packageManager
                val componentName = ComponentName(view.context, HomeActivity::class.java)
                p.setComponentEnabledSetting(
                    componentName,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP
                )
                iconLayout.visibility = View.GONE
                return@setOnLongClickListener false
            }
        }

    }

}