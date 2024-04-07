class Device_2{
	private String name;
	private int year;
	
	Device_2(String name, int year){
		this.name = name; this.year = year;
	}
	public String getInfor() {
		return name + " " + year;
	}
}

class S22_2 extends Device_2{
	String price = "$1400";
	public S22_2(String name, int year) {
		super(name, year);
	}
	@Override
	public String getInfor() {
		return super.getInfor() + " " + price;
	}
}

class MP3_2 extends Device_2{
	String price = "$120";
	public MP3_2(String name, int year) {
		super(name, year);
	}
	@Override
	public String getInfor() {
		return super.getInfor() + " " + price;
	}
}

class TV_2 extends Device_2{
	String price = "$5000";
	public TV_2(String name, int year) {
		super(name, year);
	}
	@Override
	public String getInfor() {
		return super.getInfor() + " " + price;
	}
}

public class P_02 {
	public static void printInfor(Device_2 d){
		System.out.println(d.getInfor());
	}
	public static void main(String[] args) {
		Device_2 device[] = new Device_2[3];
		
		S22_2 s22 = new S22_2("S22", 2022);
		MP3_2 mp3 = new MP3_2("MP3", 2005);
		TV_2 tv = new TV_2("TV", 2017);
		
		device[0] = s22;
		device[1] = mp3;
		device[2] = tv;
		
		printInfor(device[0]);
		printInfor(device[1]);
		printInfor(device[2]);
		
	}

}
