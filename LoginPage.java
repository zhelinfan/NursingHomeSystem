package administrationpage;



import java.io.FileInputStream;

import Management.ServiceStaffManagement;
import entity.ServiceStaff;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPage extends Application{
	
	static private LoginPage singleton = new LoginPage();
	Text textAcc = new Text("账户");      
	Text textPass = new Text("密码"); 	
	TextField textFieldAcc = new TextField();    
	PasswordField textFieldPass = new PasswordField();     
	Button button1 = new Button("确定"); 
	Button button2 = new Button("返回"); 
	
	Pane pane = new Pane();
	Image image;
	ImageView imageView;
	Scene scene = new Scene(pane);
	ServiceStaff serviceStaff;
	private LoginPage()
	{
		
	}
	
	static public LoginPage getLogingPage()
	{
		return singleton;
	}

	public void start(Stage primaryStage) throws Exception {
		//创建
		
	 
	    //装饰
	    textAcc.setFont(Font.font("SimHei", FontWeight.BOLD, FontPosture.REGULAR, 15));
	    textPass.setFont(Font.font("SimHei", FontWeight.BOLD, FontPosture.REGULAR, 15));
	    
	    button1.setStyle("-fx-background-color: #36648B; -fx-text-fill: white;"); 
	    button2.setStyle("-fx-background-color: #36648B; -fx-text-fill: white;"); 
	    	    
	    image = new Image(new FileInputStream("lib/login2.jpg")); 
	    imageView = new ImageView(image); 
	    imageView.setFitHeight(250); 
	    imageView.setFitWidth(400); 
	       
	    textAcc.setLayoutX(80);
	    textAcc.setLayoutY(75);
	    textPass.setLayoutX(80);
	    textPass.setLayoutY(120);
	    textFieldAcc.setLayoutX(125);
	    textFieldAcc.setLayoutY(60);
	    textFieldPass.setLayoutX(125);
	    textFieldPass.setLayoutY(105);
	    button1.setLayoutX(150);
	    button1.setLayoutY(150);
	    button2.setLayoutX(210);
	    button2.setLayoutY(150);
	    
	    pane.getChildren().addAll(imageView,textAcc,textPass,button1,button2,textFieldAcc,textFieldPass);
	         
	    primaryStage.setScene(scene);
	    
	    primaryStage.setTitle("活力长者社区"); 
	    primaryStage.setWidth(400);
	    primaryStage.setHeight(250);
	        

	    
	    button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			public void handle(MouseEvent arg0) {
				
				  button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
				 
				  try {
					    if(textFieldAcc.getText() == "")
					    {
					    	System.out.print("kongbai");
					    }
					    else
					    {
					    	serviceStaff =  ServiceStaffManagement.findServiceStaff1(Integer.valueOf(textFieldAcc.getText()),textFieldPass.getText());					   
						  if(serviceStaff == null)
						  {		
							  PopingWindowNonExist.getPopingWindow().initial();   
						  }
						  else  if(serviceStaff.getPermission().startsWith("生活管家") || serviceStaff.getPermission().startsWith("后勤管家")) 
						  {
							  ServiceStaffManagementPage.getServiceStaffManagementPage().start1(primaryStage);
							 
						  }
						  else if (serviceStaff.getPermission().startsWith("超级管家")) 
						  {
							  MemberManagementPage.getMemberManagementPage().start(primaryStage); 
							  
						  }
					    }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
			}
		
	    });
	
	    ButtonExit.buttonExit(button1);
	    ButtonMove.buttonMove(button1);
	    
	  //button2
	    ButtonLeft.buttonLeft(button2);
	    ButtonExit.buttonExit(button2);
	    ButtonMove.buttonMove(button2);
	    
	    primaryStage.show();
	}
   public ServiceStaff getSerServiceStaff()
   {
	   return serviceStaff;
   }
}
