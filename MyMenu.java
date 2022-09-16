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
    Menu menu1 = new Menu("会员管理");
    Menu menu2 = new Menu("房屋管理");
    Menu menu3 = new Menu("入住管理");
    Menu menu4 = new Menu("用户管理");
    MenuItem menuItem1 = new MenuItem("会员管理页面");
    MenuItem menuItem2 = new MenuItem("房屋管理页面");
    MenuItem menuItem3 = new MenuItem("入住管理页面");
    MenuItem menuItem4 = new MenuItem("用户管理页面");
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
