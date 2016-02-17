package Main.CITY;

import java.awt.Color;

import javax.swing.JButton;

import Main.City;
import Main.GUIController;
import Main.User;

public class spaceStation extends JButton implements City{
	private String cityName;
	public spaceStation(String name){
		super(name);
		cityName=name;
	}
	public String getName(){
		return cityName;
	}
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getMaster() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMaster(User Master) {
		// TODO Auto-generated method stub
		
	}
	public void changeColor(int order) {
		// TODO Auto-generated method stub
		if(order==0)
			this.setBackground(Color.orange);
		else if(order==1)
			this.setBackground(Color.pink);
		else if(order==2)
			this.setBackground(Color.green);
		else if(order==3)
			this.setBackground(null);
	}

	@Override
	public int getFee() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void plusFee(int buildings) {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void addActionListeners(GUIController guic) {
		// TODO Auto-generated method stub
		this.addActionListener(guic);
	}
}
