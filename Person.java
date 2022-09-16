package entity;

public class Person {
	private String Name;
	private String Gender;
	private String TeleNum;
	private	String IDNum;
	
	public Person(String name, String gender, String teleNum, String iDNum) {
		Name = name;
		Gender = gender;
		TeleNum = teleNum;
		IDNum = iDNum;
	}
	//getter and setter of name
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	//getter and setter of gender
	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}
	
	//getter and setter of telephone number
	public String getTeleNum() {
		return TeleNum;
	}

	public void setTeleNum(String teleNum) {
		TeleNum = teleNum;
	}
	
	//getter and setter of ID number
	public String getIDNum() {
		return IDNum;
	}

	public void setIDNum(String iDNum) {
		IDNum = iDNum;
	}
	@Override
	public String toString() {
		return "Person [Name=" + Name + ", Gender=" + Gender + ", TeleNum=" + TeleNum + ", IDNum=" + IDNum + "]";
	}

		
}
