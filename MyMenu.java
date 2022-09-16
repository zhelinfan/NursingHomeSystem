package administrationpage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MyMenu
{
	MyMenu myMenu;
	MenuBar menuBar= new MenuBar();
    Menu menu1 = new Menu("��Ա����");
    Menu menu2 = new Menu("���ݹ���");
    Menu menu3 = new Menu("��ס����");
    Menu menu4 = new Menu("�û�����");
    MenuItem menuItem1 = new MenuItem("��Ա����ҳ��");
    MenuItem menuItem2 = new MenuItem("���ݹ���ҳ��");
    MenuItem menuItem3 = new MenuItem("��ס����ҳ��");
    MenuItem menuItem4 = new MenuItem("�û�����ҳ��");
	Stage stage;

	
	public MyMenu(Stage stage)
	{
//		this.stage = MemberManagementPage.getMemberManagementPage().getPriStage();
		this.stage = stage;
		menu1.getItems().add(menuItem1);
		menu2.getItems().add(menuItem2);
		menu3.getItems().add(menuItem3);
		menu4.getItems().add(menuItem4);
		menuBar.getMenus().addAll(menu1,menu2,menu3,menu4);
	}
//	public MyMenu getmyMenu()
//	{
//		if(myMenu == null)
//			myMenu = new MyMenu();
//		return myMenu;
//	}
	public MenuBar getMenuBar()
	{
		return menuBar;
	}
    
	public void function()
	{
		changeToMemPage();
		changeToBMPage();
		changeToLMPage();
		changeToSSMPage();
	}
	public void changeToMemPage()
	{
		menuItem1.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0)
			{
				
				try
				{
					MemberManagementPage.getMemberManagementPage().clear();
					MemberManagementPage.getMemberManagementPage().start(stage);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
			}
			
		});
		
			
		
	}
	
	
	public void changeToLMPage()
	{
		menuItem3.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0)
			{
				
				try
				{
					LivingManagementPage.getLivingManagementPage().clear();
					LivingManagementPage.getLivingManagementPage().start(stage);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
			}
			
		});
		
			
		
	}
	public void changeToBMPage()
	{
		menuItem2.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0)
			{
				
				try
				{
					BuildingManagementPage.getBuildingManagementPage().clear();
					BuildingManagementPage.getBuildingManagementPage().start(stage);
					
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
			}
			
		});
	}
	
	public void changeToSSMPage()
	{
		
		menuItem4.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0)
			{
				try
				{
					ServiceStaffManagementPage.getServiceStaffManagementPage().clear();
					ServiceStaffManagementPage.getServiceStaffManagementPage().start(stage);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
			}
			
		});
			
		
	}
}
