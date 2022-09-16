package administrationpage;

import Management.BusManagement;
import Management.LivingManagement;
import Management.MemberManagement;
import Management.ServiceStaffManagement;
import entity.Bus;
import entity.LifeServiceStaff;
import entity.LogisticsServiceStaff;
import entity.PersonCheckIn;
import entity.ServiceStaff;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class AddServiceStaffPage extends AC_ServiceStaffPage
{
	
	MemberManagement MM = MemberManagement.getMemberManagement();
	ServiceStaffManagement SSM = ServiceStaffManagement.getServiceStaffManagement();
	LivingManagement LM = LivingManagement.getLivingManagement();
	BusManagement BusM = BusManagement.getBusManagement();
	ServiceStaff serviceStaff;
	
	public AddServiceStaffPage(ObservableList<ServiceStaff> list)
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
			
			  if(SSM.findServiceStaff2(textField6.getText()) == null 
			     &&  SSM.findServiceStaff4(textField5.getText()) == null
			     && SSM.findServiceStaff5(Integer.parseInt(textField1.getText())) == null)
				{
				  if(rButton1.isSelected())
					{
							serviceStaff = new ServiceStaff(textField3.getText(), textField4.getText(),
							textField5.getText(), textField6.getText(), Integer.parseInt(textField1.getText()),
							textField2.getText(), "³¬¼¶¹Ü¼Ò");
						
					}
					else if(rButton2.isSelected())
					{
						PersonCheckIn personCheckIn = LM.findPersonCheckIn2(textField9.getText(),textField7.getText());
						
							serviceStaff = new LifeServiceStaff(textField3.getText(), textField4.getText(),
							textField5.getText(), textField6.getText(), Integer.parseInt(textField1.getText()),
							textField2.getText(),personCheckIn);
						
					}
					else if(rButton3.isSelected())
					{
						Bus bus = BusM.findBus(textField8.getText());
						
							serviceStaff = new LogisticsServiceStaff(textField3.getText(), textField4.getText(),
							textField5.getText(), textField6.getText(), Integer.parseInt(textField1.getText()),
							textField2.getText(),bus);
					}
					
						SSM.addServiceStaff(serviceStaff);
						SSM.save();
						list.add(serviceStaff);
						stage.close();
					
				
				}
			  else
				  PopingWindowExist.getPopingWindow().initial();

			}

		});

	}

}
