package io.github.prem_sh.designpattens.observerpattern;

import io.github.prem_sh.designpattens.observerpattern.MasterDevices.DataObjects.KeyboardData;
import io.github.prem_sh.designpattens.observerpattern.MasterDevices.DataObjects.MouseData;
import io.github.prem_sh.designpattens.observerpattern.MasterDevices.DataObjects.SoundData;
import io.github.prem_sh.designpattens.observerpattern.SlaveDevices.*;
import io.github.prem_sh.designpattens.observerpattern.MasterDevices.Laptop;
import io.github.prem_sh.designpattens.observerpattern.MasterDevices.MobilePhone;

public class Driver {

    public static void main(String[] args) {
        //Masters
        Laptop myLap = new Laptop();
        MobilePhone myMob = new MobilePhone();

        //Slaves
        MouseBt hpmouse = new MouseBt(myLap);
        KeyboardBt zebKb = new KeyboardBt(myLap);
        SoundSystemBt sony = new SoundSystemBt(myLap);
        SmartWatchBt iWatch = new SmartWatchBt(myMob);
        HeadphoneBt boat = new HeadphoneBt(myMob);

        System.out.println(myLap.observers);
        System.out.println(myMob.observers);

        //Simple Mouse keyboard test
        System.out.println("=== Test Mouse, keyboard with laptop ===");
        myLap.updateData(new MouseData("SCROLL up","myLap"));
        myLap.updateData(new MouseData("SCROLL down","myLap"));
        myLap.updateData(new KeyboardData("down ctrl","myLap"));
        myLap.updateData(new KeyboardData("down F4","myLap"));
        System.out.println();
        //Listening two Transmitters SoundSystem
        System.out.println("=== Test SoundSystem ===");
        System.out.println("--- only watching laptop");
        myLap.updateData(new SoundData("Bangl..Bangl!!", "Laptop"));
        myMob.updateData(new SoundData("Bangm..Bangm!!", "Mobile"));
        System.out.println();
        System.out.println("--- also watching mobile");
        sony.watch(myMob);
        myLap.updateData(new SoundData("Bang2l..Bang2l!!", "Laptop"));
        myMob.updateData(new SoundData("Bang2m..Bang2m!!", "Mobile"));
        System.out.println();
        System.out.println("--- only watching mobile");
        sony.unWatch(myLap);
        myLap.updateData(new SoundData("Bang3l..Bang3l!!", "Laptop"));
        myMob.updateData(new SoundData("Bang3m..Bang3m!!", "Mobile"));

    }
}
