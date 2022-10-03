package io.github.prem_sh.designpattens.observerpattern.MasterDevices.DataObjects;

public class KeyboardData extends DataObject {
    public KeyboardData(String info, String from) {
        this.type = "KeyboardData";
        this.information = info;
        this.from = from;
    }

    @Override
    public String toString() {
        return ("Type : " + type + " | Info : " + information + " | From : " + from);
    }
}
