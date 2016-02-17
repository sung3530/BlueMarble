package Main;

public interface City {

	

	int getPrice();
	User getMaster();
	void setMaster(User Master);
	String getName();
	void changeColor(int order);
	int getFee();
	void plusFee(int buildings);
	void addActionListeners(GUIController guic);
}
