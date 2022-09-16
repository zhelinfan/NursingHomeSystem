package administrationpage;

import Management.BuildingManagement;
import Management.LivingManagement;
import Management.MemberManagement;
import entity.Building;
import entity.House;
import entity.PersonCheckIn;
import entity.Room;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

public class FindPersonCheckIn
{
	Stage stage = new Stage();
	GridPane gridpane = new GridPane();
	Scene scene = new Scene(gridpane);
	Text title = new Text("查找用户是否存在");
	Text text1 = new Text("楼盘");
	Text text2 = new Text("楼号");
	Text text3 = new Text("房间");
	Text text4 = new Text("姓名");
	TextField textField1 = new TextField();
	TextField textField2 = new TextField();
	TextField textField3 = new TextField();
	TextField textField4 = new TextField();
	final ToggleGroup tg = new ToggleGroup();
	RadioButton buttonRoom = new RadioButton("通过房间");
	RadioButton buttonTeleNum = new RadioButton("通过电话号码");
//	RadioButton buttonMem = new RadioButton("通过联系会员");
	Button button1 = new Button("确定");
	Button button2 = new Button("退出");
	PersonCheckIn personCheckIn;
	
	BuildingManagement BM = BuildingManagement.getBuildingManagement();
	LivingManagement LM = LivingManagement.getLivingManagement();
	MemberManagement MM = MemberManagement.getMemberManagement();

	public void start()
	{
		iniStage();
		function();
		new CloseButton(button2, stage).close();
	}

	private void iniStage()
	{
		title.setFont(Font.font("HeiTi", FontWeight.BOLD, FontPosture.REGULAR, 20));
		
		buttonRoom.setToggleGroup(tg);
		buttonTeleNum.setToggleGroup(tg);
		textField1.setPrefSize(100, 15);
		textField2.setPrefSize(100, 15);
		textField3.setPrefSize(100, 15);
		textField4.setPrefSize(100, 15);
		GridPane.setHalignment(button1, HPos.RIGHT);
//		textField1.setPromptText("会员编号/电话号码");
		
		gridpane.add(title, 0, 0, 5, 1);
		gridpane.add(buttonRoom, 2, 1,2,1);
		gridpane.add(buttonTeleNum, 2, 2,2,1);
		gridpane.add(button1, 3, 7);
		gridpane.add(button2, 4, 7);

		gridpane.setVgap(10);
		gridpane.setHgap(10);
		gridpane.setPadding(new Insets(25, 5, 25, 5));
		gridpane.setStyle("-fx-background-color: F0FFF0;");
		gridpane.setAlignment(Pos.TOP_CENTER);
		stage.setScene(scene);
		stage.setTitle("用户管理页面");
		stage.setWidth(350);
		stage.setHeight(320);
		stage.show();
		
//	gridpane.setGridLinesVisible(true);

	}

	public void thrRoom()
	{

		button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				// flag = true;
//				try {
					 Building building = BM.findBuilding(textField1.getText());
					 House house = building.findHouse(textField2.getText());
					 Room room = house.findRoom(textField3.getText());
					 String location = building.getBuildingName()+" "+house.getHouseNum()+" "+room.getRoomNum();
					 PopingWindowFindPCI ppwfpci = new PopingWindowFindPCI();
						personCheckIn = LM.findPersonCheckIn2(textField4.getText(),location);
						if(personCheckIn != null)
						{
							ppwfpci.initial();
							ppwfpci.show(personCheckIn);
							stage.close();
						}
						else
						{
							PopingWindowNonExist.getPopingWindow().initial();
						}

//					}catch(Exception e)
//					{
//						PopingWindowNonExist.getPopingWindow().initial();
//					}

			}
		});

	}
	public void thrTeleNum()
	{
		button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
		     try {
		    	    PopingWindowFindPCI ppwfpci = new PopingWindowFindPCI();
					personCheckIn = LM.findPersonCheckIn1(textField1.getText());	
				    if(personCheckIn != null)
					{
						
						ppwfpci.show(personCheckIn);
						ppwfpci.initial();
						stage.close();
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

	private void function()
	{
		 buttonTeleNum.selectedProperty().addListener(new ChangeListener<Boolean>()
			{	
				@Override
				public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2)
				{
					gridpane.getChildren().removeAll(text1,text2,text3,text4,textField1,textField2,textField3,textField4);
					gridpane.add(textField1, 3, 4);
					
					thrTeleNum();
				}
				
			});

		 buttonRoom.selectedProperty().addListener(new ChangeListener<Boolean>()
			{	
				@Override
				public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2)
				{
					gridpane.getChildren().removeAll(text1,text2,text3,text4,textField1,textField2,textField3,textField4);
					gridpane.add(text4, 2, 3);
					gridpane.add(text1, 2, 4);
					gridpane.add(text2, 2, 5);
					gridpane.add(text3, 2, 6);
					gridpane.add(textField4, 3, 3);
					gridpane.add(textField1, 3, 4);
					gridpane.add(textField2, 3, 5);
					gridpane.add(textField3, 3, 6);
					
					thrRoom();
				}
				
			});
		 
	}
}
