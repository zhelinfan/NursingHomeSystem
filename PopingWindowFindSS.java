package administrationpage;

import entity.ServiceStaff;

public class PopingWindowFindSS extends PopingWindowFind
{

	public void show(ServiceStaff serviceStaff)
	{
		text.setText("������ " + serviceStaff.getName() 
		+ "\n�Ա� "+ serviceStaff.getGender()
		+"\n�绰�� " + serviceStaff.getTeleNum()
		+ "\n���֤�ţ� " + serviceStaff.getIDNum()
		+"\nȨ�ޣ� "+ serviceStaff.getPermission());
	}
	@Override
	public void setHeaderText()
	{
		alert.setHeaderText("���û�����,\n��ϸ��Ϣ��㡰��ʾ��ϸ��Ϣ��");
		
	}

}
