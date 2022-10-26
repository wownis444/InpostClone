package com.example.inpostclone

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.inpostclone.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    val actions : MutableList<String> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actions.add("odbierasz");
        actions.add("nadajesz");
        actions.add("zwracasz");

        binding.viewPager2.adapter = MainPageFragmentAdapter(this, actions);
        val tabConfigurationStrategy = TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            tab.text = actions[position];
        }

        TabLayoutMediator(binding.navigationBar,binding.viewPager2, tabConfigurationStrategy).attach()

        createNotificationChanel()
    }


    fun createNotificationChanel(){

        var channel : NotificationChannel? = null;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ){
             channel = NotificationChannel("add_package","New package",NotificationManager.IMPORTANCE_DEFAULT)
        }
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager;
        notificationManager.createNotificationChannel(channel!!)
    }
}