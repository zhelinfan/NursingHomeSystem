package entity;

public class PersonCheckIn extends Person
{
	private Member ContactMember;
	private Room LocationRoom;
	private String Location;
	private String Relationship;
	private String TimeOfEntering;
	private String TimeOfLeaving;
	private String TypeOfLiving;

		
	

	
	public PersonCheckIn(String name, String gender, String teleNum, String iDNum)
	{
		super(name, gender, teleNum, iDNum);
	}


	public PersonCheckIn(String name, String gender, String teleNum, String iDNum, Member contactMember,
			Room locationRoom, String location, String relationship, String timeOfEntering, String timeOfLeaving,
			String typeOfLiving)
	{
		super(name, gender, teleNum, iDNum);
		ContactMember = contactMember;
		LocationRoom = locationRoom;
		Location = Building.getinBuiHou1(locationRoom);
		Relationship = relationship;
		TimeOfEntering = timeOfEntering;
		TimeOfLeaving = timeOfLeaving;
		TypeOfLiving = typeOfLiving;
	}


	public void setLocation(Room room)
	{
		Location = Building.getinBuiHou1(room);
	}

	
	public String getLocation()
	{
		return Location;
	}


	// getter and setter of the contact member
	public Member getContactMember()
	{
		return ContactMember;
	}

	public void setContactMember(Member contactMember)
	{
		ContactMember = contactMember;
	}

	// getter and setter of the living location
	public Room getLocationRoom()
	{
		return LocationRoom;
	}

	public void setLocationRomm(Room locationRoom)
	{
		LocationRoom = locationRoom;
		setLocation(locationRoom);

	}

	// getter and setter of the relationship between contact member
	public String getRelationship()
	{
		return Relationship;
	}

	public void setRelationship(String relationship)
	{
		Relationship = relationship;
	}

	// getter and setter of the time of entering
	public String getTimeOfEntering()
	{
		return TimeOfEntering;
	}

	public void setTimeOfEntering(String timeOfEntering)
	{
		TimeOfEntering = timeOfEntering;
	}

	// getter and setter of the time of leaving
	public String getTimeOfLeaving()
	{
		return TimeOfLeaving;
	}

	public void setTimeOfLeaving(String timeOfLeaving)
	{
		TimeOfLeaving = timeOfLeaving;
	}

	// getter and setter of the type he or she lives
	public String getTypeOfLiving()
	{
		return TypeOfLiving;
	}

	public void setTypeOfLiving(String typeOfLiving)
	{
		TypeOfLiving = typeOfLiving;
	}

	@Override
	public String toString()
	{
		if(this.Location != null)
		{ 
			String[] arr = Location.split(" ");
			String s = arr[0]+arr[1]+arr[2];
			return getName()+" "+s+" "+getTeleNum();
		}
		else
			return "";
	}
	
	public String buiName()
	{
		if(this.Location != null)
		{ 
			String[] arr = Location.split(" ");
			return arr[0];
		}
		else
			return "";
	}
	
	public String houName()
	{
		if(this.Location != null)
		{ 
			String[] arr = Location.split(" ");
			return arr[1];
		}
		else
			return "";
	}
	

}
