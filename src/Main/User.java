package Main;

import java.util.Vector;

import javax.swing.JButton;

public class User { 
	protected String name;
	protected int money;
	protected Vector cityList=new Vector();
	protected dice dice=new dice();
	
	protected int position;
	protected boolean moveState=true;
	
	public void plusCity(City city){
		cityList.add(city);
	}
	public void plusSalary(){
		money=money+50;
		
	}
	public boolean sendFee(int fee){
		if(money>fee){
			money=money-fee;
			return true;
		}
		return false;
	}
	public void setPosition(int position){
		this.position=position;
	}
	public void setMoveState(boolean moveState){
		this.moveState=moveState;
	}
	public boolean buyCity(int money){
		if(this.money>=money){
			this.money=this.money-money;
			return true;
		}
		else{
			return false;
		}
	}
	public class dice {
		protected int firstDice;
		protected int secondDice;
		protected boolean doubleState; 
		protected int doubleCount;
		public boolean getDoubleState() {
			// TODO Auto-generated method stub
			return doubleState;
		}
		public int Rolling() {
			firstDice=(int)( Math.random()*6+1);
			secondDice=(int)( Math.random()*6+1);
			doubleState=false;
			System.out.println("first : "+firstDice+"secondice :"+secondDice+"\n");
			if(firstDice==secondDice)
				doubleState=true;
			
			return firstDice+secondDice;
			// TODO Auto-generated method stub
		}
	}

}