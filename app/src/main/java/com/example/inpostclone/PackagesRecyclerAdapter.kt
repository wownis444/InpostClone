package com.example.inpostclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.inpostclone.databinding.PackageLayoutBinding

class PackagesRecyclerAdapter(var packages : List<Package>) : RecyclerView.Adapter<PackagesRecyclerAdapter.PackageViewHolder>() {

    inner class PackageViewHolder(val binding: PackageLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageViewHolder {

//        val binding = LayoutInflater.from(parent.context).inflate()
        val binding = PackageLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PackageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) {

        holder.binding.sender.text = packages[position].sender;
        holder.binding.status.text = packages[position].status;
        holder.binding.packageNo.text = packages[position].packageNo.toString();

        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return packages.size;
    }

}