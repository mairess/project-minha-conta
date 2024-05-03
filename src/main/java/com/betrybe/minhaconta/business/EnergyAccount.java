package com.betrybe.minhaconta.business;

import com.ions.lightdealer.sdk.model.Address;
import com.ions.lightdealer.sdk.model.Client;
import com.ions.lightdealer.sdk.model.ElectronicDevice;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Energy account.
 */
public class EnergyAccount {

  Client client;

  public EnergyAccount(Client client) {
    this.client = client;
  }

  /**
   * Req. 11 – Find high consumption device per address.
   */
  public ElectronicDevice[] findHighConsumptionDevices() {
    Address[] addresses = client.getAddressesAsArray();
    ElectronicDevice[] highConsumptionDevices = new ElectronicDevice[addresses.length];

    for (int i = 0; i < addresses.length; i += 1) {
      Address address = addresses[i];
      ElectronicDevice[] devices = address.getDevicesAsArray();
      ElectronicDevice highestDevice = null;

      for (ElectronicDevice device : devices) {
        if (highestDevice == null || device.monthlyKwh() > highestDevice.monthlyKwh()) {
          highestDevice = device;
        }
      }
      highConsumptionDevices[i] = highestDevice;
    }
    return highConsumptionDevices;
  }
}
