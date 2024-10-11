package week_6.Lab06_1.device;

abstract public class Device {
    private String name;
    private int year;

    public Device(String name, int year) {
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