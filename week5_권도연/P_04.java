interface USB_4{
	void readUSB();
	default void writeUSB() {
		System.out.println("Can't write to USB");
	}

}
interface USBA_4 extends USB_4{
	void connectA();
}
interface USBC_4 extends USB_4{
	void connectC();
}

class S22_4 implements USBC_4{
	String device;
	public S22_4(String device) {
		this.device=device;
	}
	@Override 
	public void readUSB() {
		System.out.println("S22: USB read");
	}
	@Override
	public void connectC() {
		System.out.println("S22: USB-C connected");
	}
	@Override
	public void writeUSB() {
		System.out.println("S22: USB write");
	}
}

class MP3_4 implements USBA_4{
	String device;
	public MP3_4(String device) {
		this.device=device;
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
public class P_04 {
	public static void connect(USB_4 u) {
		if(u instanceof S22_4) {
			USBC_4 uc = (USBC_4)u;
			uc.connectC();
		}
		else if(u instanceof MP3_4) {
			USBA_4 ua = (USBA_4)u;
			ua.connectA();
		}
	}
	public static void readUSB(USB_4 u) {
		if(u instanceof S22_4) {
			USBC_4 uc = (USBC_4)u;
			uc.readUSB();
		}
		else if(u instanceof MP3_4) {
			USBA_4 ua = (USBA_4)u;
			ua.readUSB();
		}
	}
	public static void writeUSB(USB_4 u) {
		if(u instanceof S22_4) {
			USBC_4 uc = (USBC_4)u;
			uc.writeUSB();
		}
		else if(u instanceof MP3_4) {
			USBA_4 ua = (USBA_4)u;
			ua.writeUSB();
		}
	}
	public static void main(String[] args) {
		S22_4 s22 = new S22_4("S22");
		MP3_4 mp3 = new MP3_4("MP3");
		
		USB_4[] hub = new USB_4[] {s22, mp3};
		for(USB_4 u : hub) {
			connect(u);
			readUSB(u);
			writeUSB(u);
		}

	}

}
