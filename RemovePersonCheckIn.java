package administrationpage;

import javax.imageio.plugins.bmp.BMPImageWriteParam;

import Management.BuildingManagement;
import Management.MemberManagement;
import entity.Building;
import entity.House;
import entity.PersonCheckIn;
import entity.Room;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class RemovePersonCheckIn extends FindPersonCheckIn
{
	ObservableList<PersonCheckIn> list;

	public RemovePersonCheckIn(ObservableList<PersonCheckIn> list)
	{
		this.list = list;

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
					 PopingWindowF_RPCI ppwrpci = new PopingWindowF_RPCI();
					 personCheckIn = LM.findPersonCheckIn2(textField4.getText(),location);
						if(personCheckIn != null)
						{
							ppwrpci.initial();
							ppwrpci.show(personCheckIn);
							stage.close();
							removeInfor(ppwrpci);
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
		    	 PopingWindowF_RPCI ppwrpci = new PopingWindowF_RPCI();
					personCheckIn = LM.findPersonCheckIn1(textField1.getText());	
				    if(personCheckIn != null)
					{
						
						ppwrpci.show(personCheckIn);
						ppwrpci.initial();
						stage.close();
						removeInfor(ppwrpci);
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
	private void removeInfor(PopingWindowF_RPCI ppwrpci)
	{
		Button buttonrpci = ppwrpci.getButton();
		buttonrpci.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent arg0)
			{
				ppwrpci.hide();
				
				
				list.remove(personCheckIn);
				LM.removePersonCheckIn(personCheckIn);	
				MemberManagement.findMemberMemNum(personCheckIn.getContactMember().getMemNum()).setContact(null);
				
				Building bui = BM.findBuilding(personCheckIn.buiName());
				House hou = bui.findHouse(personCheckIn.houName());
				Room room = hou.findRoom(personCheckIn.getLocationRoom().getRoomNum());
				room.setLivPerNum(room.getLivPerNum()-1);
				room.setConditon(room.decide(personCheckIn));
			
				BM.delete();
				BM.save();
				LM.delete();
				LM.save();
				
				new PopingWindowSuccess().initial();
			}
		});
	}
}
