package Main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIController implements ActionListener {
	private GUI gui;
	private Game game;
	
	public GUIController(GUI gui){
		this.gui=gui;
		game=new Game(this,gui.getCity());
		
	}
	public JTextArea[] getTextArea(){
		return gui.getTextArea();
	}
	public JLabel[] getLabel(){
		return gui.getLabel();
	}
	public JTextField getTextField(){
		return gui.getTextField();
	}
	public GUI getGui(){
		return gui;
	}
	public void StartPersonState(int money,int order){
		gui.getTextArea()[order]=new JTextArea();
		gui.getTextArea()[order].setText(" Money : "+money+"¸¸\n\n");
	}
	public void resetPersonState(int money,Vector citylist,int order){
		gui.getTextArea()[order].removeAll();
		gui.getTextArea()[order].repaint();
		gui.getTextArea()[order].setText(" Money : "+money+"¸¸\n"+"-City List-\n");
		
		for (int i = 0; i < citylist.size(); i++) {
			City temp=(City) citylist.elementAt(i);
			
			gui.getTextArea()[order].append(" "+temp.getName()+"\n");
		}
		gui.getTextArea()[order].append("______________\n");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(gui.getDice())){
			game.gamePlaying();
		}
		else{
			for (int i = 0; i < 16; i++) {
				if(e.getSource().equals((JButton)gui.getCity()[i])){
					JOptionPane.showMessageDialog(null, "price : "+gui.getCity()[i].getPrice()+"\n"+"Fee:"+gui.getCity()[i].getFee(),gui.getCity()[i].getName(), JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	
}
