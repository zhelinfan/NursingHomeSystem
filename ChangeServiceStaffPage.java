package administrationpage;

import Management.BusManagement;
import Management.LivingManagement;
import Management.ServiceStaffManagement;
import entity.Bus;
import entity.LifeServiceStaff;
import entity.LogisticsServiceStaff;
import entity.PersonCheckIn;
import entity.ServiceStaff;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChangeServiceStaffPage extends AC_ServiceStaffPage
{
	Stage stage1 = new Stage();
	GridPane gridpane1 = new GridPane();
	Scene scene1 = new Scene(gridpane1);
	Text title1 = new Text("查找用户");
	final ToggleGroup tg1 = new ToggleGroup();
	RadioButton buttonMemNum = new RadioButton("用户账号");
	RadioButton buttonTeleNum = new RadioButton("电话号码");
	TextField textFielda = new TextField();
//	TextField textFieldb = new TextField();
	Button button3 = new Button("确定");
	Button button4 = new Button("退出");

	ServiceStaff serviceStaff;
	ServiceStaffManagement SSM = ServiceStaffManagement.getServiceStaffManagement();
	LivingManagement LM = LivingManagement.getLivingManagement();
	BusManagement BusM = BusManagement.getBusManagement();
	
	public ChangeServiceStaffPage(ObservableList<ServiceStaff> list)
	{
		super(list);
		getTitle().setText("修改用户信息");
		
	}

	public void start()
	{
		iniStage1();
		
		addOrChange();

	}
	@Override
	public void addOrChange()
	{
		button3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
		     try {
		    	    PopingWindowF_CSS ppwfcss = new PopingWindowF_CSS();
		    	    
		    	    if(buttonMemNum.isSelected())
		    			serviceStaff = SSM.findServiceStaff5(Integer.parseInt(textFielda.getText()));
		    		else
		    			serviceStaff = SSM.findServiceStaff4(textFielda.getText());
		    	    
				    if(serviceStaff != null 
				    	&& (LoginPage.getLogingPage().getSerServiceStaff().getPermission().startsWith("超级管家")
				    		||serviceStaff.getAccount() == LoginPage.getLogingPage().getSerServiceStaff().getAccount()))
					{
						ppwfcss.show(serviceStaff);
						ppwfcss.initial();
						stage1.close();
						setInfor(ppwfcss);
						changeInfor();
						
					}
					else if(serviceStaff == null)
					{
						PopingWindowNonExist.getPopingWindow().initial();
					}
					else 
					{
						new PopingWindowNoRight().initial();
					}
			     }catch(Exception e)
			     {
//			    	 e.printStackTrace();
			    	 PopingWindowNonExist.getPopingWindow().initial();
			     }

			}
		});
		
	}
	
	private void iniStage1()
	{
		
		new CloseButton(button4, stage1).close();
		
		title1.setFont(Font.font("HeiTi", FontWeight.BOLD, FontPosture.REGULAR, 20));
		buttonMemNum.setSelected(true);
		buttonMemNum.setToggleGroup(tg1);
		buttonTeleNum.setToggleGroup(tg1);
		textFielda.setPromptText("用户账号/电话号码");



		gridpane1.add(title1, 0, 0, 3, 1);
		gridpane1.add(buttonMemNum, 2, 2);
		gridpane1.add(buttonTeleNum, 2, 3);
		gridpane1.add(textFielda, 2, 4, 2, 1);
		gridpane1.add(button3, 3, 5);
		gridpane1.add(button4, 4, 5);
		GridPane.setHalignment(button3, HPos.RIGHT);
		
		gridpane1.setVgap(10);
		gridpane1.setHgap(10);
		gridpane1.setPadding(new Insets(10, 5, 10, 5));
		gridpane1.setStyle("-fx-background-color: FFF5EE;");
		gridpane1.setAlignment(Pos.CENTER);
		stage1.setScene(scene1);
		stage1.setTitle("用户管理页面");
		stage1.setWidth(350);
		stage1.setHeight(250);
		stage1.show();
		
	

	}

	private void setInfor(PopingWindowF_CSS ppwfcss)
	{
		Button buttonfcss = ppwfcss.getButton();
		
		buttonfcss.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent arg0)
			{
				iniStage();
				ppwfcss.hide();
				textField3.setText(serviceStaff.getName());
				textField4.setText(serviceStaff.getGender());
				textField5.setText(serviceStaff.getTeleNum());
				textField6.setText(serviceStaff.getIDNum());
				if(serviceStaff.getAccount() != LoginPage.getLogingPage().getSerServiceStaff().getAccount())
				{
					textField1.setText(String.valueOf(serviceStaff.getAccount()));
					textField2.setText("******"); 
					textField3.setText(serviceStaff.getName());
					textField4.setText(serviceStaff.getGender());
					textField5.setText(serviceStaff.getTeleNum());
					textField6.setText(serviceStaff.getIDNum());
					textField1.setEditable(false);
					textField2.setEditable(false);
					textField3.setEditable(false);
					textField4.setEditable(false);
					textField5.setEditable(false);
					textField6.setEditable(false);
				}
				else
				{
					textField1.setText(String.valueOf(serviceStaff.getAccount()));
					textField2.setText(serviceStaff.getPassword());  
					textField3.setText(serviceStaff.getName());
					textField4.setText(serviceStaff.getGender());
					textField5.setText(serviceStaff.getTeleNum());
					textField6.setText(serviceStaff.getIDNum());
				}
				
				if(serviceStaff.getPermission().startsWith("生活管家"))
				{
					String arr[] = serviceStaff.getPermission().split(" ");
					rButton2.setSelected(true);
					PersonCheckIn personCheckIn = LM.findPersonCheckIn1(arr[3]);
					textField9.setText(arr[1]);
					textField7.setText(personCheckIn.getLocation());

				}
				else if(serviceStaff.getPermission().startsWith("后勤管家"))
				{
					String arr[] = serviceStaff.getPermission().split(" ");
					
					rButton3.setSelected(true);
					textField8.setText((arr[1]));
				}
			}
		});
		
	}
	
	private void changeInfor()
	{
		
		button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				
				int index = list.indexOf(serviceStaff);
				int flag = 1;
				if(serviceStaff.getAccount() == LoginPage.getLogingPage().getSerServiceStaff().getAccount())
				{
					if(!textField3.getText().equals(serviceStaff.getName()))
						serviceStaff.setName(textField3.getText());
					if(!textField4.getText().equals(serviceStaff.getGender()))
						  serviceStaff.setGender(textField4.getText());
					if(!textField5.getText().equals(serviceStaff.getTeleNum()))
						serviceStaff.setTeleNum(textField5.getText());
					if(!textField6.getText().equals(serviceStaff.getIDNum()))
						serviceStaff.setIDNum(textField6.getText());
					
			 	}	
				
				if(LoginPage.getLogingPage().getSerServiceStaff().getPermission().startsWith("超级管家"))
				 {
						if(rButton1.isSelected())
							SSM.getListServiceStaff().set(index,new ServiceStaff(serviceStaff.getName(), serviceStaff.getGender(),
									             serviceStaff.getTeleNum(), serviceStaff.getIDNum(), 
									             serviceStaff.getAccount(),serviceStaff.getPassword(), "超级管家"));
						else if(rButton2.isSelected())
						{
						  PersonCheckIn personCheckIn = LM.findPersonCheckIn2(textField9.getText(),textField7.getText());
						  SSM.getListServiceStaff().set(index,new LifeServiceStaff(serviceStaff.getName(), serviceStaff.getGender(),
					             serviceStaff.getTeleNum(), serviceStaff.getIDNum(), 
					             serviceStaff.getAccount(),serviceStaff.getPassword(), personCheckIn));
						}
						else
						{
							Bus bus = BusM.findBus(textField8.getText());
							SSM.getListServiceStaff().set(index,new LogisticsServiceStaff(serviceStaff.getName(), serviceStaff.getGender(),
						             serviceStaff.getTeleNum(), serviceStaff.getIDNum(), 
						             serviceStaff.getAccount(),serviceStaff.getPassword(), bus));
						}
				   
				 }
				if(LoginPage.getLogingPage().getSerServiceStaff().getPermission().startsWith("生活管家"))
				{
					if(rButton2.isSelected())
					{
					  PersonCheckIn personCheckIn = LM.findPersonCheckIn2(textField9.getText(),textField7.getText());
					  SSM.getListServiceStaff().set(index,new LifeServiceStaff(serviceStaff.getName(), serviceStaff.getGender(),
				             serviceStaff.getTeleNum(), serviceStaff.getIDNum(), 
				             serviceStaff.getAccount(),serviceStaff.getPassword(), personCheckIn));
					  flag = 1;
					}
					else
						{
						   flag=0;  
					    	new PopingWindowNoRight().initial();
						}
						
				}
				if(LoginPage.getLogingPage().getSerServiceStaff().getPermission().startsWith("后勤管家"))
				{
					if(rButton3.isSelected())
					{
						Bus bus = BusM.findBus(textField8.getText());
						SSM.getListServiceStaff().set(index,new LogisticsServiceStaff(serviceStaff.getName(), serviceStaff.getGender(),
					             serviceStaff.getTeleNum(), serviceStaff.getIDNum(), 
					             serviceStaff.getAccount(),serviceStaff.getPassword(), bus));
						flag = 1;
					}
					else
					{
					   flag=0;  
				    	new PopingWindowNoRight().initial();
					}
						
				}
				
				if(flag ==1)
				{
					SSM.delete();
				    SSM.save();
				    list.clear();
				    ServiceStaffManagementPage.getServiceStaffManagementPage().setTableView();
					
					
					stage.hide();
				}
			}
		});
	}

}
