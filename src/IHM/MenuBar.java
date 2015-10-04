package IHM;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Maps.Mapper;

public class MenuBar extends JPanel{
	private static final long serialVersionUID = 2088320994996440846L;
	private Mapper map_;
	private JLabel money_, people_, date_;
	public MenuBar(Mapper map){
		map_ = map;
		JLabel infoBar = new JLabel(new ImageIcon("src/Images/MEnuBar.png"));
		infoBar.setPreferredSize(new Dimension(450, 20));
		infoBar.setBounds(0, 0, 450, 20);
		this.add(infoBar);
		money_ = new JLabel(""+map_.getCity_().getMoneyGlobal_()+" Db");
		money_.setBounds(10, 0, 80, 20);
		infoBar.add(money_);
		people_ = new JLabel(""+map_.getCity_().getNumberCitizen_()+" Ppl");
		people_.setBounds(90, 0, 80, 20);
		infoBar.add(people_);
		date_ = new JLabel(""+map_.getTimer_().getTime()+" Sec");
		date_.setBounds(170, 0, 120, 20);
		infoBar.add(date_);
		//repaint();
		this.setPreferredSize(new Dimension(450, 20));
		this.setLayout(null);
	}
	public void refresh(){
		money_.setText(""+map_.getCity_().getMoneyGlobal_()+" Db");
		people_.setText(""+map_.getCity_().getNumberCitizen_()+" Ppl");
		date_.setText(""+map_.getTimer_().getTime()+" Sec");
		validate();
		repaint();
	}
}
