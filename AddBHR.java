package administrationpage;

import entity.Building;
import entity.House;
import entity.Room;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;

public class AddBHR extends AR_BuildingPage
{
	protected void rb3()
	{
		  rb3.selectedProperty().addListener(new ChangeListener<Boolean>()
			{

				public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2)
				{

					gridpane.getChildren().removeAll(text1,text2,text3,text4,text5,textField1,textField2,textField3,textField4,textField5);
					gridpane.add(text1, 1, 2);
					gridpane.add(textField1, 2, 2,2,1);
					gridpane.add(text2, 1, 3);
					gridpane.add(textField2, 2, 3,2,1);
					gridpane.add(text3, 1, 4);
					gridpane.add(textField3, 2, 4,2,1);
					gridpane.add(text4, 1, 5);
					gridpane.add(textField4, 2, 5,2,1);
					gridpane.add(text5, 1, 6);
					gridpane.add(textField5, 2, 6,2,1);
					textField5.setText("未售出");
					textField5.setEditable(false);
					 
					AR_Room();
				}
				
			});
	}
		public void AR_Building()
		{
			button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
			{

				@Override
				public void handle(MouseEvent arg0)
				{
					 Building building = BM.findBuilding(textField1.getText());
					if(building == null)
						{
						  TreeItem<String> newBuilding = new TreeItem<String>(textField1.getText());
						  BM.addBuilding(new Building(textField1.getText()));
						  BM.save();
						  BMP.getBuildings().getChildren().add(newBuilding);
						  stage.hide();
						}
					else
						PopingWindowExist.getPopingWindow().initial();
					
				}
		
			});
		}
		public void AR_House()
		{
			button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
			{

				@Override
				public void handle(MouseEvent arg0)
				{
					
					 Building building = BM.findBuilding(textField1.getText());
					 House house = building.findHouse(textField2.getText());
					if( building != null && house == null)
						{							 
						  house = new House(textField2.getText());
						  building.addHouse(house);
						  BM.save();
						  
						  TreeItem<String> newHouse = new TreeItem<String>(textField2.getText());
						  BMP.getHouses(building).getChildren().add(newHouse);
						  
						  stage.hide();
						}
					else
						PopingWindowExist.getPopingWindow().initial();
					
				}
		
			});
		}
		public void AR_Room()
		{
			button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
			{

				@Override
				public void handle(MouseEvent arg0)
				{

					
					 Building building = BM.findBuilding(textField1.getText());
					 House house = building.findHouse(textField2.getText());
					 Room room = house.findRoom(textField3.getText());
					if( building != null && house != null && room ==null)
					{							 
						  room = new Room(textField3.getText(),textField4.getText(),
								                         "未售出",0,0,"0");
						  house.addRoom(room);
						  BM.save();
						  
						  TreeItem<String> newRoom = new TreeItem<String>(textField3.getText());
						  BMP.getRooms(building, house).getChildren().add(newRoom);
						  stage.hide();
						  new PopingWindowSuccess().initial();
					}
					else
						PopingWindowExist.getPopingWindow().initial();
					
				}
		
			});
		}
}
