package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BuildingGui extends JFrame implements ItemListener{
	private String[] contents={"Select","ONE","TWO","THREE"};
	private String temp=new String();
	private JComboBox combo;
	private JPanel panel=new JPanel();
	private JButton jb=new JButton();
	private Building building;
	public BuildingGui(Building building){
		super("빌딩 몇개 구매?");
		this.building=building;
		generatecombo();
		generateButton();
		generatePanel();
	}
	public String getNumber(){
		return temp;
	}
	private void generatecombo(){
		panel.add(new JLabel("Type : "));
		combo=new JComboBox(contents);
		panel.add(combo);
		combo.addItemListener(this);
	}
	private void generateButton(){
		jb=new JButton("OK");
		panel.add(jb);
		jb.addActionListener(building);
	}
	private void generatePanel(){
		setBounds(100, 100, 400, 100);
		add(panel);
		setVisible(true);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange()==ItemEvent.SELECTED){
			temp=e.getItem().toString();
		}
	}
}
