package Management;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import entity.Member;
import entity.Person;
import entity.PersonCheckIn;

public class MemberManagement implements Iterable<Member>{
	static private MemberManagement singleton;
	static private ArrayList<Member> listMember = new ArrayList<Member>();
	
	//单态模式
	private MemberManagement()
	{
		
	}
	
	static public MemberManagement getMemberManagement()
	{
		if(singleton == null)
			singleton = new MemberManagement();
		return singleton;
	}
	//查找是否会员是否存在
	static public Member findMemberMemNum(int MemNum)
	{
		for(Member member : listMember)
		{
			if(member.getMemNum() == MemNum)
				return member;
		}
		return null;
	}
	static public Member findMemberName(String Name)
	{
		for(Member member : listMember)
		{
			if(member.getName().equals(Name))
				return member;
		}
		return null;
	}//多人重名怎么办？待删除
	static public Member findMemberTeleNum(String TeleNum)
	{
		for(Member member : listMember)
		{
			if(member.getTeleNum().equals(TeleNum))
				return member;
		}
		return null;
	}
	//添加会员
	public boolean addMember(Member member)
	{
			
		if(findMemberMemNum(member.getMemNum()) == null && findMemberTeleNum(member.getTeleNum()) == null)
			{
				listMember.add(member);
				return true;
			}
			return false;
	
		//return false;
	}
	//删除会员
	public void removeMember(Member member)
	{

			listMember.remove(member);
	}
	//修改会员信息
	  //Name
	public void changeName(Member member,String newName)
	{
			member.setName(newName);
	
	}
	  //Gender
	public void changeGender(Member member,String newGender)
	{
			member.setGender(newGender);
	}
	  //TeleNum
	public void changeTeleNum(Member member,String newTeleNum)
	{
			member.setTeleNum(newTeleNum);
	}
	  //ID
	public void changeID(Member member,String newID)
	{
			member.setIDNum(newID);
		
	}
	//BirthDate
	public void changeBirthDate(Member member,Date newDate)
	{
			member.setBirthDate(newDate);
	}
	//type of member
	public void changeTypeOfMember(Member member,String newTypeOfMember)
	{
			member.setTypeOfMember(newTypeOfMember);
	}
	//contact
	public void changeContact(Member member,PersonCheckIn newContact)
	{
			member.setContact(newContact);
	}
	public void changeContact(PersonCheckIn personCheckIn)
	{
		for(Member member : listMember)
		{
			if(personCheckIn.getLocationRoom().getMemNum() == member.getMemNum())			
					member.setContact(personCheckIn);
		}
	}
	public void changeContact1(PersonCheckIn personCheckIn)
	{
		for(Member member : listMember)
		{
			if(personCheckIn.getLocation().equals(member.getContact().getLocation())
				&& personCheckIn.getName().equals(member.getContact().getName()))			
					member.setContact(personCheckIn);
		}
	}
	static public ArrayList<Member> getListMember() 
	{
		return listMember;
	}

	@Override
	public Iterator<Member> iterator() 
	{		
		return listMember.iterator();
	}
	
	public void load() 
	{
		listMember.clear();
		String jsonStr = null;
		try {
			jsonStr = new String(
					Files.readAllBytes(FileSystems.getDefault().getPath(".", MemberManagement.class.getSimpleName() + ".json")),
					"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (jsonStr != null) {
			Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd").create();
			listMember.addAll(gson.fromJson(jsonStr, new TypeToken<List<Member>>() {
			}.getType()));
			
		}
		
	}
	
	public void save() {
		Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd").create();
		String jsonStr = gson.toJson(listMember);
		System.out.println(jsonStr);
		try {
			
			Files.write(FileSystems.getDefault().getPath(".", MemberManagement.class.getSimpleName() + ".json"),
					jsonStr.getBytes(Charset.forName("utf-8")), StandardOpenOption.CREATE);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void delete()
	{
		try
		{
			Files.delete(FileSystems.getDefault().getPath(".", MemberManagement.class.getSimpleName() + ".json"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
