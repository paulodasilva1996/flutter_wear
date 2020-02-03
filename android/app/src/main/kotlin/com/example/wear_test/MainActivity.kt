package com.example.wear_test
import android.os.Bundle
import androidx.wear.ambient.AmbientModeSupport
import androidx.wear.ambient.AmbientModeSupport.attach

import io.flutter.app.FlutterActivity
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity: FlutterActivity(), AmbientModeSupport.AmbientCallbackProvider {
  private var mAmbientController: AmbientModeSupport.AmbientController? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    GeneratedPluginRegistrant.registerWith(this)

    // Set the Flutter ambient callbacks
    mAmbientController = attach(this)
  }

  override fun getAmbientCallback(): AmbientModeSupport.AmbientCallback {
    return FlutterAmbientCallback(getWearChannel(flutterView))
  }
}