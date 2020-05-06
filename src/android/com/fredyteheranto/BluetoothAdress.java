/**
 */
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

import java.util.Date;

public class BluetoothAdress extends CordovaPlugin {
  private static final String TAG = "BluetoothAdress";

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Inicializando BluetoothAdress");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if (action.equals("bluetoothAdress")) {

      // An example of returning data back to the web layer
      // String phrase = args.getString(0);
      // Echo back the first argument
      // final PluginResult result = new PluginResult(PluginResult.Status.OK, "Hola
      // todo el... " + phrase);
      final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      String bluetoothMacAddress = "";

      Field mServiceField = bluetoothAdapter.getClass().getDeclaredField("mService");
      mServiceField.setAccessible(true);

      Object btManagerService = mServiceField.get(bluetoothAdapter);

      if (btManagerService != null) {
        bluetoothMacAddress = (String) btManagerService.getClass().getMethod("getAddress").invoke(btManagerService);
        callbackContext.sendPluginResult(bluetoothMacAddress);
      }

    }
    return true;
  }

}
