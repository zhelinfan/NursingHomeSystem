package administrationpage;

import java.io.FileInputStream;

import Management.BuildingManagement;
import Management.MemberManagement;
import entity.Building;
import entity.House;
import entity.Room;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BuildingManagementPage //implements Iterable<TreeItem<String>>
{
	static private BuildingManagementPage singleton;
	GridPane gridpane = new GridPane();
	Scene scene = new Scene(gridpane); 
	 MyMenu myMenu;
    Text title = new Text("房屋管理系统");
    Button button1 = new Button("新增节点");
    Button button2 = new Button("查询或维护房间");
    Button button3 = new Button("删除");
    Button button4 = new Button("统计");
    Button button5 = new Button("完成维护");
    Button button6 = new Button("清空");
 
    
    TreeItem<String> bui = new TreeItem<String>("房屋总览"); 
    TreeView<String> treeView = new TreeView<String>(bui);
    ObservableList<TreeItem<String>> listBuilding;

    
    Image image;
    ImageView imageView;
    
    Text text1 = new Text("楼盘");
    Text text2 = new Text("楼号");
    Text text3 = new Text("房间");
    Text text4 = new Text("房间类型");
    Text text5 = new Text("房间状态");
    Text text6 = new Text("所属会员编号");
    Text text7 = new Text("购房合同编号");
    Text text8 = new Text("目前住户人数");
    TextField textField1 = new TextField(); 
    TextField textField2 = new TextField(); 
    TextField textField3 = new TextField(); 
    TextField textField4 = new TextField(); 
    TextField textField5 = new TextField(); 
    TextField textField6 = new TextField(); 
    TextField textField7 = new TextField(); 
    TextField textField8 = new TextField(); 

    BuildingManagement BM =BuildingManagement.getBuildingManagement();
    
		private BuildingManagementPage()
		{
			
		}
		
		static public BuildingManagementPage getBuildingManagementPage()
		{
			if(singleton == null)
				singleton = new BuildingManagementPage();
			return singleton;
		}
		
		public void start(Stage primaryStage) throws Exception {
			
	        primaryStage.setScene(scene);
		    
		    primaryStage.setTitle("入住管理页面"); 
		    primaryStage.setWidth(700);
		    primaryStage.setHeight(500);
		    primaryStage.show();
			System.out.print(myMenu);
			if(image != null)
			{
//				gridpane.setGridLinesVisible(false);
				GridPane.setHalignment(textField7, HPos.LEFT);
			}
			if(image == null || imageView == null || myMenu ==null)
			{
				image = new Image(new FileInputStream("lib/lanse.jpg")); 
			    imageView = new ImageView(image); 
			    imageView.setFitHeight(520); 
			    imageView.setFitWidth(700); 
			    myMenu = new MyMenu(primaryStage);
			    System.out.print("aa");

			    myMenu.function();
			    buttonfunction();
			    
		    }
			
		
			
			//gridpane.setMinWidth(700);
		    GridPane.setHalignment(title, HPos.CENTER);
			//gridpane.setAlignment(Pos.BASELINE_CENTER);
			title.setFont(Font.font("KaiTi", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 35));
			gridpane.setVgap(12);
		    gridpane.setHgap(11);
		    
			gridpane.add(imageView, 0, 0,17,11);
			gridpane.add(myMenu.getMenuBar(), 0, 0,17,1);
		    gridpane.add(title, 2, 1 ,9,1);
		    gridpane.add(button1, 8, 11);
		    gridpane.add(button3, 9, 11);
		    gridpane.add(button2, 12, 2,2,1);
		    gridpane.add(button4, 10, 11);
		    gridpane.add(button5, 13,2);
		    gridpane.add(button6, 14,2);
		    GridPane.setHalignment(button5, HPos.RIGHT);
		    

			gridpane.setStyle("-fx-background-color: BCD2EE");	
			gridpane.add(text1, 12, 3);
			gridpane.add(text2, 12, 4);
			gridpane.add(text3, 12, 5);
			gridpane.add(text4, 12, 6);
			gridpane.add(text5, 12, 7);
			gridpane.add(text6, 14, 3,1,1);
			gridpane.add(text7, 14, 4,1,1);
			gridpane.add(text8, 14, 5,1,1);
			textField1.setPrefSize(110, 10);
			textField2.setPrefSize(100, 10);
			textField3.setPrefSize(100, 10);
			textField4.setPrefSize(100, 10);
			textField5.setPrefSize(100, 10);
			textField6.setPrefSize(110, 10);
			textField7.setPrefSize(100, 10);
			textField8.setPrefSize(100, 10);
			
			gridpane.add(textField1, 13, 3, 1, 1);
			gridpane.add(textField2, 13, 4, 1, 1);
			gridpane.add(textField3, 13, 5, 1, 1);
			gridpane.add(textField4, 13, 6, 1, 1);
			gridpane.add(textField5, 13, 7, 1, 1);
			gridpane.add(textField6, 15, 3, 1, 1);
			gridpane.add(textField7, 15, 4, 1, 1);
			gridpane.add(textField8, 15, 5, 1, 1);
			
//		    gridpane.setPadding(new Insets(0,0,10,0));
		    
			initialTreeView();	 
			treeView.setPrefSize(200,300);
			
			gridpane.add(treeView, 2, 2,9,9);
				
		
//			gridpane.setGridLinesVisible(true);
					
			
			
		}

	public void clear()
	{
		
		for(TreeItem<String> treeItem: treeView.getRoot().getChildren())
		{
			for (TreeItem<String> treeItem1 : treeItem.getChildren())
			{
				treeItem1.getChildren().clear();
			}
			treeItem.getChildren().clear();
			
		}
        treeView.getRoot().getChildren().clear();	
        gridpane.getChildren().clear();

	}
	public void add()
	{
    	gridpane.add(textField6, 15, 3, 1, 1);
		gridpane.add(textField7, 15, 4, 1, 1);
		gridpane.add(textField8, 15, 5, 1, 1);
	}
	public void initialTreeView()
	{

		listBuilding = bui.getChildren();
		for(Building building : BuildingManagement.getBuildingManagement().getListBuilding())
		{
			TreeItem<String> newBuilding = new TreeItem<String>(building.getBuildingName());
			listBuilding.add(newBuilding);
			for(House house : building.getListHouse())
			{
				TreeItem<String> newHouse = new TreeItem<String>(house.getHouseNum());
				newBuilding.getChildren().add(newHouse);
				for(Room room : house.getListRoom())
				{
					TreeItem<String> newRoom = new TreeItem<String>(String.valueOf(room.getRoomNum()));
					newHouse.getChildren().add(newRoom);
				}
			}
		}
		bui.setExpanded(true);
	}
	public TreeItem<String> getBuildings()
	{
		return treeView.getRoot();
	}
	public TreeItem<String> getHouses(Building building)
	{
		for(TreeItem<String> tempBuilding : treeView.getRoot().getChildren())
		{
			if(tempBuilding.getValue().equals(building.getBuildingName()))
				return tempBuilding;
		}
			
		return null;
	}
	public TreeItem<String> getRooms(Building building,House house)
	{
		for(TreeItem<String> tempBuilding : treeView.getRoot().getChildren())
		{
			if(tempBuilding.getValue().equals(building.getBuildingName()))
				for(TreeItem<String> tempHouse : tempBuilding.getChildren())
				{
					if(tempHouse.getValue().equals(house.getHouseNum()))
					 return tempHouse;
				}
		}
			
		return null;
	}
	public TreeItem<String> getRoom(Building building,House house,Room room)
	{
		for(TreeItem<String> tempBuilding : treeView.getRoot().getChildren())
		{
			if(tempBuilding.getValue().equals(building.getBuildingName()))
				for(TreeItem<String> tempHouse : tempBuilding.getChildren())
				{
					if(tempHouse.getValue().equals(house.getHouseNum()))
						for(TreeItem<String> tempRoom : tempHouse.getChildren())
						{
							if(tempRoom.getValue().equals(room.getRoomNum()))
							    return tempRoom;
						}
				}
		}
			
		return null;
	}
	
	public void removeBuildings(Building building)
	{
		int a = treeView.getRoot().getChildren().indexOf(getHouses(building));
		treeView.getRoot().getChildren().remove(a);
	}
	public void removeHouses(Building building,House house)
	{
		int a = treeView.getRoot().getChildren().indexOf(getHouses(building));
		TreeItem<String> buildingItem = treeView.getRoot().getChildren().get(a);
		int b = buildingItem.getChildren().indexOf(getRooms(building, house));
		buildingItem.getChildren().remove(b);
	
	}
	public void removeRooms(Building building,House house,Room room)
	{
		int a = treeView.getRoot().getChildren().indexOf(getHouses(building));
		TreeItem<String> buildingItem = treeView.getRoot().getChildren().get(a);
		int b = buildingItem.getChildren().indexOf(getRooms(building, house));
		TreeItem<String> houseItem = buildingItem.getChildren().get(b);
		int c = houseItem.getChildren().indexOf(getRoom(building, house, room));
		houseItem.getChildren().remove(c);
		
	}
	
	public int sum()
	{
		int sum = 0;
		for(Building building : BuildingManagement.getBuildingManagement().getListBuilding())
		{
			sum += building.buildingLivNum();
		}
		return sum;
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
					new AddBHR().start();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}

		});
		
		button2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{

				try
				{
					new FindRoomPage().start();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}

		});
		
		button4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				Alert alert = new Alert(null);
				alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
				alert.setHeaderText("共有居住人数："+sum());
				alert.setTitle("提示");
				alert.show();
				
			}

		});

		button3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{

				try
				{
					new RemoveBHR().start();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}

		});
		button6.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				textField4.setText("");
				textField5.setText("");
				textField6.setText("");
				textField7.setText("");
				textField8.setText("");
			}

		});
		button5.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent arg0)
			{
				finishChange();
			}

		});
	}
	private void finishChange()
	{
		try
		{
			 Building building = BM.findBuilding(textField1.getText());
			 House house = building.findHouse(textField2.getText());
			 Room room = house.findRoom(textField3.getText());
			if( building != null && house != null && room !=null)
			{							 
				if(!textField4.getText().equals(room.getTypeOfRoom()))
					room.setTypeOfRoom(textField4.getText());
				if(!textField5.getText().equals(room.getConditon()) || Integer.parseInt(textField6.getText()) != room.getMemNum()) 
						
				{
					if(room.getConditon().equals("未售出") 
					&& MemberManagement.findMemberMemNum(Integer.parseInt(textField6.getText())) != null
					&& !Building.hasBought(Integer.parseInt(textField6.getText())))
					  {
						room.setConditon(textField5.getText());
						room.setMemNum(Integer.parseInt(textField6.getText()));
					  }
					else if(!room.getConditon().equals("未售出"))
					{
					  if(!textField5.getText().equals("未出售"))
					   {
						   if(Integer.parseInt(textField6.getText()) == room.getMemNum())
							{
								room.setConditon(textField5.getText());
								room.setMemNum(Integer.parseInt(textField6.getText()));
							}
							else
							{
								if(MemberManagement.findMemberMemNum(Integer.parseInt(textField6.getText())) != null
					         	&& !Building.hasBought(Integer.parseInt(textField6.getText()))) 
								{
									room.setConditon(textField5.getText());
									room.setMemNum(Integer.parseInt(textField6.getText()));
								}
								else	 
								{
								    PopingWindowBHR.getPopingWindow().initial();
								    System.out.println("zaizhe");
								 }
							}
						}
					  else
						{
							room.setConditon(textField5.getText());
							room.setMemNum(0);
						}	
					}
					else
					{	
						   PopingWindowBHR.getPopingWindow().initial();
						   return;
					}
				}
				
				if(Integer.parseInt(textField8.getText()) != room.getLivPerNum())
					room.setLivPerNum(Integer.parseInt(textField8.getText()));
				if(!textField7.getText().equals(room.getSellNum()))
					room.setSellNum(textField7.getText());
				
				if(room.getConditon() != "未售出")
				{
					BM.save();
				
					PopingWindowF_CRoom ppwfc = new PopingWindowF_CRoom();
					
					ppwfc.show(building, house, room);
					ppwfc.initial();
					ppwfc.setHeaderText2();
				}
				else
					PopingWindowReminder.getPopingWindow().initial();
				
			}
			else
				PopingWindowNonExist.getPopingWindow().initial();
//
		} catch (Exception e)
		{
			e.printStackTrace();
//			PopingWindowNonExist.getPopingWindow().initial();
		}
	}
	public TextField getTextField1()
	{
		return textField1;
	}

	public void setTextField1(TextField textField1)
	{
		this.textField1 = textField1;
	}

	public TextField getTextField2()
	{
		return textField2;
	}

	public void setTextField2(TextField textField2)
	{
		this.textField2 = textField2;
	}

	public TextField getTextField3()
	{
		return textField3;
	}

	public void setTextField3(TextField textField3)
	{
		this.textField3 = textField3;
	}

	public TextField getTextField4()
	{
		return textField4;
	}

	public void setTextField4(TextField textField4)
	{
		this.textField4 = textField4;
	}

	public TextField getTextField5()
	{
		return textField5;
	}

	public void setTextField5(TextField textField5)
	{
		this.textField5 = textField5;
	}

	public TextField getTextField6()
	{
		return textField6;
	}

	public void setTextField6(TextField textField6)
	{
		this.textField6 = textField6;
	}

	public TextField getTextField7()
	{
		return textField7;
	}

	public void setTextField7(TextField textField7)
	{
		this.textField7 = textField7;
	}

	public TextField getTextField8()
	{
		return textField8;
	}

	public void setTextField8(TextField textField8)
	{
		this.textField8 = textField8;
	}

	
	
}
