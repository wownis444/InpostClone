package com.example.inpostclone

import android.content.Context

class User(val name : String,val context: Context) {

    public val packageManager = PackageManager(context)
}