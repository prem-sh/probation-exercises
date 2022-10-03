package io.github.prem_sh.designpattens.observerpattern.MasterDevices.DataObjects;

public class MouseData extends DataObject {
    public MouseData(String info, String from) {
        this.type = "MouseData";
        this.information = info;
        this.from = from;
    }

    @Override
    public String toString() {
        return ("Type : "+type+" | Info : "+information+" | From : "+from);
    }
}
