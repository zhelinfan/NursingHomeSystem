package administrationpage;

import entity.PersonCheckIn;

public class PopingWindowFindPCI extends PopingWindowFind
{

	public void show(PersonCheckIn personCheckIn)
	{
		text.setText("姓名： " + personCheckIn.getName() 
					+ "\n性别： "+ personCheckIn.getGender()
					+"\n电话： " + personCheckIn.getTeleNum()
					+ "\n身份证号： " + personCheckIn.getIDNum()
					+"\n联系会员编号： "+ personCheckIn.getContactMember().getMemNum()
					+ "\n关系（与会员）： " + personCheckIn.getRelationship()
					+ "\n所住地址： " + personCheckIn.getLocation()
					+ "\n入住开始时间： " + personCheckIn.getTimeOfEntering()
					+"\n入住结束时间： "+ personCheckIn.getTimeOfLeaving()
					+"\n入住类型时间： "+personCheckIn.getTypeOfLiving());
		
	}
	@Override
	public void setHeaderText()
	{
		alert.setHeaderText("该入住人员存在,\n详细信息请点“显示详细信息”");
		
	}

}
