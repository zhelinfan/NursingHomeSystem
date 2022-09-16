package application;

import java.util.Date;

import administrationpage.BuildingManagementPage;
import administrationpage.LivingManagementPage;
import administrationpage.LoginPage;
import administrationpage.MemberManagementPage;
import administrationpage.PopingWindowExist;
import administrationpage.PopingWindowExistMem;
import administrationpage.ServiceStaffManagementPage;
import entity.Building;
import entity.Bus;
import entity.House;
import entity.Member;
import entity.Person;
import entity.PersonCheckIn;
import entity.Room;
import entity.ServiceStaff;
import javafx.application.Application; 
import javafx.stage.Stage;
import Management.BuildingManagement;
import Management.BusManagement;
import Management.LivingManagement;
import Management.MemberManagement;
import Management.ServiceStaffManagement;

public class Main extends Application { 
	 public static void main(String args[]) throws Exception{          
//	      LogingPage.getLogingPage().start();  
		   launch(args);
		  
	   }   
	
	@Override     
   public void start(Stage primaryStage) throws Exception {            
		MemberManagement m = MemberManagement.getMemberManagement();
//		Member member = new Member("������", "Ů", "18106082555", "350721199801010045", 22052401,new Date(103, 2, 10), "�ƽ�",new PersonCheckIn("�Ϸ�", "��","189" , "350721"),"����Ժ���ҵ�");
//		m.addMember(new Member("������", "Ů", "18111112222", "350721199801010045", 22052401,new Date(103, 2, 10), "����", null,"����Ժ���ҵ�"));
//		m.addMember(member);
//		m.addMember(new Member("���ܷ�", "Ů", "13311112222", "350721199601010045", 22052402,new Date(102, 2, 10), "�ƽ�",null,"��"));
//		m.load();
//		m.save();
		m.load();
		
		ServiceStaffManagement ssm = ServiceStaffManagement.getServiceStaffManagement();
//		ssm.addServiceStaff(new ServiceStaff("С��", "Ů", "13311112222", "350721199801020045", 22050101, "123", "�����ܼ�"));
//		ssm.addServiceStaff(new ServiceStaff("С��", "Ů", "13322223333", "350721199801020045", 22050102, "123", "�����ܼ�"));
//		ssm.save();
		ssm.load();
		
		BuildingManagement bm =  BuildingManagement.getBuildingManagement();
//		Building building1 = new Building("������Ԣ");
//		Building building2 = new Building("Ϧ���칫Ԣ");
//		House house1 = new House("1��¥");
//		Room room = new Room("101","һ��һ��","��ס",22052401,1,"123456");
//		Room room1 = new Room("102","һ��һ��","��ס",22052402,1,"123456");
//		bm.getListBuilding().add(building1);
//		bm.getListBuilding().add(building2);
//		building1.addHouse(house1);
//		house1.addRoom(room);
//		house1.addRoom(room1);
//		bm.save();
		bm.load();
		
		LivingManagement lm =LivingManagement.getLivingManagement();
//		lm.addPersonCheckIn(new PersonCheckIn("�Ϸ�", "��","189" , "350721", member, room,"","��Ů" , "2022-05-31", "2022-","��ס"));
//		lm.addPersonCheckIn(new PersonCheckIn("�ֽ�", "Ů","1895" , "350721", member, room1,"","ĸŮ" , "2022-05-31", "2022-","��ס"));
//		lm.save();
		lm.load();
		
		BusManagement.getBusManagement().addBus(new Bus("101·"));
		
		 LoginPage.getLogingPage().start(primaryStage); 
//		 MemberManagementPage.getMemberManagementPage().start(primaryStage);
//		ServiceStaffManagementPage.getServiceStaffManagementPage().start(primaryStage);
//		BuildingManagementPage.getBuildingManagementPage().start(primaryStage);
//		LivingManagementPage.getLivingManagementPage().start(primaryStage);
		
   }    
        
} 