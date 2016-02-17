package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpaceTravel implements ActionListener {
	private Object[][] data=new Object[16][2];
	private City cityList[]=new City[16];
	private SpaceTravelGui gui;
	private UserManager um;
	private int order;
	private Game game;
	public SpaceTravel(City[] cityList,UserManager um,int order,Game game){
		this.game=game;
		this.um=um;
		this.order=order;
		this.cityList=cityList;
		listMake();
		gui=new SpaceTravelGui(this,data);
		
	}
	private void listMake(){
		for (int i = 1; i < cityList.length+1; i++) {
			data[i-1][0]=i+"";
			data[i-1][1]=cityList[i-1].getName();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(order==0){
			um.getFirsetPeople().setPosition(Integer.parseInt(gui.getNumber())-1);
			cityList[12].changeColor(3);
			cityList[um.getFirsetPeople().position].changeColor(order);
			gui.dispose();
			game.CityCheck(0);
		}
		else if(order==1){
			um.getSecondPeople().setPosition(Integer.parseInt(gui.getNumber())-1);
			cityList[12].changeColor(3);
			cityList[um.getSecondPeople().position].changeColor(order);
			gui.dispose();
			game.CityCheck(1);
		}
	
	}

}
