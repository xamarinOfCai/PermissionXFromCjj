package com.example.mylibrary

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment
typealias cjj = (Boolean,List<String>)->Unit
class InvisibleFragment :Fragment() {


    private var callBack:(cjj)? = null


    fun requestNow(cb:cjj,vararg permissions: String){
        callBack = cb
        requestPermissions(permissions,1);
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == 1){
            val deniedList = ArrayList<String>()
            for ((index,result) in grantResults.withIndex()) {
                if(PackageManager.PERMISSION_GRANTED != result){
                    deniedList.add(permissions[index])
                }
                val allGranted = deniedList.isEmpty();
                callBack?.let{
                    it(allGranted,deniedList)
                }
            }
        }
    }
}