package com.example.mana_grimoire

import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Handler
import android.os.Looper
import android.util.Log
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    private val feedbackTag = "ManaScanFeedback"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            "mana_grimoire/scan_feedback"
        ).setMethodCallHandler { call, result ->
            if (call.method != "playRecognitionSound") {
                result.notImplemented()
                return@setMethodCallHandler
            }

            try {
                val tone = ToneGenerator(AudioManager.STREAM_MUSIC, 100)
                val started = tone.startTone(ToneGenerator.TONE_PROP_BEEP, 180)
                Handler(Looper.getMainLooper()).postDelayed({ tone.release() }, 260)
                Log.d(feedbackTag, "playRecognitionSound stream=music started=$started")
                result.success(started)
            } catch (error: RuntimeException) {
                Log.e(feedbackTag, "playRecognitionSound failed", error)
                result.error("tone_failed", error.message, null)
            }
        }
    }
}
