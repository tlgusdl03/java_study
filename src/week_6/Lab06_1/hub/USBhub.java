package week_6.Lab06_1.hub;


import week_6.Lab06_1.usb.USB;
import week_6.Lab06_1.usb.USBA;
import week_6.Lab06_1.usb.USBC;

public class USBhub {

    private USB[] USBs;
    private int index;

    public USBhub(){
        this.USBs = new USB[2];
        this.index = 0;
    }

    public void addDevice(USB usb){
        USBs[index] = usb;
        this.index++;
        if (usb instanceof USBA) {
            ((USBA) usb).connectA();
        } else {
            ((USBC) usb).connectC();
        }
    }

    public void readUSBs() {
        for(USB usb : USBs){
            usb.readUSB();
        }
        System.out.println();
    }

    public void writeUSBs() {
        for(USB usb : USBs){
            usb.writeUSB();
        }
        System.out.println();
    }
}