package io.github.prem_sh.designpattens.observerpattern.Abstraction;

import java.util.LinkedList;
import java.util.List;

public abstract class BluetoothReciever {
    List<BluetoothTransmitter> transmitters = new LinkedList<>();

    public void watch(BluetoothTransmitter transmitter){
        transmitter.subscribe(this);
        if(!transmitters.contains(transmitter)) transmitters.add(transmitter);
    }
    public void unWatch(BluetoothTransmitter transmitter){
        transmitter.unsubscribe(this);
        transmitters.remove(transmitter);
    }

    abstract public void update(Object data);
}

