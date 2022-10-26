package com.example.inpostclone

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PackageManager(val context : Context) {

    private val packages = mutableListOf<com.example.inpostclone.Package>()
    lateinit var havePackages: MutableLiveData<Boolean>

    init {
        havePackages.value = false;
    }

    fun addPackage(pack : Package){
        packages.add(pack);
        addPackageNotyfication();
        if(packages.size == 1){
            havePackages.value = true;
        }else if(packages.size == 0){
            havePackages.value = false;
        }
    }

    private fun addPackageNotyfication(){

        val notificationManager  = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notification = NotificationCompat.Builder(context,"add_package")
            .setContentTitle("You have new package to track")
            .setSmallIcon(R.drawable.ic_baseline_markunread_mailbox_24)
            .setContentText("Click to see package details")
            .build()

        notificationManager.notify(1, notification);
    }

}