package week_6.Lab06_1.hub;

import week_6.Lab06_1.device.Device;
import week_6.Lab06_1.device.MP3;
import week_6.Lab06_1.device.S22;
import week_6.Lab06_1.device.TV;
import week_6.Lab06_1.usb.USB;

public class Lab06_1 {
    public static void printInfor(Device device) {
        System.out.println(device.getInfor());
    }

    public static void main(String[] args) {
        S22 s22 = new S22("S22", 2022);
        MP3 mp3 = new MP3("MP3", 2005);
        TV tv = new TV("TV", 2017);

        Device[] devices = new Device[]{s22, mp3, tv};
        USBhub hub = new USBhub();

        for (Device d : devices) {
            printInfor(d);
            if (d instanceof USB)
                hub.addDevice((USB)d);
        }

        System.out.println();
        hub.readUSBs();
        hub.writeUSBs();
    }
}
