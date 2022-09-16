package entity;

import java.util.ArrayList;

public class House {
	ArrayList<Room> listRoom = new ArrayList<Room>();
	String HouseNum;
	
	public House(String houseNum)
	{
		HouseNum = houseNum;
	}
	public void addRoom(Room room)
	{
		listRoom.add(room);
	}
	 
    public void removeRoom(Room room)
    {
    	listRoom.remove(room);
    }
    public Room findRoom(String RoomNum)
    {
    	for(Room room : listRoom)
    	{
    		if(room.getRoomNum().equals(RoomNum))
    		{
    			return room;
    		}
    	}
    	return null;
    }
	public ArrayList<Room> getListRoom()
	{
		return listRoom;
	}

	public void setListHouse(ArrayList<Room> listHouse)
	{
		this.listRoom = listHouse;
	}

	public String getHouseNum()
	{
		return HouseNum;
	}

	public void setHouseNum(String houseNum)
	{
		HouseNum = houseNum;
	}
	
	public int houseLivNum()
	{
		int sum = 0;
		for(Room room : listRoom)
    	{
			sum += room.getLivPerNum();
    	}
		return sum;
	}
	
}
