package io.github.prem_sh.designpattens.observerpattern.MasterDevices.DataObjects;

public class SoundData extends DataObject {
    public SoundData(String info, String from) {
        this.type = "SoundData";
        this.information = info;
        this.from = from;
    }

    @Override
    public String toString() {
        return ("Type : " + type + " | Info : " + information + " | From : " + from);
    }
}
