package com.example.inpostclone

import android.app.Application
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel(application: Application) : AndroidViewModel(application) {

    //    val pack  = com.example.inpostclone.Package(1234,"Shiping", "John Smith")
    val user = User("Example User")
    private val havePackage = MutableLiveData<Boolean>();

    fun addPackage(pack: com.example.inpostclone.Package) {
        user.packageManager.addPackage(pack)
        sendNotyfication()
    }

    private fun sendNotyfication() {

        val context = getApplication<Application>().applicationContext
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notification = NotificationCompat.Builder(context, "add_package")
            .setContentTitle("You have new package to track")
            .setSmallIcon(R.drawable.ic_baseline_markunread_mailbox_24)
            .setContentText("Click to see package details")
            .build()
        notificationManager.notify(1, notification);
    }
}