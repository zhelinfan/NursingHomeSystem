package administrationpage;

import java.io.FileInputStream;

import Management.ServiceStaffManagement;
import entity.ServiceStaff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ServiceStaffManagementPage
{
	static private ServiceStaffManagementPage singleton;
	//static private AddMemberPage addMemberPage = new AddMemberPage();
	GridPane gridpane = new GridPane();
	Scene scene = new Scene(gridpane); 
	 MyMenu myMenu;
    Text title = new Text("用户管理系统");
    Button button1 = new Button("增加服务人员");
    Button button2 = new Button("修改服务人员信息");
    Button button3 = new Button("查找服务人员");
    Button button4 = new Button("删除服务人员");
    
    ObservableList<ServiceStaff> list = FXCollections.observableArrayList();
    TableView<ServiceStaff> tableView = new TableView<ServiceStaff>(list);
    Image image;
    ImageView imageView;
    ServiceStaffManagement SSM = ServiceStaffManagement.getServiceStaffManagement();
		private ServiceStaffManagementPage()
		{
			
		}
		
		static public ServiceStaffManagementPage getServiceStaffManagementPage()
		{
			if(singleton == null)
				singleton = new ServiceStaffManagementPage();
			return singleton;
		}
		
		public void start(Stage primaryStage) throws Exception {
			
			if(image == null || imageView == null || myMenu ==null)
			{
				image = new Image(new FileInputStream("lib/fense.jpg")); 
			    imageView = new ImageView(image); 
			    imageView.setFitHeight(520); 
			    imageView.setFitWidth(700); 
			    myMenu = new MyMenu(primaryStage);
			    
			    myMenu.function();
			    buttonfunction();
			}
			primaryStage.setScene(scene);
		    
		    primaryStage.setTitle("用户管理页面"); 
		    primaryStage.setWidth(700);
		    primaryStage.setHeight(500);
		    primaryStage.show();
		    
//			menuBar.getMenus().addAll(menu1,menu2,menu3,menu4);
			
			//gridpane.setMinWidth(700);
			
			gridpane.add(imageView, 0, 0,8,8);
			gridpane.add(myMenu.getMenuBar(), 0, 0,14,1);
		    gridpane.add(title, 1, 1 ,5,1);
		    gridpane.add(button1, 3, 2);
		    gridpane.add(button2, 4, 2);
		    gridpane.add(button3, 5, 2);
		    gridpane.add(button4, 6, 2);
			gridpane.setStyle("-fx-background-color: BCD2EE");	
			GridPane.setHalignment(title, HPos.CENTER);
			//gridpane.setAlignment(Pos.BASELINE_CENTER);
			title.setFont(Font.font("KaiTi", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 35));
			gridpane.setVgap(15);
		    gridpane.setHgap(10);
		   // gridpane.setPadding(new Insets(0,0,10,0));
		    
		    	    
			
			setTableView();
			
			
			
//			buttonFind(button3);
//			buttonRemove(button4);
			
			tableView.setPrefSize(600,300);
			gridpane.add(tableView, 3, 3,5,5);
			
			//gridpane.setGridLinesVisible(true);
					
			
		        
		  
			
		}
	public void start1(Stage primaryStage) throws Exception
	{
		image = new Image(new FileInputStream("lib/fense.jpg")); 
	    imageView = new ImageView(image); 
	    imageView.setFitHeight(520); 
	    imageView.setFitWidth(700); 

	    
	    buttonfunction();
	    
	    primaryStage.setScene(scene);
	    
	    primaryStage.setTitle("用户管理页面"); 
	    primaryStage.setWidth(700);
	    primaryStage.setHeight(500);
	    primaryStage.show();
	    
	    
	    gridpane.add(imageView, 0, 0,8,8);
	    gridpane.add(title, 1, 1 ,5,1);
	    gridpane.add(button2, 3, 2);
	    gridpane.add(button3, 4, 2);
		gridpane.setStyle("-fx-background-color: BCD2EE");	
		GridPane.setHalignment(title, HPos.CENTER);
		title.setFont(Font.font("KaiTi", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 35));
		gridpane.setVgap(15);
	    gridpane.setHgap(10);
	    	    
		
		setTableView();
		
		
		tableView.setPrefSize(600,300);
		gridpane.add(tableView, 3, 3,5,5);
		
	    
	}
	
	public ObservableList<ServiceStaff> getList()
	{
		return list;
	}

	public void initialList(ObservableList<ServiceStaff> list)
	{
		for(ServiceStaff serviceStaff : SSM.getListServiceStaff())
		{
			list.add(serviceStaff);
		}
	}
	public void setTableView()
	{
		initialList(list);
		tableView = new TableView<ServiceStaff>(list);
		
		TableColumn<ServiceStaff, Number> tc_Account = new TableColumn<ServiceStaff, Number>("账号");
		tc_Account.setCellValueFactory(new PropertyValueFactory<ServiceStaff, Number>("Account"));
		
		TableColumn<ServiceStaff, String> tc_Name = new TableColumn<ServiceStaff, String>("名字");
		tc_Name.setCellValueFactory(new PropertyValueFactory<ServiceStaff, String>("Name"));
		
		TableColumn<ServiceStaff, String> tc_G = new TableColumn<ServiceStaff, String>("性别");
		tc_G.setCellValueFactory(new PropertyValueFactory<ServiceStaff, String>("Gender"));
		
		TableColumn<ServiceStaff, String> tc_TeleNum = new TableColumn<ServiceStaff, String>("电话号码");
		tc_TeleNum.setCellValueFactory(new PropertyValueFactory<ServiceStaff, String>("TeleNum"));
		
		TableColumn<ServiceStaff, String> tc_IDNum = new TableColumn<ServiceStaff, String>("身份证号");
		tc_IDNum.setCellValueFactory(new PropertyValueFactory<ServiceStaff, String>("IDNum"));
		
		TableColumn<ServiceStaff, String> tc_Permission = new TableColumn<ServiceStaff, String>("权限");
		tc_Permission.setCellValueFactory(new PropertyValueFactory<ServiceStaff, String>("Permission"));
		
//		TableColumn<ServiceStaff, String> tc_PorB = new TableColumn<ServiceStaff, String>("权限");
//		tc_PorB.setCellValueFactory(new PropertyValueFactory<ServiceStaff, String>("Permission"));
		

		tc_Account.setPrefWidth(95);
		tableView.getColumns().add(tc_Account);
		tableView.getColumns().add(tc_Name);
		tableView.getColumns().add(tc_G);
		tableView.getColumns().add(tc_TeleNum);
		tableView.getColumns().add(tc_IDNum);
		tableView.getColumns().add(tc_Permission);


		tableView.setItems(list);
	}
	
	public void clear()
	{
		gridpane.getChildren().clear();
		tableView.getItems().removeAll(list);
	}
	
	public void buttonfunction()
	{
		 button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
				
					 try {
						 new AddServiceStaffPage(list).start();
					} catch (Exception e) {

						e.printStackTrace();
					}			  
				}
			
		    });
	
	
	
		 button3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
				
					 try {
						 new FindServiceStaffPage().start();
						 tableView.setItems(list);
					} catch (Exception e) {

						e.printStackTrace();
					}			  
				}
			
		    });
	
	 button2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
				
					 try {
						 new ChangeServiceStaffPage(list).start();
					} catch (Exception e) {

						e.printStackTrace();
					}			  
				}
			
		    });
	

		 button4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
				
					 try {
						 new RemoveServiceStaffPage(list).start();
					} catch (Exception e) {

						e.printStackTrace();
					}			  
				}
			
		    });
	}
}
