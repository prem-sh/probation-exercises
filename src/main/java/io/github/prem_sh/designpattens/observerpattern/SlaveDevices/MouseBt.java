package io.github.prem_sh.designpattens.observerpattern.SlaveDevices;


import io.github.prem_sh.designpattens.observerpattern.Abstraction.BluetoothReciever;
import io.github.prem_sh.designpattens.observerpattern.Abstraction.BluetoothTransmitter;
import io.github.prem_sh.designpattens.observerpattern.MasterDevices.DataObjects.MouseData;

public class MouseBt extends BluetoothReciever {
    MouseData data ;

    public MouseBt(BluetoothTransmitter t) {
        watch(t);
    }

    @Override
    public void update(Object data) {
        try{
            this.data = (MouseData) data;
            System.out.println("[Mouse]"+this.data);
        }catch (ClassCastException e){}
    }
}
