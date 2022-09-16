package administrationpage;

import java.io.FileInputStream;

import Management.LivingManagement;
import entity.Member;
import entity.PersonCheckIn;
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

public class LivingManagementPage
{

	static private LivingManagementPage singleton;
	//static private AddMemberPage addMemberPage = new AddMemberPage();
	Stage primarySage;
	GridPane gridpane = new GridPane();
	Scene scene = new Scene(gridpane); 
    MyMenu myMenu;
    Text title = new Text("��ס����ϵͳ");
    Button button1 = new Button("�û��Ǽ�");
    Button button2 = new Button("�޸��û���Ϣ");
    Button button3 = new Button("�����û�");
    Button button4 = new Button("ɾ���û�");

    ObservableList<PersonCheckIn> list = FXCollections.observableArrayList();
    TableView<PersonCheckIn> tableView = new TableView<PersonCheckIn>(list);
    Image image;
    ImageView imageView;
	//��̬ģʽ
		private LivingManagementPage()
		{
			
		}
		
		static public LivingManagementPage getLivingManagementPage()
		{
			if(singleton == null)
				singleton = new LivingManagementPage();
			return singleton;
		}
    //start
		public void start(Stage primaryStage) throws Exception {
			
			this.primarySage = primaryStage;
			if(image == null || imageView == null || myMenu ==null)
			{
				image = new Image(new FileInputStream("lib/lvse.jpg")); 
			    imageView = new ImageView(image); 
			    imageView.setFitHeight(500); 
			    imageView.setFitWidth(700); 
			    myMenu = new MyMenu(primaryStage);
			   
			    myMenu.function();				
				buttonfunction();
			}
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("��Ա����ҳ��"); 
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
	
	public void initialList()
	{
		for(PersonCheckIn personCheckIn : LivingManagement.getLivingManagement().getlistPersonCheckIn())
		{
			list.add(personCheckIn);
		}
	}
	public void setTableView()
	{
		initialList();
		tableView = new TableView<PersonCheckIn>(list);
		
		TableColumn<PersonCheckIn, String> tc_Name = new TableColumn<PersonCheckIn, String>("����");
		tc_Name.setCellValueFactory(new PropertyValueFactory<PersonCheckIn, String>("Name"));
		
		TableColumn<PersonCheckIn, String> tc_G = new TableColumn<PersonCheckIn, String>("�Ա�");
		tc_G.setCellValueFactory(new PropertyValueFactory<PersonCheckIn, String>("Gender"));
		
		TableColumn<PersonCheckIn, String> tc_TeleNum = new TableColumn<PersonCheckIn, String>("�绰����");
		tc_TeleNum.setCellValueFactory(new PropertyValueFactory<PersonCheckIn, String>("TeleNum"));
		
		TableColumn<PersonCheckIn, Member> tc_ContactMember = new TableColumn<PersonCheckIn, Member>("��ϵ��Ա");
		tc_ContactMember.setCellValueFactory(new PropertyValueFactory<PersonCheckIn, Member>("ContactMember"));
		
		TableColumn<PersonCheckIn, String> tc_Location = new TableColumn<PersonCheckIn, String>("��ס��ַ");
		tc_Location.setCellValueFactory(new PropertyValueFactory<PersonCheckIn, String>("Location"));
		
		TableColumn<PersonCheckIn, String> tc_Relationship = new TableColumn<PersonCheckIn, String>("��ϵ");
		tc_Relationship.setCellValueFactory(new PropertyValueFactory<PersonCheckIn, String>("Relationship"));
		
		TableColumn<PersonCheckIn, String> tc_Entering = new TableColumn<PersonCheckIn, String>("��ס��ʼʱ��");
		tc_Entering.setCellValueFactory(new PropertyValueFactory<PersonCheckIn, String>("TimeOfEntering"));
		
		TableColumn<PersonCheckIn, String> tc_Leaving = new TableColumn<PersonCheckIn, String>("��ס����ʱ��");
		tc_Leaving.setCellValueFactory(new PropertyValueFactory<PersonCheckIn, String>("TimeOfLeaving"));
		
		TableColumn<PersonCheckIn, String> tc_Living= new TableColumn<PersonCheckIn, String>("��ס����");
		tc_Living.setCellValueFactory(new PropertyValueFactory<PersonCheckIn, String>("TypeOfLiving"));
		//tableView.getColumns().add(tc_Button);
		tableView.getColumns().add(tc_Name);
		tableView.getColumns().add(tc_G);
		tableView.getColumns().add(tc_TeleNum);
		tableView.getColumns().add(tc_ContactMember);
		tableView.getColumns().add(tc_Location);
		tableView.getColumns().add(tc_Relationship);
		tableView.getColumns().add(tc_Entering);
		tableView.getColumns().add(tc_Leaving);
		tableView.getColumns().add(tc_Living);
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
					new AddPersonCheckIn(list).start();
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
					 new ChangePersonCheckInPage(list).start();
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
					 new FindPersonCheckIn().start();
				} catch (Exception e) {

					e.printStackTrace();
				}			  
			}
		
	    });
		
		 button4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
				
					 try {
						 new RemovePersonCheckIn(list).start();
					} catch (Exception e) {

						e.printStackTrace();
					}			  
				}
			
		    });
	
	}

}
