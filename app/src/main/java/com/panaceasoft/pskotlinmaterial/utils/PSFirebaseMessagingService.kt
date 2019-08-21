package com.panaceasoft.pskotlinmaterial.utils

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import androidx.core.app.NotificationCompat
import android.util.Log

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.panaceasoft.pskotlinmaterial.R
import com.panaceasoft.pskotlinmaterial.activity.MainActivity

/**
 * Created by Panacea-Soft on 1/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
class PSFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(s: String?) {
        super.onNewToken(s)
        Log.e("NEW_TOKEN", s)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        sendAwesomeMaterialNotification(remoteMessage?.notification?.body)
    }

    private fun sendAwesomeMaterialNotification(message: String?) {

        //On click of notification it redirect to this Activity
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)

        val soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, "Awesome_Material")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Awesome Material")
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(soundUri)
                .setContentIntent(pendingIntent)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(0, notificationBuilder.build())
    }
}
