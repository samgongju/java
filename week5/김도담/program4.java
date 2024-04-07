// program 4

interface USB_4 {
	public abstract void readUSB();

	public default void writeUSB() {
		System.out.println("Can't write to USB");
	}
}

interface USBA_4 extends USB_4 {
	public void connectA();
}

interface USBC_4 extends USB_4 {
	public void connectC();
}

class S22_4 implements USBC_4 {  // read, write
	private String name;

	S22_4(String name) {
		this.name = name;
	}
	
	@Override
	public void readUSB() {
		System.out.println(name + ": USB read");
	}
	
	@Override
	public void writeUSB() {
		System.out.println(name + ": USB write");
	}
	
	@Override
	public void connectC() {
		System.out.println(name + ": USB-C connected");
	}
}

class MP3_4 implements USBA_4 {  // read
	private String name;

	MP3_4(String name) {
		this.name = name;
	}
	
	@Override
	public void readUSB() {
		System.out.println(name + ": USB read");
	}
	
	@Override
	public void connectA() {
		System.out.println(name + ": USB-A connected");
	}
}

public class program4 {

	public static void connect(USB_4 u) {
		if(u instanceof S22_4) {
			((S22_4)u).connectC();
		}
		else if( u instanceof MP3_4) {
			((MP3_4)u).connectA();
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

		USB_4[] hub = new USB_4[] { s22, mp3 };
		for (USB_4 u : hub) {
			connect(u);
			readUSB(u);
			writeUSB(u);
		}
	}

}
