package com.javatpoint.flutterplugins.flutter_demoapplication  
  
import android.app.Activity  
import android.content.Intent  
import android.net.Uri  
import android.os.Bundle  
import io.flutter.app.FlutterActivity  
import io.flutter.plugin.common.MethodCall  
import io.flutter.plugin.common.MethodChannel  
import io.flutter.plugin.common.MethodChannel.MethodCallHandler  
import io.flutter.plugin.common.MethodChannel.Result  
import io.flutter.plugins.GeneratedPluginRegistrant

// import io.flutter.embedding.android.FlutterActivity

class MainActivity:FlutterActivity() {  
    override fun onCreate(savedInstanceState:Bundle?) {  
        super.onCreate(savedInstanceState)  
        GeneratedPluginRegistrant.registerWith(this)  
        MethodChannel(flutterView, CHANNEL).setMethodCallHandler { call, result ->  
        val url = call.argument<String>("url")  
        if (call.method == "openBrowser") {  
            openBrowser(call, result, url)  
        } else {  
            result.notImplemented()  
        }  
    }  
 }  
 private fun openBrowser(call:MethodCall, result:Result, url:String?) {  
    val activity = this  
    if (activity == null)  
    {  
        result.error("UNAVAILABLE", "It cannot open the browser without foreground activity", null)  
        return  
    }  
    val intent = Intent(Intent.ACTION_VIEW)  
    intent.data = Uri.parse(url)  
    activity!!.startActivity(intent)  
    result.success(true as Any)  
 }  
  
 companion object {  
    private val CHANNEL = "flutterplugins.javatpoint.com/browser"  
 }  
} 