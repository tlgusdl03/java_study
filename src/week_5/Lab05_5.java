package week_5;

interface USB{
    void readUSB();
    default void writeUSB() {
        System.out.println("Can`t write to USB");
    }
}

interface USBA extends USB{
    void connectA();
}

interface USBC extends USB {
    void connectC();
}

abstract class Device {
    private String name;
    private int year;

    Device(String name, int year) {
        this.name = name; this.year = year;
    }

    protected String getName() {
        return name;
    }

    protected int getYear() {
        return year;
    }

    public abstract String getInfor();
}

class S22 extends Device implements USBC{

    private final String price;

    S22(String name, int year) {
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

class MP3 extends Device implements USBA {

    private final String price;

    MP3(String name, int year) {
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

class TV extends Device {

    private final String price;

    TV(String name, int year){
        super(name, year);
        this.price = "$5000";
    }

    public String getPrice() {
        return this.price;
    }

    @Override
    public String getInfor() {
        return super.getName() + " " + super.getYear() + " " + getPrice();
    }
}

class USBhub {

    private USB[] USBs;
    private int index;

    USBhub(){
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
public class Lab05_5 {

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
