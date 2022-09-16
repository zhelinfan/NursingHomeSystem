package entity;

import Management.LivingManagement;

public class Room {
	String RoomNum;
	String TypeOfRoom;
	String Conditon;
	int memNum;
	int LivPerNum;
	String sellNum;

	
	public Room(String roomNum, String typeOfRoom, String conditon, int memNum, int livPerNum, String sellNum)
	{
		super();
		RoomNum = roomNum;
		TypeOfRoom = typeOfRoom;
		Conditon = conditon;
		this.memNum = memNum;
		LivPerNum = livPerNum;
		this.sellNum = sellNum;
	}


	public String getRoomNum()
	{
		return RoomNum;
	}

	public void setRoomNum(String roomNum)
	{
		RoomNum = roomNum;
	}

	public String getTypeOfRoom()
	{
		return TypeOfRoom;
	}

	public void setTypeOfRoom(String typeOfRoom)
	{
		TypeOfRoom = typeOfRoom;
	}

	public String getConditon()
	{
		return Conditon;
	}

	public void setConditon(String condition)
	{
		Conditon = condition;
	}
	
	public String decide(PersonCheckIn personCheckIn)
	{
		int liv = 0;
		int zu = 0;
		
		for(PersonCheckIn pci : LivingManagement.getLivingManagement().getlistPersonCheckIn())
		 {
			 if(pci.getLocation().equals(personCheckIn.getLocation()))
			 {
				 if(pci.getTypeOfLiving().equals("租住"))
				 {
					 zu ++;
				 }
				 if(pci.getTypeOfLiving().equals("入住"))
				 {
					 liv ++;
				 }
			 }
			 System.out.println(pci.getTypeOfLiving());
			 System.out.println(liv  +"  "+ zu);
		 }
		
		if(liv == 0 && zu == 0)
			return "空置";
		else if(liv == 0 && zu != 0)
			return "出租";
		else if(liv != 0 && zu == 0)
			return "入住";
		else
			return "入住且出租";
						
	}
	public int getLivPerNum()
	{
		return LivPerNum;
	}

	public void setLivPerNum(int livPerNum)
	{
		LivPerNum = livPerNum;
	}


	public int getMemNum()
	{
		return memNum;
	}


	public void setMemNum(int memNum)
	{
		this.memNum = memNum;
	}


	public String getSellNum()
	{
		return sellNum;
	}


	public void setSellNum(String sellNum)
	{
		this.sellNum = sellNum;
	}
	 
    
	
}
