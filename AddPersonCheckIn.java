package administrationpage;

import Management.BuildingManagement;
import Management.LivingManagement;
import Management.MemberManagement;
import entity.Building;
import entity.House;
import entity.Member;
import entity.Person;
import entity.PersonCheckIn;
import entity.Room;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class AddPersonCheckIn extends AC_PersonCheckInPage
{

	BuildingManagement BM = BuildingManagement.getBuildingManagement();
	 LivingManagement LM = LivingManagement.getLivingManagement();
	 MemberManagement MM = MemberManagement.getMemberManagement();
	public AddPersonCheckIn(ObservableList<PersonCheckIn> list)
	{
		super(list);

	}

	@Override
	public void addOrChange()
	{
		button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
			  try {
				
					 
					 Building building = BM.findBuilding(textField7.getText());
					 House house = building.findHouse(textField8.getText());
					 Room room = house.findRoom(textField9.getText());
					 Member member =  MemberManagement.findMemberMemNum(Integer.valueOf(textField5.getText()));
					 PersonCheckIn personCheckIn = LM.findPersonCheckIn(textField1.getText(),member);
					 
					 if(personCheckIn == null && room != null && member != null)
					 {
						if(!room.getConditon().equals("未售出"))
						 {
							personCheckIn = new PersonCheckIn(textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(),
								           member, room, "", textField6.getText(), textField10.getText(), textField11.getText(), textField12.getText());
						 

						 					 
							 
							 LM.addPersonCheckIn(personCheckIn);	
							 room.setLivPerNum(room.getLivPerNum()+1);
							 room.setConditon(room.decide(personCheckIn));
							
							 list.add((PersonCheckIn)personCheckIn);
							 
							 if(personCheckIn.getTypeOfLiving().equals("入住") && room.getMemNum() == member.getMemNum())
							     member.setContact(personCheckIn);
							 else if(personCheckIn.getTypeOfLiving().equals("租住") && room.getMemNum() != member.getMemNum())
								 member.setContact(personCheckIn);
								 
							 LM.save();
							 BM.save();
							 MM.save();
							 
							 stage.close();
							 new PopingWindowSuccess().initial();
						}
						else
						{
							PopingWindowOnSell.getPopingWindow().initial();
						}
					 }
				
				  }catch(Exception e)
				  {
						PopingWindowNonExist.getPopingWindow().initial(); 
				  }
					 
			}

	
		});
		
	}

}
