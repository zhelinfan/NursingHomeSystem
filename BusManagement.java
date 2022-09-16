package Management;

import java.util.ArrayList;
import java.util.Iterator;

import entity.Bus;

public class BusManagement implements Iterable<Bus>
{
	static private BusManagement singleton;
	static private ArrayList<Bus> listBus = new ArrayList<Bus>();
	
	private BusManagement()
	{
		
	}
	
	static public BusManagement getBusManagement()
	{
		if(singleton == null)
			singleton = new BusManagement();
		return singleton;
	}
	
	public Bus findBus(String BusNum)
	{
		for(Bus bus : listBus)
		{
			if(bus.getBusNum().equals(BusNum))
				return bus;
		}
		return null;
	}
	public void addBus(Bus bus)
	{
		listBus.add(bus);
	}
	public void removeBus(Bus bus)
	{
		listBus.remove(bus);
	}
	@Override
	public Iterator<Bus> iterator()
	{
		return listBus.iterator();
	}
}
