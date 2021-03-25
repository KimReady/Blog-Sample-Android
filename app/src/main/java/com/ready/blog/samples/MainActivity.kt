package com.ready.blog.samples

import android.Manifest
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val TRANSITIONS_RECEIVER_ACTION = "TRANSITIONS_RECEIVER_ACTION"
    }

    private lateinit var sampleText: TextView
    private val transitions: List<ActivityTransition> by lazy {
        listOf(
            ActivityTransition.Builder()
                .setActivityType(DetectedActivity.WALKING)
                .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_ENTER)
                .build(),
            ActivityTransition.Builder()
                .setActivityType(DetectedActivity.WALKING)
                .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_EXIT)
                .build(),
            ActivityTransition.Builder()
                .setActivityType(DetectedActivity.STILL)
                .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_ENTER)
                .build(),
            ActivityTransition.Builder()
                .setActivityType(DetectedActivity.STILL)
                .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_EXIT)
                .build()
        )
    }
    private val transitionReceiver by lazy {
        TransitionsReceiver()
    }
    private lateinit var request: ActivityTransitionRequest
    private lateinit var pendingIntent: PendingIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sampleText = findViewById(R.id.sample_text)

        checkAndRequestPermissions()

        request = ActivityTransitionRequest(transitions)
        val intent = Intent(TRANSITIONS_RECEIVER_ACTION)
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
    }

    private fun checkAndRequestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q &&
            PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(this, Manifest.permission.ACTIVITY_RECOGNITION)) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACTIVITY_RECOGNITION), 0)
        }
    }

    private fun printToScreen(message: String) {
        val appendMessage = "${sampleText.text}\n$message"
        sampleText.text = appendMessage
    }

    private fun registerActivityTransitionUpdates() {
        ActivityRecognition.getClient(this)
            .requestActivityTransitionUpdates(request, pendingIntent)
            .addOnSuccessListener {
                printToScreen("Transitions API was successfully registered")
            }.addOnFailureListener { e ->
                printToScreen("Transitions Api could not be registered : $e")
            }
    }

    private fun unregisterActivityTransitionUpdates() {
        ActivityRecognition.getClient(this)
            .removeActivityTransitionUpdates(pendingIntent)
            .addOnSuccessListener {
                printToScreen("Transitions successfully unregistered.")
            }
            .addOnFailureListener { e ->
                printToScreen("Transitions could not be unregistered : $e")
            }
    }

    override fun onStart() {
        super.onStart()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q &&
            PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(this, Manifest.permission.ACTIVITY_RECOGNITION)) {
            registerActivityTransitionUpdates()
        }
        registerReceiver(transitionReceiver, IntentFilter(TRANSITIONS_RECEIVER_ACTION))
    }

    override fun onPause() {
        unregisterActivityTransitionUpdates()
        super.onPause()
    }

    override fun onStop() {
        ActivityRecognition.getClient(this).removeActivityTransitionUpdates(pendingIntent)
        unregisterReceiver(transitionReceiver)
        super.onStop()
    }

    inner class TransitionsReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action != TRANSITIONS_RECEIVER_ACTION) {
                return
            }

            if (ActivityTransitionResult.hasResult(intent)) {
                val result: ActivityTransitionResult = ActivityTransitionResult.extractResult(intent) ?: return

                for (event in result.transitionEvents) {
                    val message = "Transition : ${if(event.activityType == DetectedActivity.WALKING) "WALKING" else "STILL"} (${event.transitionType})"
                    printToScreen(message)
                }
            }
        }
    }
}
