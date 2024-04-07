import java.util.Scanner;
abstract class Stack{
	protected int length;
	protected int capacity;
	public abstract int length();
	public abstract int capacity();
	public abstract String pop();
	public abstract boolean push(String str);
}

class StringStack extends Stack{
	int tos = -1;
	String[] arr;
	
	public StringStack(int capacity) {
		super.length = 0;
		super.capacity = capacity;
		arr = new String[capacity];
	}
	
	@Override
	public int length() {
		return super.length;
	}
	@Override
	public int capacity() {
		return super.capacity;
	}
	@Override
	public String pop() {
		if(tos == -1) {
			return null;
		}
		else {
			int topIndex = tos;
			--tos;
			--super.length;
			return arr[topIndex];
		}
	}
	@Override
	public boolean push(String str) {
		if(length()==capacity()) {
			return false;			
		}
		arr [++tos] = str;
		++super.length;
		return true;
		
	}
	
}
public class P_03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("size of stack: ");
		int capacity = scanner.nextInt();
		StringStack s = new StringStack(capacity);
		
		System.out.print("input: ");
		String str = scanner.next();
		
		while(!str.equals("exit")) {
			if(!s.push(str)) {
				System.out.println("stack is full!");
			}
			System.out.print("input: ");
			str = scanner.next();
		}
		
		int len = s.length();
		System.out.print("pop all strings: ");
		for(int i=0; i<len; ++i) {
			System.out.print(s.pop() + " ");
		}
		scanner.close();
	}

}
