package administrationpage;

import entity.Building;
import entity.House;
import entity.Room;
import javafx.scene.control.Button;

public class PopingWindowF_CRoom extends PopingWindowF_CMem
{

	@Override
	public void setHeaderText()
	{
		alert.setHeaderText("�÷������,\n��Ҫά��������չ������ʾ������Ϣ��");
		
	}
	public void setHeaderText2()
	{
		alert.setHeaderText("ά���ɹ�,\n������չ������ʾ������Ϣ��");
	}
	public Button getButton()
	  {
		   button.setText("ά������");
		   gridpane.add(button, 3, 3);
		   return button;
	  }
	public void show(Building building, House house,Room room)
	{
		text.setText("¥�̣� "+building.getBuildingName()+
					 "\n¥�ţ� "+house.getHouseNum()+
					 "\n���ţ� "+room.getRoomNum()+
					 "\n�������ͣ� "+room.getTypeOfRoom()+
					 "\n����״̬�� "+room.getConditon()+
					 "\n������Ա��ţ� "+room.getMemNum()+
					 "\n������ͬ��ţ� "+room.getSellNum()+
					 "\nĿǰ��ס������ "+room.getLivPerNum());
		
	}

}
