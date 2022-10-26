package com.example.inpostclone

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainPageFragmentAdapter(activity: MainActivity,val actions: List<String>): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3;
    }

    override fun createFragment(position: Int): Fragment {

        return PackageInteractionFragment(PackageInteractionData(actions[position]))

//        if(position == 0){
//            return PackageInteractionFragment(PackageInteractionData(actions[0]))
//        }else if(position == 1){
//            return PackageInteractionFragment(PackageInteractionData("nadajesz"))
//        }else if(position == 2){
//            return PackageInteractionFragment(PackageInteractionData("zwrociles"))
//        }else{
//            return PackageInteractionFragment(PackageInteractionData("odbierasz"))
//        }
    }


}