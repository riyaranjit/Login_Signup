package com.example.activityflow

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.ProgressBar
import android.widget.TextView


class MyBatteryReceiver(var progressBar: ProgressBar, var textBattery: TextView): BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent){

        val batteryLevel= intent?.getIntExtra("level", 0);
        textBattery.text= batteryLevel.toString()+ "%"

        progressBar.progress= batteryLevel

    }
}