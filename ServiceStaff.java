package entity;

public class ServiceStaff extends Person{
	private int Account;
	private String Password;
	private String Permission;
	//private LoginPage loginPage = LoginPage.getLogingPage();
	
	public ServiceStaff(String name, String gender, String teleNum, String iDNum, int account,String password,
			String permission) {
		super(name, gender, teleNum, iDNum);
		Account = account;
		Password = password;
		Permission = permission;
	}

	//getter and setter of account
	public int getAccount() {
		return Account;
	}


	public void setAccount(int account) {
		Account = account;
	}


	//getter and setter of password
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	//getter and setter of permission
	public String getPermission() {
		return Permission;
	}

	public void setPermission(String permission) {
		Permission = permission;
	}
	
	
}
