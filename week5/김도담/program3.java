// program 3

import java.util.Scanner;

abstract class Stack {
	public abstract int length();
	public abstract int capacity();
	public abstract String pop();
	public abstract boolean push(String str);
}

class StringStack extends Stack {
	String[] arr;
	int tos;
	int sz;

	StringStack(int sz) {
		tos = -1;
		this.sz = sz;
		arr = new String[this.sz];
	}

	public int length() {
		return tos;
	}

	public int capacity() {
		return sz;
	}

	public String pop() {
		if (tos == -1) {
			return "null";
		}
		tos--;
		return arr[tos + 1];
	}

	public boolean push(String str) {
		if (tos + 1 == capacity()) {
			return false;
		}
		tos++;
		arr[tos] = str;
		return true;
	}
}

public class program3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		System.out.print("size of stack: ");
		int sz = s.nextInt();

		int n = 0;
		StringStack ss = new StringStack(sz);
		do {
			System.out.print("input: ");
			String a = s.next();
			
			if (a.equals("exit")) {
				break;
			}

			if (!ss.push(a)) {
				System.out.println("stack is full!");
			}
			else {
				n++;
			}
		} while (true);

		System.out.print("pop all strings: ");
		if (n == 0) {
			System.out.println(ss.pop());
		} else {
			for (int i = 0; i < n; i++) {
				System.out.print(ss.pop() + " ");
			}
		}
		s.close();
	}

}
