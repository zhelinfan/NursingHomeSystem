package entity;

public class LogisticsServiceStaff extends ServiceStaff{

	private Bus bus;
	public LogisticsServiceStaff(String name, String gender, String teleNum, String iDNum, int account,String passwordNum
			,Bus bus) {
		super(name, gender, teleNum, iDNum,account, passwordNum,"后勤管家： "+bus.toString());
		this.bus = bus;
	}
	
   
	public Bus getBus()
	{
		return bus;
	}

	public void setBus(Bus bus)
	{
		this.bus = bus;
		setPermission("后勤管家： "+bus.toString());
	}
	
}
