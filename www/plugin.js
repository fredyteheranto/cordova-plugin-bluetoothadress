var exec = require("cordova/exec");

var PLUGIN_NAME = "BluetoothAdress";

var BluetoothAdress = {
  saludo: function (name, successCallback, errorCallback) {
    exec(successCallback, errorCallback, PLUGIN_NAME, "bluetoothAdress", [
      name,
    ]);
  },
};

module.exports = BluetoothAdress;
