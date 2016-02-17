package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class SpaceTravelGui extends JFrame implements MouseListener{
	private JButton jb=new JButton();
	private JPanel jp=new JPanel();
	private String privates;
	private SpaceTravel spaceTravel;
	static JScrollPane jsp=new JScrollPane();
	private String[] name={"Number","City Name"};
	   public DefaultTableModel model_user = new DefaultTableModel(name, 0);
	   public JTable table_user=new JTable(model_user)
	   {
	      public boolean isCellEditable(int rowIndex,int colIndex)
	      {
	         return false;
	      }
	   };   
	   public SpaceTravelGui(SpaceTravel spaceTravel,Object[][] data){
		   this.spaceTravel=spaceTravel;
		   jtable(data);
		   buttonMake();
		   generatePanel();
		   mouseClick();
	   }
	   public String getNumber(){
		   return privates;
	   }
	   private void buttonMake(){
		   jb=new JButton("Travel");
		   jp.add(jb);
		   jb.addActionListener(spaceTravel);
	   }
	   private void jtable(Object[][] data){
			int i=0;
			System.out.println(data[i][0]);
			while(i<16){
				model_user.addRow(data[i]);
				i++;
				}
				jsp=new JScrollPane(table_user);
		}
	   private void generatePanel(){
		   setBounds(100, 100, 500, 550);
		   jp.add(jsp);
		   add(jp);
		   setVisible(true);
	   }
		private void mouseClick(){
			table_user.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 단일선택
			table_user.addMouseListener(this);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			  int row = table_user.getSelectedRow();
		      int column = table_user.getSelectedColumn();
		      privates=(table_user.getValueAt(row, 0)).toString();
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

}
