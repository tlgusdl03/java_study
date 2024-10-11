package week_6.Lab06_1.device;

import week_6.Lab06_1.usb.USBC;

public class S22 extends Device implements USBC {

    private final String price;

    public S22(String name, int year) {
        super(name, year);
        this.price = "$1400";
    }

    @Override
    public void readUSB() {
        System.out.println(super.getName() + ": USB read");
    }

    @Override
    public void connectC() {
        System.out.println(super.getName()+ ": USB-C connected");
    }

    public String getPrice() {
        return this.price;
    }

    @Override
    public String getInfor() {
        return super.getName() + " " + super.getYear() + " " + getPrice();
    }

    @Override
    public void writeUSB() {
        System.out.println(super.getName() + ": USB write");
    }
}
