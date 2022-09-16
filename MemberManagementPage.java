package administrationpage;


import java.io.FileInputStream;
import java.util.Date;

import Management.MemberManagement;
import entity.Member;
import entity.Person;
import entity.PersonCheckIn;
import javafx.application.Application;
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

public class MemberManagementPage extends Application{
	
	static private MemberManagementPage singleton;
	//static private AddMemberPage addMemberPage = new AddMemberPage();
	Stage primarySage;
	GridPane gridpane = new GridPane();
	Scene scene = new Scene(gridpane); 
    MyMenu myMenu;
    Text title = new Text("会员管理系统");
    Button button1 = new Button("增加会员");
    Button button2 = new Button("修改会员信息");
    Button button3 = new Button("查找会员");
    Button button4 = new Button("删除会员");

    ObservableList<Member> list = FXCollections.observableArrayList();
    TableView<Member> tableView = new TableView<Member>(list);
    Image image;
    ImageView imageView;
	//单态模式
		private MemberManagementPage()
		{
			
		}
		
		static public MemberManagementPage getMemberManagementPage()
		{
			if(singleton == null)
				singleton = new MemberManagementPage();
			return singleton;
		}
    //start
		@Override
		public void start(Stage primaryStage) throws Exception {
			
			this.primarySage = primaryStage;
			if(image == null || imageView == null || myMenu ==null)
			{
				image = new Image(new FileInputStream("lib/beijing.jpg")); 
			    imageView = new ImageView(image); 
			    imageView.setFitHeight(500); 
			    imageView.setFitWidth(700); 
			    myMenu = new MyMenu(primaryStage);
			   
			    myMenu.function();				
				buttonfunction();
			}
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("会员管理页面"); 
		    primaryStage.setWidth(700);
		    primaryStage.setHeight(500);
		    primaryStage.show();
		    
			
			
			//gridpane.setMinWidth(700);
			
			gridpane.add(imageView, 0, 0,8,8);
			gridpane.add(myMenu.getMenuBar(), 0, 0,14,1);
		    gridpane.add(title, 1, 1 ,5,1);
		    gridpane.add(button1, 3, 2);
		    gridpane.add(button2, 4, 2);
		    gridpane.add(button3, 5, 2);
		    gridpane.add(button4, 6, 2);
			gridpane.setStyle("-fx-background-color: FFFACD;");	
			GridPane.setHalignment(title, HPos.CENTER);
			title.setFont(Font.font("FangSong", FontWeight.BOLD, FontPosture.REGULAR, 35));
			gridpane.setVgap(15);
		    gridpane.setHgap(10);
		   // gridpane.setPadding(new Insets(0,0,10,0));
		    
		    	    
			
			setTableView();
			
			
			tableView.setPrefSize(600,300);
			gridpane.add(tableView, 3, 3,5,5);
			
//			gridpane.setGridLinesVisible(true);

		}
	public void clear()
	{
		gridpane.getChildren().clear();
		tableView.getItems().removeAll(list);
		
	}
		
	public Stage getPriStage()
	{
		return primarySage;
	}
	public void initialList(ObservableList<Member> list)
	{
		for(Member member : MemberManagement.getListMember())
		{
			list.add(member);
		}
	}
	public void setTableView()
	{
		initialList(list);
		tableView = new TableView<Member>(list);
		
		TableColumn<Member, Number> tc_MemNum = new TableColumn<Member, Number>("会员编号");
		tc_MemNum.setCellValueFactory(new PropertyValueFactory<Member, Number>("MemNum"));
		
		TableColumn<Member, String> tc_Name = new TableColumn<Member, String>("姓名");
		tc_Name.setCellValueFactory(new PropertyValueFactory<Member, String>("Name"));
		
		TableColumn<Member, String> tc_G = new TableColumn<Member, String>("性别");
		tc_G.setCellValueFactory(new PropertyValueFactory<Member, String>("Gender"));
		
		TableColumn<Member, String> tc_TeleNum = new TableColumn<Member, String>("电话号码");
		tc_TeleNum.setCellValueFactory(new PropertyValueFactory<Member, String>("TeleNum"));
		
		TableColumn<Member, String> tc_IDNum = new TableColumn<Member, String>("身份证号");
		tc_IDNum.setCellValueFactory(new PropertyValueFactory<Member, String>("IDNum"));
		
		TableColumn<Member, Date> tc_Date = new TableColumn<Member, Date>("出生日期");
		tc_Date.setCellValueFactory(new PropertyValueFactory<Member, Date>("BirthDate"));
		
		TableColumn<Member, String> tc_TypeOfMember = new TableColumn<Member, String>("会员类型");
		tc_TypeOfMember.setCellValueFactory(new PropertyValueFactory<Member, String>("TypeOfMember"));
		
		TableColumn<Member, PersonCheckIn> tc_Person = new TableColumn<Member, PersonCheckIn>("联系人");
		tc_Person.setCellValueFactory(new PropertyValueFactory<Member, PersonCheckIn>("Contact"));
		
		TableColumn<Member, String> tc_Note = new TableColumn<Member, String>("备注");
		tc_Note.setCellValueFactory(new PropertyValueFactory<Member, String>("Note"));
		
		//tableView.getColumns().add(tc_Button);
		tableView.getColumns().add(tc_MemNum);
		tableView.getColumns().add(tc_Name);
		tableView.getColumns().add(tc_G);
		tableView.getColumns().add(tc_TeleNum);
		tableView.getColumns().add(tc_IDNum);
		tableView.getColumns().add(tc_Date);
		tableView.getColumns().add(tc_TypeOfMember);
		tableView.getColumns().add(tc_Person);
		tableView.getColumns().add(tc_Note);
		tableView.setItems(list);
	}
	 
	public void buttonfunction()
	{
		button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{

				try
				{
					new AddMemberPage(list).start();
				} catch (Exception e)
				{

					e.printStackTrace();
				}
			}

		});
		
		button2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
			
				 try {
					 new ChangeMemberPage(list).start();
					 tableView.setItems(list);
				} catch (Exception e) {

					e.printStackTrace();
				}			  
			}
		
	    });
		
		button3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
			
				 try {
					 new FindMemberPage().start();
				} catch (Exception e) {

					e.printStackTrace();
				}			  
			}
		
	    });
		
		 button4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
				
					 try {
						 new RemoveMemberPage(list).start();
					} catch (Exception e) {

						e.printStackTrace();
					}			  
				}
			
		    });
		
	}
	
}
