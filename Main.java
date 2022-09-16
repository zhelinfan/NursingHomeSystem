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
//		Member member = new Member("范哲琳", "女", "18106082555", "350721199801010045", 22052401,new Date(103, 2, 10), "黄金",new PersonCheckIn("老范", "男","189" , "350721"),"养老院她家的");
//		m.addMember(new Member("范哲琳", "女", "18111112222", "350721199801010045", 22052401,new Date(103, 2, 10), "王冠", null,"养老院她家的"));
//		m.addMember(member);
//		m.addMember(new Member("林哲帆", "女", "13311112222", "350721199601010045", 22052402,new Date(102, 2, 10), "黄金",null,"无"));
//		m.load();
//		m.save();
		m.load();
		
		ServiceStaffManagement ssm = ServiceStaffManagement.getServiceStaffManagement();
//		ssm.addServiceStaff(new ServiceStaff("小陈", "女", "13311112222", "350721199801020045", 22050101, "123", "超级管家"));
//		ssm.addServiceStaff(new ServiceStaff("小何", "女", "13322223333", "350721199801020045", 22050102, "123", "超级管家"));
//		ssm.save();
		ssm.load();
		
		BuildingManagement bm =  BuildingManagement.getBuildingManagement();
//		Building building1 = new Building("颐养公寓");
//		Building building2 = new Building("夕阳红公寓");
//		House house1 = new House("1号楼");
//		Room room = new Room("101","一室一厅","入住",22052401,1,"123456");
//		Room room1 = new Room("102","一室一厅","入住",22052402,1,"123456");
//		bm.getListBuilding().add(building1);
//		bm.getListBuilding().add(building2);
//		building1.addHouse(house1);
//		house1.addRoom(room);
//		house1.addRoom(room1);
//		bm.save();
		bm.load();
		
		LivingManagement lm =LivingManagement.getLivingManagement();
//		lm.addPersonCheckIn(new PersonCheckIn("老范", "男","189" , "350721", member, room,"","父女" , "2022-05-31", "2022-","入住"));
//		lm.addPersonCheckIn(new PersonCheckIn("林姐", "女","1895" , "350721", member, room1,"","母女" , "2022-05-31", "2022-","入住"));
//		lm.save();
		lm.load();
		
		BusManagement.getBusManagement().addBus(new Bus("101路"));
		
		 LoginPage.getLogingPage().start(primaryStage); 
//		 MemberManagementPage.getMemberManagementPage().start(primaryStage);
//		ServiceStaffManagementPage.getServiceStaffManagementPage().start(primaryStage);
//		BuildingManagementPage.getBuildingManagementPage().start(primaryStage);
//		LivingManagementPage.getLivingManagementPage().start(primaryStage);
		
   }    
        
} 