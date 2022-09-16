package administrationpage;

import entity.ServiceStaff;

public class PopingWindowFindSS extends PopingWindowFind
{

	public void show(ServiceStaff serviceStaff)
	{
		text.setText("姓名： " + serviceStaff.getName() 
		+ "\n性别： "+ serviceStaff.getGender()
		+"\n电话： " + serviceStaff.getTeleNum()
		+ "\n身份证号： " + serviceStaff.getIDNum()
		+"\n权限： "+ serviceStaff.getPermission());
	}
	@Override
	public void setHeaderText()
	{
		alert.setHeaderText("该用户存在,\n详细信息请点“显示详细信息”");
		
	}

}
