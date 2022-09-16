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

public class BuildingManagement implements Iterable<Building>
{
	static private BuildingManagement singleton;
	static private ArrayList<Building> listBuilding = new ArrayList<Building>();
	
	//单态模式
	private BuildingManagement()
	{
		
	}
	
	static public BuildingManagement getBuildingManagement()
	{
		if(singleton == null)
			singleton = new BuildingManagement();
		return singleton;
	}
	
	//查找
	public Building findBuilding(String buildingName)
	{
		for(Building building : listBuilding)
		{
			if(building.getBuildingName().equals(buildingName))
				return building;
		}
		return null;
	}
	//增加
	public boolean addBuilding(Building building)
	{
		if(findBuilding(building.getBuildingName()) == null)
			{
			  listBuilding.add(building);
			  return true;
			}
		return false;
	}
	//删除
	public boolean removeBuilding(Building building)
	{
		if(findBuilding(building.getBuildingName()) != null)
			{
			  listBuilding.remove(building);
			  return true;
			}
		return false;
	}
	
	@Override
	public Iterator<Building> iterator()
	{
		// TODO Auto-generated method stub
		return listBuilding.iterator();
	}
	public ArrayList<Building> getListBuilding()
	{
		return listBuilding;
	}
	public void load() 
	{
		listBuilding.clear();
		String jsonStr = null;
		try {
			jsonStr = new String(
					Files.readAllBytes(FileSystems.getDefault().getPath(".", BuildingManagement.class.getSimpleName() + ".json")),
					"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (jsonStr != null) {
			Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd").create();
			listBuilding.addAll(gson.fromJson(jsonStr, new TypeToken<List<Building>>() {
			}.getType()));
		}
//		System.out.println(listBuilding.toString());
	}
	
	public void save() {
		Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd").create();
		String jsonStr = gson.toJson(listBuilding);
		System.out.println(jsonStr);
		try {
			
			Files.write(FileSystems.getDefault().getPath(".", BuildingManagement.class.getSimpleName() + ".json"),
					jsonStr.getBytes(Charset.forName("utf-8")), StandardOpenOption.CREATE);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void delete()
	{
		try
		{
			Files.delete(FileSystems.getDefault().getPath(".", BuildingManagement.class.getSimpleName() + ".json"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
