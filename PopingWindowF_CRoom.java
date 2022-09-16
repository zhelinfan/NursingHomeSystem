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
		alert.setHeaderText("该房间存在,\n若要维护房间请展开“显示更多信息”");
		
	}
	public void setHeaderText2()
	{
		alert.setHeaderText("维护成功,\n详情请展开“显示更多信息”");
	}
	public Button getButton()
	  {
		   button.setText("维护房间");
		   gridpane.add(button, 3, 3);
		   return button;
	  }
	public void show(Building building, House house,Room room)
	{
		text.setText("楼盘： "+building.getBuildingName()+
					 "\n楼号： "+house.getHouseNum()+
					 "\n房号： "+room.getRoomNum()+
					 "\n房间类型： "+room.getTypeOfRoom()+
					 "\n房间状态： "+room.getConditon()+
					 "\n所属会员编号： "+room.getMemNum()+
					 "\n购房合同编号： "+room.getSellNum()+
					 "\n目前居住人数： "+room.getLivPerNum());
		
	}

}
