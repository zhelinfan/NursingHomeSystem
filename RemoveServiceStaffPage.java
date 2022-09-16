package administrationpage;


import Management.ServiceStaffManagement;
import entity.ServiceStaff;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class RemoveServiceStaffPage extends FindServiceStaffPage
{
	ObservableList<ServiceStaff> list;
	
	ServiceStaffManagement SSM = ServiceStaffManagement.getServiceStaffManagement();
	public RemoveServiceStaffPage(ObservableList<ServiceStaff> list)
	{
		this.list = list;

	}

	public void function()
	{

		button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				if (textField1.getText() == null)
					PopingWindowNonExist.getPopingWindow().initial();
				else
				{
					ServiceStaff ss1 = SSM.findServiceStaff4(textField1.getText());
					ServiceStaff ss2 = SSM.findServiceStaff5(Integer.parseInt(textField1.getText()));
					PopingWindowF_RSS ppwfr = new PopingWindowF_RSS();
					
					if (rb2.isSelected() && ss1 != null)
					{
						ppwfr.initial();
						ppwfr.show(ss1);
						stage.hide();
						removeinfor(ss1, ppwfr);

					} else if (rb1.isSelected() && ss2 != null)
					{
						ppwfr.initial();
						ppwfr.show(ss2);
						stage.hide();
						removeinfor(ss2, ppwfr);

					} else
					{
						PopingWindowNonExist.getPopingWindow().initial();
					}

				}

			}
		});
		SSM.save();

	}

	private void removeinfor(ServiceStaff serviceStaff, PopingWindowF_RSS ppwfr)
	{
		Button buttonppwfc = ppwfr.getButton();

		buttonppwfc.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			public void handle(MouseEvent arg0)
			{
				ppwfr.hide();
				list.remove(serviceStaff);
				SSM.removeServiceStaff(serviceStaff);;
				SSM.delete();
				SSM.save();
				new PopingWindowSuccess().initial();
			}
			
		});
		
	}

}
