package io.github.prem_sh.designpattens.observerpattern.SlaveDevices;

import io.github.prem_sh.designpattens.observerpattern.Abstraction.BluetoothReciever;
import io.github.prem_sh.designpattens.observerpattern.Abstraction.BluetoothTransmitter;
import io.github.prem_sh.designpattens.observerpattern.MasterDevices.DataObjects.SoundData;

public class HeadphoneBt extends BluetoothReciever {

    SoundData data;

    public HeadphoneBt(BluetoothTransmitter t) {
        watch(t);
    }

    @Override
    public void update(Object data) {
        try{
            this.data = (SoundData) data;
            System.out.println("[Headphones]"+this.data);
        }catch (ClassCastException e){}
    }
}
