package io.github.prem_sh.designpattens.observerpattern.Abstraction;

import java.util.LinkedList;
import java.util.List;

public abstract class BluetoothTransmitter  {
    public List<BluetoothReciever> observers = new LinkedList<>();
    Object data;

    private void broadcast(){
        for (BluetoothReciever rec: observers) {
            rec.update(data);
        }
    }
    public void subscribe(BluetoothReciever receiver){
        if(!observers.contains(receiver)) observers.add(receiver);
    }
    public void unsubscribe(BluetoothReciever receiver){
        observers.remove(receiver);
    }
    public void updateData(Object data){
        this.data = data;
        broadcast();
    }
}
