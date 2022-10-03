package io.github.prem_sh.designpattens.observerpattern.SlaveDevices;

import io.github.prem_sh.designpattens.observerpattern.Abstraction.BluetoothReciever;
import io.github.prem_sh.designpattens.observerpattern.Abstraction.BluetoothTransmitter;
import io.github.prem_sh.designpattens.observerpattern.MasterDevices.DataObjects.MobileNotificationData;
import io.github.prem_sh.designpattens.observerpattern.MasterDevices.DataObjects.SoundData;

public class SmartWatchBt extends BluetoothReciever {
    MobileNotificationData data;
    public SmartWatchBt(BluetoothTransmitter t) {
        watch(t);
    }

    @Override
    public void update(Object data) {
        try{
            this.data = (MobileNotificationData) data;
            System.out.println("[SmartWatch]"+this.data);
        }catch (ClassCastException e){}
    }
}
