package com.example.mylibrary

import androidx.fragment.app.FragmentActivity


object PermissionXFromCjj {
    private const val  TAG = "InvisiableFragment"


    fun request(activity:FragmentActivity,vararg permissions:String,callback: cjj){
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if(existedFragment != null){
            existedFragment as InvisibleFragment
        }else{
            val invisiableFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisiableFragment, TAG).commitNow()
            invisiableFragment
        }
        fragment.requestNow(callback,*permissions)
    }


}