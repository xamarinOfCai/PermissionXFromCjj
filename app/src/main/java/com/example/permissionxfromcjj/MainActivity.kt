package com.example.permissionxfromcjj

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.mylibrary.PermissionXFromCjj


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val callPhone = findViewById<Button>(R.id.callPhone)
        callPhone.setOnClickListener {
            PermissionXFromCjj.request(this,
                android.Manifest.permission.CALL_PHONE){allGranted,deniedList->
                    if(allGranted){
                        call()
                    }else{
                        Toast.makeText(this,"you has denied $deniedList",Toast.LENGTH_LONG).show()
                    }

            }

        }
    }

    private fun call() {
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}