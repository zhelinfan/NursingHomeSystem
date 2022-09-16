package administrationpage;

import entity.Building;
import entity.House;
import entity.Room;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class RemoveBHR extends AR_BuildingPage
{
	

	public RemoveBHR()
	{
		super();
		gridpane.getChildren().remove(textField4);
		gridpane.getChildren().remove(textField5);
		getTile().setText("É¾³ý½áµã");
	
	}
	protected void rb3()
	{
		  rb3.selectedProperty().addListener(new ChangeListener<Boolean>()
			{

				@Override
				public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2)
				{

					gridpane.getChildren().removeAll(text1,text2,text3,text4,text5,textField1,textField2,textField3,textField4,textField5);
					gridpane.add(text1, 1, 2);
					gridpane.add(textField1, 2, 2,2,1);
					gridpane.add(text2, 1, 3);
					gridpane.add(textField2, 2, 3,2,1);
					gridpane.add(text3, 1, 4);
					gridpane.add(textField3, 2, 4,2,1);
					 System.out.println("shanchu");
					AR_Room();
				}
				
			});
	}
	@Override
	public void AR_Building()
	{
		button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				 Building building = BM.findBuilding(textField1.getText());
				if(building != null)
					{
					  BM.removeBuilding(building);
					  BM.delete();
					  BM.save();
					  
					  BMP.removeBuildings(building);
					  stage.hide();
					}
				else
					PopingWindowNonExist.getPopingWindow().initial();
				
			}
	
		});
		
	}

	@Override
	public void AR_House()
	{
		button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				
				 Building building = BM.findBuilding(textField1.getText());
				 House house = building.findHouse(textField2.getText());
				if( building != null && house != null)
					{							 
					  building.removeHouse(house);
					  BM.delete();
					  BM.save();
					
					  BMP.removeHouses(building, house);
					  stage.hide();
					}
				else
					PopingWindowNonExist.getPopingWindow().initial();
				
			}
	
		});
		
	}

	@Override
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
				if( building != null && house != null && room !=null)
					{							 
					  house.removeRoom(room);
					  BM.delete();
					  BM.save();
					  				
					  BMP.removeRooms(building, house, room);
					  stage.hide();
					}
				else
					PopingWindowNonExist.getPopingWindow().initial();
				
			}
	
		});
		
	}

}
