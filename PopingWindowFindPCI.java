package administrationpage;

import entity.PersonCheckIn;

public class PopingWindowFindPCI extends PopingWindowFind
{

	public void show(PersonCheckIn personCheckIn)
	{
		text.setText("������ " + personCheckIn.getName() 
					+ "\n�Ա� "+ personCheckIn.getGender()
					+"\n�绰�� " + personCheckIn.getTeleNum()
					+ "\n���֤�ţ� " + personCheckIn.getIDNum()
					+"\n��ϵ��Ա��ţ� "+ personCheckIn.getContactMember().getMemNum()
					+ "\n��ϵ�����Ա���� " + personCheckIn.getRelationship()
					+ "\n��ס��ַ�� " + personCheckIn.getLocation()
					+ "\n��ס��ʼʱ�䣺 " + personCheckIn.getTimeOfEntering()
					+"\n��ס����ʱ�䣺 "+ personCheckIn.getTimeOfLeaving()
					+"\n��ס����ʱ�䣺 "+personCheckIn.getTypeOfLiving());
		
	}
	@Override
	public void setHeaderText()
	{
		alert.setHeaderText("����ס��Ա����,\n��ϸ��Ϣ��㡰��ʾ��ϸ��Ϣ��");
		
	}

}
