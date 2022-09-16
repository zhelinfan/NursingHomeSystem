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

import entity.LifeServiceStaff;
import entity.PersonCheckIn;
import entity.ServiceStaff;

public class ServiceStaffManagement implements Iterable<ServiceStaff>{
	static private ServiceStaffManagement singleton;
	static private ArrayList<ServiceStaff> listServiceStaff = new ArrayList<ServiceStaff>();
	
	//单态模式
	private ServiceStaffManagement()
	{
		
	}
	static public ServiceStaffManagement getServiceStaffManagement()
	{
		if(singleton == null)
			singleton = new ServiceStaffManagement();
		return singleton;
	}
	//查找该员工是否存在
	public static ServiceStaff findServiceStaff1(int Account,String Password)
	{
		for(ServiceStaff serviceStaff : listServiceStaff)
		{
			if(serviceStaff.getAccount() == Account && Password.equals(serviceStaff.getPassword()))
				return serviceStaff;
		}
		return null;
	}

	public ServiceStaff findServiceStaff2(String IDNum)
	{
		for(ServiceStaff serviceStaff : listServiceStaff)
		{
			if(IDNum.equals(serviceStaff.getIDNum()))
				return serviceStaff;
		}
		return null;
	}
	public ServiceStaff findServiceStaff3(String permission)
	{
		for(ServiceStaff serviceStaff : listServiceStaff)
		{
			if(serviceStaff.getPermission().equals(permission))
				return serviceStaff;
		}
		return null;
	}
	public ServiceStaff findServiceStaff4(String TeleNum)
	{
		for(ServiceStaff serviceStaff : listServiceStaff)
		{
			if(serviceStaff.getTeleNum().equals(TeleNum))
				return serviceStaff;
		}
		return null;
	}
	public ServiceStaff findServiceStaff5(int Account)
	{
		for(ServiceStaff serviceStaff : listServiceStaff)
		{
			if(serviceStaff.getAccount() == Account)
				return serviceStaff;
		}
		return null;
	}
	//新添加员工
	public void addServiceStaff(ServiceStaff serviceStaff)
	{
//		if(findServiceStaff2(serviceStaff.getAccount(),serviceStaff.getIDNum()) == null)
//		{
			listServiceStaff.add(serviceStaff);
//			return true;
//		}
//		return false;
	}
	//删除员工
	public void removeServiceStaff(ServiceStaff serviceStaff)
	{
			listServiceStaff.remove(serviceStaff);
		
	}
		
	public void changePCI(PersonCheckIn PCI)
	{
		for(ServiceStaff serviceStaff : listServiceStaff)
		{
			if(serviceStaff instanceof LifeServiceStaff)
			{
				if(((LifeServiceStaff) serviceStaff).getPersonCheckIn().getIDNum()
						.equals(PCI.getIDNum()))
					((LifeServiceStaff) serviceStaff).setPersonCheckIn(PCI);
					
			}
		}
	}
	public ArrayList<ServiceStaff> getListServiceStaff()
	{
		return listServiceStaff;
	}
	
	public static void setListServiceStaff(ArrayList<ServiceStaff> listServiceStaff)
	{
		ServiceStaffManagement.listServiceStaff = listServiceStaff;
	}
	@Override
	public String toString() {
		return "ServiceStaffManagement [toString()=" + super.toString() + "]";
	}
	@Override
	public Iterator<ServiceStaff> iterator() {
		// TODO Auto-generated method stub
		return listServiceStaff.iterator();
	}
	
	public void load() 
	{
		listServiceStaff.clear();
		String jsonStr = null;
		try {
			jsonStr = new String(
					Files.readAllBytes(FileSystems.getDefault().getPath(".", ServiceStaffManagement.class.getSimpleName() + ".json")),
					"UTF-8");
//			System.out.println("ss"+jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (jsonStr != null) {
			Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd").create();
			listServiceStaff.addAll(gson.fromJson(jsonStr, new TypeToken<List<ServiceStaff>>() {
			}.getType()));
		}

	}
	
	public void save() {
		Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd").create();
		String jsonStr = gson.toJson(listServiceStaff);
		System.out.println(jsonStr);
		try {
			Files.write(FileSystems.getDefault().getPath(".", ServiceStaffManagement.class.getSimpleName() + ".json"),
					jsonStr.getBytes(Charset.forName("utf-8")), StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void delete()
	{
		try
		{
			Files.delete(FileSystems.getDefault().getPath(".", ServiceStaffManagement.class.getSimpleName() + ".json"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
