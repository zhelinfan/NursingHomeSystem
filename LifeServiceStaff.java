package entity;

public class LifeServiceStaff extends ServiceStaff{
	private PersonCheckIn personCheckIn;
    
	
	public LifeServiceStaff(String name, String gender, String teleNum, String iDNum, int account,String passwordNum,
			PersonCheckIn personCheckIn) {	
		super(name, gender, teleNum, iDNum, account,passwordNum,"生活管家： "+personCheckIn.toString());

		this.personCheckIn = personCheckIn;
	}

	public PersonCheckIn getPersonCheckIn()
	{
		return personCheckIn;
	}

	public void setPersonCheckIn(PersonCheckIn personCheckIn)
	{
		this.personCheckIn = personCheckIn;
		 setPermission("生活管家： "+personCheckIn.toString());
		
	}

//	public String getPermission() {
		
		//getPermission() = "服务"+personCheckIn.toString();
//		return "生活管家："+personCheckIn.toString();
//	}
	
}
