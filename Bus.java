package entity;

public class Bus
{
	String BusNum;

	public Bus(String busNum)
	{
		super();
		BusNum = busNum;
	}

	public String getBusNum()
	{
		return BusNum;
	}

	public void setBusNum(String busNum)
	{
		BusNum = busNum;
	}

	@Override
	public String toString()
	{
		return getBusNum();
	}
	
	
	
}
