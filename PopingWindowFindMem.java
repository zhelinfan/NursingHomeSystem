package administrationpage;

import entity.Member;

public class PopingWindowFindMem extends PopingWindowFind{

	
	public void show(Member member)
	{
		text.setText("��Ա��ţ� " + member.getMemNum() + "\n������ "+member.getName()
		+"\n�Ա� " + member.getGender() + "\n�绰�� " + member.getTeleNum() + "\n���֤�ţ� " +member.getIDNum()
		+ "\n��Ա���ͣ� " + member.getTypeOfMember() + "\n��ϵ�������� " + member.getContact().getName() 
		+ "\n��ϵ�˵绰�� " + member.getContact().getTeleNum() + "\n��ע�� " + member.getNote());
		
	}
	public void setHeaderText()
	{
		alert.setHeaderText("�û�Ա����,\n��ϸ��Ϣ��㡰��ʾ��ϸ��Ϣ��");
	}
	
}
