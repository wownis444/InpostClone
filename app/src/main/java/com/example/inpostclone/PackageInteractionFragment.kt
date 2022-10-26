package com.example.inpostclone

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.inpostclone.databinding.ActivityMainBinding
import com.example.inpostclone.databinding.FragmentPackageInteractionBinding

class PackageInteractionFragment(val packageInteractionData: PackageInteractionData) : Fragment() {

    lateinit var binding : FragmentPackageInteractionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPackageInteractionBinding.inflate(layoutInflater)

        binding.bottomView.bottomText.text = packageInteractionData.bottomText
        binding.bottomView.topText.text = packageInteractionData.topText

        binding.addButton.setOnClickListener(){

            val pack  = com.example.inpostclone.Package(1234,"Shiping", "John Smith")
            val user = User("Example User", requireActivity().applicationContext )
            user.packageManager.addPackage(pack);
        }




        return binding.root

    }

    companion object {
    }
}