package week_6.Lab06_1.device;

public class TV extends Device {

    private final String price;

    public TV(String name, int year){
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