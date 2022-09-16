package administrationpage;

import Management.BuildingManagement;
import Management.LivingManagement;
import Management.MemberManagement;
import Management.ServiceStaffManagement;
import entity.Building;
import entity.House;
import entity.Member;
import entity.PersonCheckIn;
import entity.Room;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChangePersonCheckInPage extends AC_PersonCheckInPage
{

	Stage stage1 = new Stage();
	GridPane gridpane1 = new GridPane();
	Scene scene1 = new Scene(gridpane1);
	Text title1 = new Text("查找用户是否存在");
	Text textname = new Text("姓名");
	Text textbui = new Text("楼盘");
	Text texthou = new Text("楼号");
	Text textroom = new Text("房间");
	TextField textFieldname = new TextField();
	TextField textFieldbui = new TextField();
	TextField textFieldhou = new TextField();
	TextField textFieldroom = new TextField();
	final ToggleGroup tg = new ToggleGroup();
	RadioButton buttonRoom = new RadioButton("通过房间");
	RadioButton buttonTeleNum = new RadioButton("通过电话号码");
//	RadioButton buttonMem = new RadioButton("通过联系会员");
	Button button3 = new Button("确定");
	Button button4 = new Button("退出");
	PersonCheckIn personCheckIn;
	
	BuildingManagement BM = BuildingManagement.getBuildingManagement();
	LivingManagement LM = LivingManagement.getLivingManagement();
	MemberManagement MM = MemberManagement.getMemberManagement();
	ServiceStaffManagement SSM = ServiceStaffManagement.getServiceStaffManagement();
	ServiceStaffManagementPage SSMP = ServiceStaffManagementPage.getServiceStaffManagementPage();
	public ChangePersonCheckInPage(ObservableList<PersonCheckIn> list)
	{
		super(list);
		getTitle().setText("修改信息");
	}
	
	public void start()
	{
		iniStage1();
		addOrChange();

	}

	@Override
	public void addOrChange()
	{
		 buttonTeleNum.selectedProperty().addListener(new ChangeListener<Boolean>()
			{	
				@Override
				public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2)
				{
					gridpane1.getChildren().removeAll(textbui,texthou,textroom,textname,textFieldbui,textFieldhou,textFieldroom,textFieldname);
					gridpane1.add(textFieldbui, 3, 4);
					
					thrTeleNum();
				}
				
			});

		 buttonRoom.selectedProperty().addListener(new ChangeListener<Boolean>()
			{	
				@Override
				public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2)
				{
					gridpane1.getChildren().removeAll(textbui,texthou,textroom,textFieldbui,textFieldhou,textFieldroom);
					gridpane1.add(textname, 2, 3);
					gridpane1.add(textbui, 2, 4);
					gridpane1.add(texthou, 2, 5);
					gridpane1.add(textroom, 2, 6);
					gridpane1.add(textFieldname, 3, 3);
					gridpane1.add(textFieldbui, 3, 4);
					gridpane1.add(textFieldhou, 3, 5);
					gridpane1.add(textFieldroom, 3, 6);
					
					thrRoom();
				}
				
			});
		
	}

	public void thrRoom()
	{

		button3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				
				try {
					 Building building = BM.findBuilding(textFieldbui.getText());
					 House house = building.findHouse(textFieldhou.getText());
					 Room room = house.findRoom(textFieldroom.getText());
					 PopingWindowF_CPCI ppwcpci = new PopingWindowF_CPCI();
					 String location = building.getBuildingName()+" "+house.getHouseNum()+" "+room.getRoomNum();
					 personCheckIn = LM.findPersonCheckIn2(textFieldname.getText(),location);
						if(personCheckIn != null)
						{
							ppwcpci.initial();
							ppwcpci.show(personCheckIn);
							stage1.close();
							setInfor(ppwcpci);
							changeInfor();
						}
						else
						{
							PopingWindowNonExist.getPopingWindow().initial();
						}

					}catch(Exception e)
					{
						PopingWindowNonExist.getPopingWindow().initial();
					}

			}
		});

	}
	public void thrTeleNum()
	{
		button3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
		     try {
		    	    PopingWindowF_CPCI ppwcpci = new PopingWindowF_CPCI();
					personCheckIn = LM.findPersonCheckIn1(textFieldbui.getText());	
					
				    if(personCheckIn != null)
					{
						
						ppwcpci.show(personCheckIn);
						ppwcpci.initial();
						stage1.close();
	
						setInfor(ppwcpci);
						changeInfor();
					}
					else
					{
						PopingWindowNonExist.getPopingWindow().initial();
					}
			     }catch(Exception e)
			     {
			    	 e.printStackTrace();
//			    	 PopingWindowNonExist.getPopingWindow().initial();
			     }

			}
		});
	}

	private void setInfor(PopingWindowF_CPCI ppwcpci)
	{
		Button buttonfpci = ppwcpci.getButton();
		buttonfpci.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent arg0)
			{
				ppwcpci.hide();
				iniStage();
				String[] s =personCheckIn.getLocation().split(" ");
				textField1.setText(personCheckIn.getName());
				textField2.setText(personCheckIn.getGender());
				textField3.setText(personCheckIn.getTeleNum());
				textField4.setText(personCheckIn.getIDNum());
				textField5.setText(String.valueOf(personCheckIn.getContactMember().getMemNum()));
				textField6.setText(personCheckIn.getRelationship());
				textField7.setText(s[0]);
				textField8.setText(s[1]);
				textField9.setText(personCheckIn.getLocationRoom().getRoomNum());
				textField10.setText(personCheckIn.getTimeOfEntering());
				textField11.setText(personCheckIn.getTimeOfLeaving());
				textField12.setText(personCheckIn.getTypeOfLiving());
				
	

			}
		});
	}
	private void changeInfor()
	{
		button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent arg0)
			{
				int indext = list.indexOf(personCheckIn);
				int flag = 1;
				Building building = BM.findBuilding(textField7.getText());
				House house = building.findHouse(textField8.getText());
				Room room = house.findRoom(textField9.getText());
				Room oldroom = personCheckIn.getLocationRoom();
				Member oldmember = personCheckIn.getContactMember();
				Member newmember = MemberManagement.findMemberMemNum(Integer.parseInt(textField5.getText()));
				if(!textField1.getText().equals(personCheckIn.getName()))
					personCheckIn.setName(textField1.getText());
				
				if(!textField2.getText().equals(personCheckIn.getGender()))
					personCheckIn.setGender(textField2.getText());
				
				if(!textField3.getText().equals(personCheckIn.getTeleNum()))
					{
						if(LM.findPersonCheckIn1(textField3.getText()) == null)
						{
							personCheckIn.setTeleNum(textField3.getText());   
						}
						else
						{
							PopingWindowExist.getPopingWindow().initial();
							flag = 0;
						}
					}
				
				if(!textField4.getText().equals(personCheckIn.getIDNum()))
					personCheckIn .setIDNum(textField4.getText());
				
				if(!textField5.getText().equals(String.valueOf(oldmember.getMemNum())))
				{
					if(newmember != null)
					personCheckIn.setContactMember(newmember);
					else
					{
					  flag = 0;
					  PopingWindowNonExist.getPopingWindow().initial();
					}
				}
	
				if(!textField6.getText().equals(personCheckIn.getRelationship()))
					personCheckIn.setRelationship(textField6.getText());
				
				if(!textField7.getText().equals(personCheckIn.buiName())	
				|| !textField8.getText().equals(personCheckIn.houName())
			    || !textField9.getText().equals(personCheckIn.getLocationRoom().getRoomNum()))
				  {
				
					 if(room != null)
					 {
						
						 oldroom.setLivPerNum(oldroom.getLivPerNum()-1);
						 oldroom.setConditon(oldroom.decide(personCheckIn));
						 
						 personCheckIn.setLocationRomm(room);
						 room.setLivPerNum(room.getLivPerNum()+1);
						 room.setConditon(room.decide(personCheckIn));
						
						 
					 }
					 else
						 {
						   PopingWindowNonExist.getPopingWindow().initial();
						   flag = 0;
						 }
				  }
				if(!textField10.getText().equals(personCheckIn.getTimeOfEntering()))
					personCheckIn.setTimeOfEntering(textField10.getText());
				
			    if(!textField11.getText().equals(personCheckIn.getTimeOfLeaving()))
			        personCheckIn.setTimeOfLeaving(textField11.getText());
			    
			    if(!textField12.getText().equals(personCheckIn.getTypeOfLiving()))
			    {
			    	if(room != null)
			    	{
			    		personCheckIn.setTypeOfLiving(textField12.getText());
				    	room.setConditon(personCheckIn.getTypeOfLiving());
				    	
				    	if(personCheckIn.getTypeOfLiving().equals("入住") && room.getMemNum() == newmember.getMemNum())
				    	{
				    		newmember.setContact(personCheckIn);
				    	}
				    	else if(personCheckIn.getTypeOfLiving().equals("租住") && room.getMemNum() != newmember.getMemNum())
				    	{
				    		newmember.setContact(personCheckIn);
				    	}
			    	}
				   else
					 {
					   PopingWindowNonExist.getPopingWindow().initial();
					   flag = 0;
					 }
			    
			    }
			    
			    if(flag == 1)
			    {  
			    	MM.changeContact1(personCheckIn);
			    	SSM.changePCI(personCheckIn);
			    	list.set(indext, personCheckIn);
			    
				    LM.save();
				    
				    BM.save();
				    SSM.save();
				    MM.save();
				    stage.hide();
					new PopingWindowSuccess().initial();	
			    }
			}
		});
	}
	private void iniStage1()
	{
		title1.setFont(Font.font("HeiTi", FontWeight.BOLD, FontPosture.REGULAR, 20));
		
		buttonRoom.setToggleGroup(tg);
		buttonTeleNum.setToggleGroup(tg);
		textFieldbui.setPrefSize(100, 15);
		textFieldhou.setPrefSize(100, 15);
		textFieldroom.setPrefSize(100, 15);
		textFieldname.setPrefSize(100, 15);
		GridPane.setHalignment(button3, HPos.RIGHT);
//		textField1.setPromptText("会员编号/电话号码");
		
		gridpane1.add(title1, 0, 0, 5, 1);
		gridpane1.add(buttonRoom, 2, 1,2,1);
		gridpane1.add(buttonTeleNum, 2, 2,2,1);
		gridpane1.add(button3, 3, 7);
		gridpane1.add(button4, 4, 7);
		new CloseButton(button4, stage1).close();
		
		gridpane1.setVgap(10);
		gridpane1.setHgap(10);
		gridpane1.setPadding(new Insets(25, 5, 25, 5));
		gridpane1.setStyle("-fx-background-color: F0FFF0;");
		gridpane1.setAlignment(Pos.TOP_CENTER);
		stage1.setScene(scene1);
		stage1.setTitle("用户管理页面");
		stage1.setWidth(350);
		stage1.setHeight(320);
		stage1.show();
		


	}
}
