// program 1

class People{
	private String name;
	private String residentNum;
	
	People(String name, String residentNum){
		this.name = name;
		this.residentNum = residentNum;
	}
	
	String getNameP() {
		return name;
	}
	
	String getSsnP() {
		return residentNum;
	}
}

class Student extends People{
	private int studentNum;
	
	Student (String name, String residentNum, int studentNum){
		super(name, residentNum);
		this.studentNum= studentNum;
	}
	
	String getName() {
		return getNameP();
	}
	
	String getSsn() {
		return getSsnP();
	}
	
	int getID() {
		return studentNum;
	}
	
}

public class program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student ("dlwlrma", "930516-2xxxxxx", 12231234);
		
		System.out.println("name: " + s.getName());
		System.out.println("ssn: " + s.getSsn());
		System.out.println("name: " + s.getID());
	}

}
