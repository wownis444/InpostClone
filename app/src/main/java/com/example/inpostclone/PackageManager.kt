package com.example.inpostclone

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PackageManager() {

    private val packages = mutableListOf<com.example.inpostclone.Package>()
    lateinit var havePackages: MutableLiveData<Boolean>

    init {
        havePackages.value = false;
    }

    fun addPackage(pack : Package){
        packages.add(pack);
//        addPackageNotyfication();
        if(packages.size == 1){
            havePackages.value = true;
        }else if(packages.size == 0){
            havePackages.value = false;
        }

    }
}