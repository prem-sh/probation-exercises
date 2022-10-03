package io.github.prem_sh.designpattens.observerpattern.SlaveDevices;

import io.github.prem_sh.designpattens.observerpattern.Abstraction.BluetoothReciever;
import io.github.prem_sh.designpattens.observerpattern.Abstraction.BluetoothTransmitter;
import io.github.prem_sh.designpattens.observerpattern.MasterDevices.DataObjects.KeyboardData;

public class KeyboardBt extends BluetoothReciever {
    KeyboardData data;
    public KeyboardBt(BluetoothTransmitter t) {
        watch(t);
    }
    @Override
    public void update(Object data) {
        try{
            this.data = (KeyboardData) data;
            System.out.println("[Keyboard]"+this.data);
        }catch (ClassCastException e){}
    }
}
