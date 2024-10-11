package week_5;

interface USB_4{
    void readUSB();
    default void writeUSB() {
        System.out.println("Can`t write to USB");
    }
}

interface USBA_4 extends USB_4{
    void connectA();
}

interface USBC_4 extends USB_4 {
    void connectC();
}

class S22_4 implements USBC_4{

    private String name;

    S22_4(String name) {
        this.name = name;
    }

    @Override
    public void readUSB() {
        System.out.println(this.name + ": USB read");
    }

    @Override
    public void connectC() {
        System.out.println(this.name + ": USB-C connected");
    }

    @Override
    public void writeUSB() {
        System.out.println(this.name + ": USB write");
    }
}

class MP3_4 implements USBA_4{

    private String name;

    MP3_4(String name) {
        this.name = name;
    }
    @Override
    public void readUSB() {
        System.out.println(this.name + ": USB read");
    }

    @Override
    public void connectA() {
        System.out.println(this.name + ": USB-A connected");
    }
}

public class Lab05_4 {

    public static void connect(USB_4 u) {
        if (u instanceof USBA_4) {
            ((USBA_4) u).connectA();
        } else {
            ((USBC_4) u).connectC();
        }
    }

    public static void readUSB(USB_4 u) {
        u.readUSB();
    }

    public static void writeUSB(USB_4 u) {
        u.writeUSB();
    }

    public static void main(String[] args) {
        S22_4 s22 = new S22_4("S22");
        MP3_4 mp3 = new MP3_4("MP3");

        USB_4[] hub = new USB_4[]{s22, mp3};
        for (USB_4 u : hub) {
            connect(u);
            readUSB(u);
            writeUSB(u);
        }
    }
}
