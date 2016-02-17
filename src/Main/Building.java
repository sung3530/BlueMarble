package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Building implements ActionListener {
	private BuildingGui buildingGui;
	private int buildingNumber=0;
	private UserManager um;
	private City[] cityList=new City[16];
	public Building(UserManager um,City[] city){
		this.um=um;
		this.cityList=city;
		buildingGui=new BuildingGui(this);
		
	}
	public int getBuildingNumber(){
		return buildingNumber;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			if(buildingGui.getNumber()=="ONE"){
				buildingNumber=1;
			}
			else if(buildingGui.getNumber()=="TWO"){
				buildingNumber=2;
			}
			else if(buildingGui.getNumber()=="THREE"){
				buildingNumber=3;
			}
			if(um.getFirsetPeople().sendFee(5*getBuildingNumber()))
				 cityList[um.getFirsetPeople().position].plusFee(getBuildingNumber());
			buildingGui.dispose();
	}

	
	
}
