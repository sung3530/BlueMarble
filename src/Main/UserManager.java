package Main;

public class UserManager {
	private User first;
	private User second;
	
	public void makeUser(){
		first=new FirstPerson();
		second=new SecondPerson();
	}
	public User getFirsetPeople(){
		return first;
	}
	public User getSecondPeople(){
		return second;
	}
}
