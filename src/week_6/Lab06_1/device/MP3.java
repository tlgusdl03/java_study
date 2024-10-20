package week_6.Lab06_1.device;

import week_6.Lab06_1.usb.USBA;

public class MP3 extends Device implements USBA {

    private final String price;

    public MP3(String name, int year) {
        super(name, year);
        this.price = "$120";
    }

    @Override
    public void readUSB() {
        System.out.println(super.getName()+ ": USB read");
    }

    @Override
    public void connectA() {
        System.out.println(super.getName()+ ": USB-A connected");
    }

    public String getPrice() {
        return this.price;
    }

    @Override
    public String getInfor() {
        return super.getName() + " " + super.getYear() + " " + getPrice();
    }
}
