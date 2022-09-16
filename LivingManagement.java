package Management;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import entity.Building;
import entity.Member;
import entity.PersonCheckIn;
import entity.Room;

public class LivingManagement implements Iterable<PersonCheckIn>
{
	static private LivingManagement singleton;
	static private ArrayList<PersonCheckIn> listPersonChenkIn = new ArrayList<PersonCheckIn>();
	
	//µ¥Ì¬Ä£Ê½
	private LivingManagement()
	{
		
	}
	
	static public LivingManagement getLivingManagement()
	{
		if(singleton == null)
			singleton = new LivingManagement();
		return singleton;
	}
	//find
	public PersonCheckIn findPersonCheckIn(String PersonCheckInName,Member ContactMember)
	{
		for(PersonCheckIn personCheckIn : listPersonChenkIn)
		{
			if(personCheckIn.getName().equals(PersonCheckInName) 
			  && personCheckIn.getContactMember().equals(ContactMember))
				
				return personCheckIn;
		}
		return null;
	}
	
	public PersonCheckIn findPersonCheckIn1(String TeleNum)
	{
		for(PersonCheckIn personCheckIn : listPersonChenkIn)
		{
			if(  personCheckIn.getTeleNum().equals(TeleNum))
//				personCheckIn.getName().equals(PersonCheckInName)
				return personCheckIn;
		}
		return null;
	}
	public PersonCheckIn findPersonCheckIn1(Room room)
	{
		for(PersonCheckIn personCheckIn : listPersonChenkIn)
		{
			if(personCheckIn.getLocation().equals(Building.getinBuiHou1(room)))
				
				return personCheckIn;
		}
		return null;
	}
	public PersonCheckIn findPersonCheckIn2(String PCIName,String Location)
	{
		for(PersonCheckIn personCheckIn : listPersonChenkIn)
		{
			if(personCheckIn.getLocation().equals(Location)
				&& personCheckIn.getName().equals(PCIName))				
				return personCheckIn;
		}
		return null;
	}
	
	//add
	public void addPersonCheckIn(PersonCheckIn personCheckIn)
	{
			listPersonChenkIn.add(personCheckIn);
	}
	//remove
	public void removePersonCheckIn(PersonCheckIn personCheckIn)
	{
		
				listPersonChenkIn.remove(personCheckIn);

	}
	
	//change
	public void changeMem(Member member)
	{
		for(PersonCheckIn personCheckIn : listPersonChenkIn)
		{
			if(personCheckIn.getContactMember().getMemNum() == member.getMemNum())			
				personCheckIn.setContactMember(member);
		}
	}
	
	public ArrayList<PersonCheckIn> getlistPersonCheckIn()
	{
		return listPersonChenkIn;
	}
	@Override
	public Iterator<PersonCheckIn> iterator()
	{
		
		return listPersonChenkIn.iterator();
	}
	
	public void load() 
	{
		listPersonChenkIn.clear();
		String jsonStr = null;
		try {
			jsonStr = new String(
					Files.readAllBytes(FileSystems.getDefault().getPath(".", LivingManagement.class.getSimpleName() + ".json")),
					"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (jsonStr != null) {
			Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd").create();
			listPersonChenkIn.addAll(gson.fromJson(jsonStr, new TypeToken<List<PersonCheckIn>>() {
			}.getType()));
		}
		//System.out.println(listBuilding.toString());
	}
	
	public void save() {
		Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd").create();
		String jsonStr = gson.toJson(listPersonChenkIn);
		System.out.println(jsonStr);
		try {
			
			Files.write(FileSystems.getDefault().getPath(".", LivingManagement.class.getSimpleName() + ".json"),
					jsonStr.getBytes(Charset.forName("utf-8")), StandardOpenOption.CREATE);
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void delete()
	{
		try
		{
			Files.delete(FileSystems.getDefault().getPath(".", LivingManagement.class.getSimpleName() + ".json"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
