package io.github.prem_sh.designpattens.observerpattern.MasterDevices.DataObjects;

public class MobileNotificationData extends DataObject {
    public MobileNotificationData(String info, String from) {
        this.type = "MobileNotificationData";
        this.information = info;
        this.from = from;
    }

    @Override
    public String toString() {
        return ("Type : " + type + " | Info : " + information + " | From : " + from);
    }
}
