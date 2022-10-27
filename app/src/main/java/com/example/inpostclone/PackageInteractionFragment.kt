package com.example.inpostclone

import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.inpostclone.databinding.ActivityMainBinding
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inpostclone.databinding.FragmentPackageInteractionBinding

class PackageInteractionFragment(val packageInteractionData: PackageInteractionData) : Fragment() {

    lateinit var binding : FragmentPackageInteractionBinding
    private val viewModel: ActivityViewModel by activityViewModels();

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPackageInteractionBinding.inflate(layoutInflater)

        binding.bottomView.bottomText.text = packageInteractionData.bottomText
        binding.bottomView.topText.text = packageInteractionData.topText


//        binding.floatingButton.setOnClickListener(){
//            val pack = com.example.inpostclone.Package(1234,"Shiping","John Smith")
//            viewModel.addPackage(pack)
//            binding.packagesList.adapter?.notifyItemInserted(0)
//        }
        binding.addButton.setOnClickListener(){
            val pack = com.example.inpostclone.Package(1234,"Shiping","John Smith"+ viewModel.user.packageManager.packages.size.toString())
            viewModel.addPackage(pack)
            binding.packagesList.adapter?.notifyItemInserted(viewModel.user.packageManager.packages.size-1)
        }

        viewModel.user.packageManager.havePackages.observe(viewLifecycleOwner, Observer<Boolean> {
                t-> switchToListView(t);
        })

        binding.packagesList.adapter = PackagesRecyclerAdapter(viewModel.user.packageManager.packages);
        binding.packagesList.layoutManager = LinearLayoutManager(requireActivity().applicationContext)

        return binding.root
    }

    companion object {
    }

    fun switchToListView(havePackages : Boolean){
        if (havePackages) {
            binding.bottomView.root.visibility = View.GONE;
            binding.packagesList.visibility = View.VISIBLE;
            binding.topImage.visibility = View.GONE;
        } else {
            binding.bottomView.root.visibility = View.VISIBLE;
            binding.packagesList.visibility = View.GONE;
            binding.topImage.visibility = View.VISIBLE;
        }
    }
}