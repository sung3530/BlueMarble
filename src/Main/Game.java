package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Game {
	private UserManager userManager;
	private GUIController GUIc;
	private int turn=0;
	private int islandCount[]={0,0};
	private int salaryPosition[]={0,0};
	private City[] cityList=new City[16];
	private String temp;
	private int dice_number=0;
	private int doubleCount=0;
	
	public Game(GUIController GUIC,City[] city){
		GUIc=GUIC;
		cityList=city;
		this.userManager=new UserManager();
		userManager.makeUser();
		GUIc.StartPersonState( userManager.getFirsetPeople().money, 0);
		GUIc.StartPersonState(userManager.getSecondPeople().money, 1);
	}
	
	public void gamePlaying(){// jb[0] startPoint jb[4] 무인도 jb[12]우주여행
	
		if(turn%2==0){
			
			if(userManager.getFirsetPeople().moveState==true){
				salaryPosition[0]=userManager.getFirsetPeople().position;
				colorChange(3);
				dice_number=userManager.getFirsetPeople().dice.Rolling();
				userManager.getFirsetPeople().setPosition(Move.getInstance().move_People(dice_number, userManager.getFirsetPeople().position));
				print_TextField(dice_number,0,userManager.getFirsetPeople().dice.getDoubleState());
				colorChange(0);
				move_Selection(0);
				GUIc.resetPersonState( userManager.getFirsetPeople().money, userManager.getFirsetPeople().cityList, 0);
				doubleCheck(0);
			}
			else{
				islandCount[0]++;//무인도에 있을때 3회 못움직임
				if(islandCount[0]==3){
					userManager.getFirsetPeople().setMoveState(true);
					islandCount[0]=0;
				}
			}
		
			System.out.println("1pick");
		}
		else if(turn%2==1){
			if(userManager.getSecondPeople().moveState==true){
				salaryPosition[0]=userManager.getSecondPeople().position;
				colorChange(4);
				dice_number=userManager.getSecondPeople().dice.Rolling();
				userManager.getSecondPeople().setPosition(Move.getInstance().move_People(dice_number, userManager.getSecondPeople().position));
				print_TextField(dice_number,1,userManager.getSecondPeople().dice.getDoubleState());
				colorChange(1);
				move_Selection(1);
				GUIc.resetPersonState( userManager.getSecondPeople().money, userManager.getSecondPeople().cityList, 1);
				doubleCheck(1);
			}
			else{
				islandCount[1]++;//무인도에 있을때 3회 못움직임
				if(islandCount[1]==3){
					userManager.getSecondPeople().setMoveState(true);
					islandCount[1]=0;
				}
			}
			
			
			System.out.println("2pick");
		
		}
	
		turn++;
	}

	private void colorChange(int order){
		if(userManager.getFirsetPeople().position==userManager.getSecondPeople().position&&order!=3&&order!=4){
			cityList[userManager.getFirsetPeople().position].changeColor(2);
		}
		else if(order==0){
			cityList[userManager.getFirsetPeople().position].changeColor(order);
		}
		else if(order==1){
			cityList[userManager.getSecondPeople().position].changeColor(order);
		}
		else if(order==3){
			if(userManager.getFirsetPeople().position==userManager.getSecondPeople().position){
				cityList[userManager.getFirsetPeople().position].changeColor(1);
				System.out.println("\nokok\n");
			}
			else{
				cityList[userManager.getFirsetPeople().position].changeColor(3);
			}
			
		}
		else if(order==4){
			if(userManager.getFirsetPeople().position==userManager.getSecondPeople().position){
				cityList[userManager.getFirsetPeople().position].changeColor(0);
			}
			else{
				cityList[userManager.getSecondPeople().position].changeColor(3);
			}
		}
	}

	private void print_TextField(int dice_number,int order,boolean doubleState){
		if(order==0){
			
			if(doubleState)
				temp="1Pick Double Dice:"+dice_number;
			else
				temp="    1 Pick Dice : "+dice_number+"";
		}
		if(order==1){
			if(doubleState)
				temp="2Pick Double Dice:"+dice_number;
			else
				temp="    2 Pick Dice : "+dice_number+"";
		}
		GUIc.getTextField().setText(temp);
		
	}
	public void CityCheck(int order){
		if(order==0){
			if(cityList[userManager.getFirsetPeople().position].getMaster()==null){
				int i= JOptionPane.showConfirmDialog(null,cityList[userManager.getFirsetPeople().position].getName()+"도시를 "+cityList[userManager.getFirsetPeople().position].getPrice() +"만원에  구매 하시겠습니까?","도시구매구매",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
				if(i==0){// yes 눌렀을때.
					if(userManager.getFirsetPeople().buyCity(cityList[userManager.getFirsetPeople().position].getPrice())){
						cityList[userManager.getFirsetPeople().position].setMaster(userManager.getFirsetPeople());
						userManager.getFirsetPeople().plusCity(cityList[userManager.getFirsetPeople().position]);
						Building building=new Building(userManager,cityList);
						if(userManager.getFirsetPeople().sendFee(5*building.getBuildingNumber()))
							cityList[userManager.getFirsetPeople().position].plusFee(building.getBuildingNumber());
		
					}
					else{
						JOptionPane.showMessageDialog(null, "니 자산이 부족해 거지놈아", "거지거지", JOptionPane.INFORMATION_MESSAGE);
						
					}
				}
			}
			else if(cityList[userManager.getFirsetPeople().position].getMaster()==userManager.getSecondPeople()){
				if(!userManager.getFirsetPeople().sendFee(cityList[userManager.getFirsetPeople().position].getFee())){
					endGame();
				}
				
			}
		}
		else if(order==1){
			if(cityList[userManager.getSecondPeople().position].getMaster()==null){
				int i= JOptionPane.showConfirmDialog(null,cityList[userManager.getSecondPeople().position].getName()+"도시를  "+cityList[userManager.getSecondPeople().position].getPrice() +"만원에 구매 하시겠습니까?","도시구매구매",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
				if(i==0){
					if(userManager.getSecondPeople().buyCity(cityList[userManager.getSecondPeople().position].getPrice())){
						cityList[userManager.getSecondPeople().position].setMaster(userManager.getSecondPeople());
						userManager.getSecondPeople().plusCity(cityList[userManager.getSecondPeople().position]);
						Building building=new Building(userManager,cityList);
						if(userManager.getSecondPeople().sendFee(5*building.getBuildingNumber()))
							cityList[userManager.getSecondPeople().position].plusFee(building.getBuildingNumber());
					}
					else{
						JOptionPane.showMessageDialog(null, "니 자산이 부족해 거지놈아", "거지거지", JOptionPane.INFORMATION_MESSAGE);
						
					}
					
				}
			}
			else if(cityList[userManager.getSecondPeople().position].getMaster()==userManager.getFirsetPeople()){
				if(!userManager.getSecondPeople().sendFee(cityList[userManager.getSecondPeople().position].getFee()))
					endGame();
			}
		}
	}
	private void doubleCheck(int order){
		if(order==0){
			if(userManager.getFirsetPeople().dice.getDoubleState()&&doubleCount<3){
				turn++;
			}
			
			else if(doubleCount==3){
				userManager.getFirsetPeople().setMoveState(false);
				userManager.getFirsetPeople().setPosition(4);
				doubleCount=0;
			}
			else{
				doubleCount=0;
			}
			
		}
		else if(order==1){
			if(userManager.getSecondPeople().dice.getDoubleState()&&doubleCount<3){
				turn++;
			}
			
			else if(doubleCount==3){
				userManager.getSecondPeople().setMoveState(false);
				userManager.getSecondPeople().setPosition(4);
				doubleCount=0;
			}
			else{
				doubleCount=0;
			}
			
		}
	}
	private void move_Selection(int order){
		if(order==0){
			if(salaryPosition[0]>userManager.getFirsetPeople().position){
				userManager.getFirsetPeople().plusSalary();
				
			}
			
			if(userManager.getFirsetPeople().position==4){//무인도일때
				userManager.getFirsetPeople().setMoveState(false);
			}
			else if(userManager.getFirsetPeople().position==12){//우주여행
				SpaceTravel spaceTravel=new SpaceTravel(cityList,userManager,0,this);
			}
			else if(userManager.getFirsetPeople().position!=0){ // 무인도와 우주여행 아닐떄
				CityCheck(0);
			}
			
		}
		if(order==1){
			if(salaryPosition[0]>userManager.getSecondPeople().position){
				userManager.getSecondPeople().plusSalary();
				
			}
			if(userManager.getSecondPeople().position==4){//무인도일때
				userManager.getSecondPeople().setMoveState(false);
			}
			else if(userManager.getSecondPeople().position==12){//우주여행
				SpaceTravel spaceTravel=new SpaceTravel(cityList,userManager,1,this);
			}
			else if(userManager.getSecondPeople().position!=0){ //무인도와 우주여행 아닐떄
				CityCheck(1);
			}
			
		}
	}
	private void endGame(){
		GUIc.getGui().dispose();
		
	}
}
