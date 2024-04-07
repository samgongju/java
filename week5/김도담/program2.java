// program 2

class Device_2 {
	private String name;
	private int year;

	Device_2(String name, int year) {
		this.name = name;
		this.year = year;
	}

	public String getInfor() {
		return name + " " + year;
	}
}

class S22_2 extends Device_2 {
	S22_2(String name, int year) {
		super(name, year);
	}

	@Override
	public String getInfor() {
		return super.getInfor() + " $1400";
	}
}

class MP3_2 extends Device_2 {
	MP3_2(String name, int year) {
		super(name, year);
	}

	@Override
	public String getInfor() {
		return super.getInfor() + " $120";
	}
}

class TV_2 extends Device_2 {
	TV_2(String name, int year) {
		super(name, year);
	}

	@Override
	public String getInfor() {
		return super.getInfor() + " $5000";
	}
}

public class program2 {

	public static void printInfor(Device_2 d) {
		System.out.println(d.getInfor());
	}

	public static void main(String[] args) {
		S22_2 s22 = new S22_2("S22", 2022);
		MP3_2 mp3 = new MP3_2("MP3", 2005);
		TV_2 tv = new TV_2("TV", 2017);

		Device_2 d[] = new Device_2[] { s22, mp3, tv };

		for (Device_2 i : d) {
			printInfor(i);
		}
	}

}
