package administrationpage;

import entity.Member;

public class PopingWindowFindMem extends PopingWindowFind{

	
	public void show(Member member)
	{
		text.setText("会员编号： " + member.getMemNum() + "\n姓名： "+member.getName()
		+"\n性别： " + member.getGender() + "\n电话： " + member.getTeleNum() + "\n身份证号： " +member.getIDNum()
		+ "\n会员类型： " + member.getTypeOfMember() + "\n联系人姓名： " + member.getContact().getName() 
		+ "\n联系人电话： " + member.getContact().getTeleNum() + "\n备注： " + member.getNote());
		
	}
	public void setHeaderText()
	{
		alert.setHeaderText("该会员存在,\n详细信息请点“显示详细信息”");
	}
	
}
