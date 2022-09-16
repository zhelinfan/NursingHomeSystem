package entity;

import java.util.ArrayList;

import Management.BuildingManagement;

public class Building {
	ArrayList<House> listHouse = new ArrayList<House>();
	String BuildingName;
	
	public Building(String buildingName)
	{
		super();
		BuildingName = buildingName;
	}
    public void addHouse(House house)
    {
    	listHouse.add(house);
    }
    public void removeHouse(House house)
    {
    	listHouse.remove(house);
    }
    public House findHouse(String HouseNum)
    {
    	for(House house : listHouse)
    	{
    		if(house.getHouseNum().equals(HouseNum))
    		{
    			return house;
    		}
    	}
    	return null;
    }
	public ArrayList<House> getListHouse()
	{
		return listHouse;
	}

	public void setListHouse(ArrayList<House> listHouse)
	{
		this.listHouse = listHouse;
	}

	public String getBuildingName()
	{
		return BuildingName;
	}

	public void setBuildingName(String buildingName)
	{
		BuildingName = buildingName;
	}
	
	public int buildingLivNum()
	{
		int sum = 0;
		for(House house : listHouse)
    	{
    		sum += house.houseLivNum();
    	}
		return sum;
	}

	static public String getinBuiHou(Room tempRoom)
	{
		for(Building building : BuildingManagement.getBuildingManagement().getListBuilding())
		{
			for(House house : building.getListHouse())
			{
				for(Room room : house.getListRoom())
				{
					if(room == tempRoom)
						return building.getBuildingName()+house.getHouseNum()+room.getRoomNum();
					
				}
				
			}
		}
		return "";
	}
	
	static public String getinBuiHou1(Room tempRoom)
	{
		for(Building building : BuildingManagement.getBuildingManagement().getListBuilding())
		{
			for(House house : building.getListHouse())
			{
				for(Room room : house.getListRoom())
				{
					if(room == tempRoom)
						return building.getBuildingName()+" "+house.getHouseNum()+" "+room.getRoomNum();
					
				}
				
			}
		}
		return "";
	}

	static public String getinBui(Room tempRoom)
	{
		for(Building building : BuildingManagement.getBuildingManagement().getListBuilding())
		{
			
			for(House house : building.getListHouse())
			{
				for(Room room : house.getListRoom())
				{
					if(room == tempRoom)
					return building.getBuildingName();
				}
				
			}
		}
		return "";
	}
	
	static public String getinHou(Room tempRoom)
	{
		for(Building building : BuildingManagement.getBuildingManagement().getListBuilding())
		{
			for(House house : building.getListHouse())
			{
				for(Room room : house.getListRoom())
				{
					if(room == tempRoom)
					return house.getHouseNum();
				}
				
			}
		}
		return "";
	}
	
	static public boolean hasBought(int MemNum)
	{
		for(Building building : BuildingManagement.getBuildingManagement().getListBuilding())
		{
			for(House house : building.getListHouse())
			{
				for(Room room : house.getListRoom())
				{
					if(room.getMemNum() == MemNum)
					    return true;
				}
				
			}
		}
		return false;
	}
}
