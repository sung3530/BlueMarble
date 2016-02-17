package Main;

public class Move {
	
	public static Move move=new Move();
	
	public static Move getInstance(){
		return move;
	}
	
	public int move_People(int dice_number,int position){
		position=position+dice_number;
		position=position%16;
		
		return position;
	}
	
	
}
