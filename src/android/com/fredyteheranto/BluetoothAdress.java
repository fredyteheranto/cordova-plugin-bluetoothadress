package com.fredyteheranto;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.util.Log;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
import java.util.Date;

public class BluetoothAdress extends CordovaPlugin {
  private static final String TAG = "BluetoothAdress";
  private Context context;

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
    Log.d(TAG, "Inicializando BluetoothAdress");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if (action.equals("bluetoothAdress")) {
      // String SECURE_SETTINGS_BLUETOOTH_ADDRESS = "bluetooth_address";
      String SECURE_SETTINGS_BLUETOOTH_ADDRESS = args.getString(0);

      String macAddress = android.provider.Settings.Secure.getString(context.getContentResolver(),
          SECURE_SETTINGS_BLUETOOTH_ADDRESS);
      final PluginResult result = new PluginResult(PluginResult.Status.OK,
          macAddress + SECURE_SETTINGS_BLUETOOTH_ADDRESS);
      callbackContext.sendPluginResult(result);
    }
    return true;
  }

}
