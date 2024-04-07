abstract class Device{
	private String name;
	private int year;
	
	Device(String name, int year){
		this.name = name; 
		this.year = year;
	}
	protected String getName() {
		return name;
	}
	protected int getYear() {
		return year;
	}
	public abstract String getInfor();
}

interface USB {
	void readUSB();
	default void writeUSB() {
		System.out.println("Can't write to USB");
	}
}

interface USBA extends USB{
	void connectA();
}

interface USBC extends USB{
	void connectC();
}

class S22 extends Device implements USBC {
	int price = 1400;
	public S22(String name, int year) {
		super(name, year);
	}
	@Override
	public String getInfor() {
		return super.getName() + " " + super.getYear()
		+ " $" + price;
	}
	@Override 
	public void readUSB() {
		System.out.println("S22: USB read");
	}
	@Override
	public void writeUSB() {
		System.out.println("S22: USB write");
	}
	@Override
	public void connectC() {
		System.out.println("S22: USB-C connected");
	}
}

class MP3 extends Device implements USBA{
	int price = 120;
	public MP3(String name, int year) {
		super(name, year);
	}
	@Override
	public String getInfor() {
		return super.getName() + " " + super.getYear()
		+ " $" + price;
	}
	@Override 
	public void readUSB() {
		System.out.println("MP3: USB read");
	}
	@Override
	public void connectA() {
		System.out.println("MP3: USB-A connected");
	}
}

class TV extends Device{
	int price = 5000;
	public TV(String name, int year) {
		super(name, year);
	}
	@Override
	public String getInfor() {
		return super.getName() + " " + super.getYear()
				+ " $" + price;
	}
}

class USBhub {
	USB[] u = new USB[2];
	
	public void addDevice(USB d) {
		if(d instanceof S22) {
			USBC dc = (USBC)d;
			dc.connectC();
			u[0] = d;
		}
		else if(d instanceof MP3) {
			USBA da = (USBA)d;
			da.connectA();
			u[1] = d;
		}
	}// connect
	public void readUSBs() {
		u[0].readUSB();
		u[1].readUSB();
		System.out.println();
	}// read
	public void writeUSBs() {
		u[0].writeUSB();
		u[1].writeUSB();
	}// write
	
}

public class P_05 {
	public static void printInfor(Device d) {
		System.out.println(d.getInfor());
	}
	public static void main(String[] args) {
		S22 s22 = new S22("S22", 2022);
		MP3 mp3 = new MP3("MP3", 2005);
		TV tv = new TV("TV", 2017);
		
		Device[] devices = new Device[] {s22, mp3, tv};
		USBhub hub = new USBhub();
		
		for(Device d : devices) {
			printInfor(d);
			if(d instanceof USB) {
				hub.addDevice((USB)d);
			}
		}
		
		System.out.println();
		hub.readUSBs();
		hub.writeUSBs();
	}

}
