package administrationpage;

import Management.BuildingManagement;
import entity.Building;
import entity.House;
import entity.Room;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FindRoomPage
{

	Stage stage = new Stage();
	GridPane gridpane = new GridPane();
	Scene scene = new Scene(gridpane); 
	Button button1 = new Button("查询");
	Button button2 = new Button("退出");
	Text title = new Text("查看房屋信息");
	Text text1 = new Text("楼盘");
    Text text2 = new Text("楼号");
	Text text3 = new Text("房间号");
	TextField textField1 = new TextField(); 
    TextField textField2 = new TextField(); 
    TextField textField3 = new TextField(); 
	
	BuildingManagement BM = BuildingManagement.getBuildingManagement();
	BuildingManagementPage BMP = BuildingManagementPage.getBuildingManagementPage();
	 PopingWindowF_CRoom ppwfcr = new PopingWindowF_CRoom();
	
	protected void iniStage()
	{
		   title.setFont(Font.font("HeiTi", FontWeight.BOLD, FontPosture.REGULAR, 25));

		   textField1.setPrefSize(100, 10);
		   textField2.setPrefSize(100, 10);
		   textField3.setPrefSize(100, 10);

		//add title
			gridpane.add(title, 0, 0,5,1);
					
		//add buttons
			gridpane.add(button1,3, 6);
			gridpane.add(button2,4, 6);
			gridpane.add(text1, 1, 2);
			gridpane.add(textField1, 2, 2,3,1);
			gridpane.add(text2, 1, 3);
			gridpane.add(textField2, 2, 3,3,1);
			gridpane.add(text3, 1, 4);
			gridpane.add(textField3, 2, 4,3,1);
			
			
			gridpane.setStyle("-fx-background-color: CAE1FF;");
		    gridpane.setAlignment(Pos.TOP_CENTER);
		    GridPane.setHalignment(button1, HPos.RIGHT);
		    gridpane.setVgap(10);
		    gridpane.setHgap(12);
		    gridpane.setPadding(new Insets(20,20,10,10));
		    
		    stage.setScene(scene);
		    stage.setTitle("查看房间信息"); 
		    stage.setWidth(300);
		    stage.setHeight(280);    
		    stage.centerOnScreen();
		    stage.show();
		    
		   
//		   gridpane.setGridLinesVisible(true);
	}

	public void start()
	{
		iniStage();
		find();
		new CloseButton(button2, stage).close();
		
	}
	public void find()
	{
		button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				
				 Building building = BM.findBuilding(textField1.getText());
				 House house = building.findHouse(textField2.getText());
				 Room room = house.findRoom(textField3.getText());
				if( building != null && house != null && room !=null)
				{							 
				    stage.hide();
				   
				    ppwfcr.show(building, house, room);
				    ppwfcr.initial();
				    ppwfcr.getButton().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
					{

						@Override
						public void handle(MouseEvent arg0)
						{
							
							ppwfcr.hide();
							BMP.getTextField1().setText(building.getBuildingName());
							BMP.getTextField2().setText(house.getHouseNum());
							BMP.getTextField3().setText(room.getRoomNum());
							BMP.getTextField4().setText(room.getTypeOfRoom());
							BMP.getTextField5().setText(room.getConditon());
							BMP.getTextField6().setText(String.valueOf(room.getMemNum()));
							BMP.getTextField8().setText(String.valueOf(room.getLivPerNum()));
							BMP.getTextField7().setText(room.getSellNum());
							
						}

					});
				}
				else
					PopingWindowNonExist.getPopingWindow().initial();
				
			}
	
		});
	}
	
}
