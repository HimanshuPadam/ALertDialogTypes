package com.himanshu.snackbaruses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.himanshu.snackbaruses.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var btnShort: Button?=null
    var btnLong: Button?=null
    var btnIndefinite: Button?=null
    var btnAlertDialog : Button?=null
    var btnAlertList : Button?=null
    var btnAlertMultiple :Button?=null
    var tvOutput: TextView?=null
    var animal= arrayOf("Dog","Tiger","Cat")
    var list= booleanArrayOf(false,false,false)
    var tvText : TextView?=null
    var number=0
    var name:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnShort=findViewById(R.id.btnShort)
        btnIndefinite=findViewById(R.id.btnIndefinite)
        btnLong=findViewById(R.id.btnLong)
        btnAlertDialog=findViewById(R.id.btnAlertDialog)
        btnAlertList=findViewById(R.id.btnAlertList)
        btnAlertMultiple=findViewById(R.id.btnAlertMultiple)
        tvOutput=findViewById(R.id.tvOutput)
        tvText=findViewById(R.id.tvText)

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
        btnAlertDialog?.setOnClickListener {
            var alert = AlertDialog.Builder(this)
            alert.setTitle("Operations")
            alert.setMessage("Select the operation")
            alert.setCancelable(false)
            alert.setPositiveButton("Yes"){_,_->
                Toast.makeText(this, "Added 2", Toast.LENGTH_LONG).show()
                number+=2
                tvOutput?.text=number.toString()
            }
            alert.setNegativeButton("No"){_,_->
                Toast.makeText(this, "Subtracted 2", Toast.LENGTH_LONG).show()
                number-=2
                tvOutput?.text=number.toString()
            }
            alert.setNeutralButton("New"){_,_->
                Toast.makeText(this, "Clear to 0", Toast.LENGTH_LONG).show()
                tvOutput?.text=0.toString()
            }
            alert.show()
        }

        btnAlertList?.setOnClickListener {
            var alert = AlertDialog.Builder(this)
            alert.setTitle("List")
                .setItems(animal) { _, position ->
                    Toast.makeText(this, "Selected item is ${animal[position]}", Toast.LENGTH_SHORT)
                        .show()
                }
            //alert.setMessage("Select the element from list")
            alert.setCancelable(false)
                .show()
        }

        btnAlertMultiple?.setOnClickListener {
            var alert = AlertDialog.Builder(this)
            alert.setCancelable(false)
            alert.setTitle("List")
                .setMultiChoiceItems(animal,list) { _, position, isChecked ->
                    Toast.makeText(
                        this,
                        "Selected item is ${animal[position]},$isChecked",
                        Toast.LENGTH_SHORT
                    ).show()
                    name = animal[position]
                }
            alert.setPositiveButton("Yes"){_,_->
                Toast.makeText(this, "Positive selected", Toast.LENGTH_LONG).show()
                tvText?.text= name
            }.show()
        }
    }
}