package com.example.footballapps.utils

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.example.footballapps.R

private val NOTIFICATION_ID = 0
fun NotificationManager.sendNotification (message: String, applicationContext: Context) {

    val builder = NotificationCompat.Builder(applicationContext, applicationContext.getString(R.string.app_name))
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentTitle(applicationContext.getString(R.string.notification_title))
        .setContentText(message)

    notify(NOTIFICATION_ID, builder.build())
}