package com.himanshu.snackbaruses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    var btnShort: Button?=null
    var btnLong: Button?=null
    var btnIndefinite: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnShort=findViewById(R.id.btnShort)
        btnIndefinite=findViewById(R.id.btnIndefinite)
        btnLong=findViewById(R.id.btnLong)
        btnShort?.setOnClickListener {
            btnShort?.let {
                Snackbar.make(it,"Short snackbar",Snackbar.LENGTH_SHORT).setAction("OK"){
                    Toast.makeText(this,"Toast",Toast.LENGTH_SHORT).show()
                }.show()
            }
        }
        btnLong?.setOnClickListener {
            btnLong?.let {
                Snackbar.make(it,"Long snackbar",Snackbar.LENGTH_LONG).setAction("OK"){
                    Toast.makeText(this,"Toast",Toast.LENGTH_LONG).show()
                }.show()
            }
        }
        btnIndefinite?.setOnClickListener {
            btnIndefinite?.let {
                Snackbar.make(it,"Indefinite snackbar",Snackbar.LENGTH_INDEFINITE).setAnchorView(btnLong).show()
            /*{
                    Toast.makeText(this,"Toast",Toast.LENGTH_SHORT).show()
                }*/
            }
        }
    }
}