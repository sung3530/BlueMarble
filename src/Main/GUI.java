package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Main.CITY.ash;
import Main.CITY.busan;
import Main.CITY.daejon;
import Main.CITY.desertIsland;
import Main.CITY.illbae;
import Main.CITY.incheon;
import Main.CITY.jaeju;
import Main.CITY.jin;
import Main.CITY.leeyong;
import Main.CITY.love;
import Main.CITY.mipo;
import Main.CITY.onepyo;
import Main.CITY.seoul;
import Main.CITY.spaceStation;
import Main.CITY.startPoint;
import Main.CITY.timo;

public class GUI extends JFrame {

	private City jb[]=new City[16];
	private JPanel contentPane = new JPanel();
	private JPanel userPane=new JPanel();
	private JPanel mainPane=new JPanel();
	private JPanel personState[]=new JPanel[2];
	private JButton dice=new JButton();
	private GUIController guic;
	private JLabel jl[]=new JLabel[2];
	private JTextArea ta[]=new JTextArea[2];
	private JScrollPane sp[]=new JScrollPane[2];
	private JTextField textField_6 = new JTextField();
	public GUI(){
		guic=new GUIController(this);
		setPanel();
		setButton();
		setFrame();
		
	}
	public JPanel getUserPane(){
		return userPane;
	}
	public JButton getDice(){
		return dice;
	}
	public City[] getCity(){
		return jb;
	}
	
	public JTextArea[] getTextArea(){
		return ta;
	}
	public JLabel[] getLabel(){
		return jl;
	}
	public JTextField getTextField(){
		return textField_6;
	}
	
	private void setPanel(){
		setBounds(100, 100, 1000, 650);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(mainPane);;
		contentPane.setLayout(new GridLayout(5, 5, 0, 0));
		
		
		mainPane.setLayout(null);
		contentPane.setBounds(0, 0, 600	,600);
		mainPane.add(contentPane,BorderLayout.WEST);
		userPane.setBounds(600, 0, 300, 600);
		mainPane.add(userPane,BorderLayout.EAST);
	}
	
	private void setButton(){
		
		jb[4]=new desertIsland("desertIsland");
		contentPane.add((Component) jb[4]);
		
		
		jb[5]=new busan("busan");
		contentPane.add((Component) jb[5]);
		
		jb[6]=new daejon("daejon");
		contentPane.add((Component) jb[6]);
		
		jb[7]=new illbae("illbae");
		contentPane.add((Component) jb[7]);
		
		jb[8]=new incheon("incheon");
		contentPane.add((Component) jb[8]);
		
		jb[3]=new jaeju("jaeju");
		contentPane.add((Component) jb[3]);
		
		JTextField textField_1 = new JTextField();
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.enable(false);
		
		JTextField textField_4 = new JTextField("같이있으면  green");
		textField_4.setDisabledTextColor(Color.black);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.enable(false);
		
		JTextField textField_3 = new JTextField();
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.enable(false);
		
		jb[9] = new jin("jin");
		contentPane.add((Component) jb[9]);
		
		jb[2] = new leeyong("leeyong");
		contentPane.add((Component) jb[2]);
		
		JTextField textField_2 = new JTextField();
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.enable(false);
		
		this.dice= new diceButton("dice");
		contentPane.add(this.dice);
		dice.addActionListener(guic);
		
		JTextField textField_7 = new JTextField();
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		textField_7.enable(false);
		
		jb[10]= new love("love");
		contentPane.add((Component) jb[10]);
		
		jb[1] = new mipo("onepyo");
		contentPane.add((Component) jb[1]);
		
		JTextField textField_31 = new JTextField();
		contentPane.add(textField_31);
		textField_31.setColumns(10);
		textField_31.enable(false);
		
		textField_6 = new JTextField();
		textField_6.setDisabledTextColor(Color.black);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		textField_6.enable(false);
		
		JTextField textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		textField.enable(false);
		
		jb[11] = new seoul("seoul");
		contentPane.add((Component) jb[11]);
		
		jb[0] = new startPoint("startPoint");
		contentPane.add((Component) jb[0]);
		
		jb[15] = new timo("timo");
		contentPane.add((Component) jb[15]);
		
		jb[14]=new ash("ash");
		contentPane.add((Component) jb[14]);
		
		jb[13]=new mipo("mipo");
		contentPane.add((Component) jb[13]);
		
		jb[12] = new spaceStation("spaceStation");
		contentPane.add((Component) jb[12]);
		
		for (int i = 0; i < 16; i++) {
			jb[i].addActionListeners(guic);
			
		}
	}
	
	private void setFrame(){
		jl[0]=new JLabel("1 Pick (Orange)");
		jl[1]=new JLabel("2 Pick (Pink)");
		for (int i = 0; i < 2; i++) {
			ta[i]=new JTextArea();
			sp[i]=new JScrollPane();
		
			personState[i]=new JPanel();
			personState[i].setLayout(null);
			sp[i].setBounds(0, 100, 110, 300);
			jl[i].setBounds(0, 0, 100, 100);
		
			personState[i].add(jl[i]);
			personState[i].add(sp[i]);
			sp[i].setViewportView(ta[i]);
		}
		userPane.setLayout(null);
		personState[0].setBounds(0, 0, 150, 600);
		personState[1].setBounds(150, 0, 150, 600);
		userPane.add(personState[0]);
		userPane.add(personState[1]);
		setVisible(true);
		
	}
	
	
	
}
