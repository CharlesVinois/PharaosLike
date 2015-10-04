package IHM;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Maps.Mapper;

public class Menu extends JPanel{
	private static final long serialVersionUID = 1684312527014957045L;
	private Mapper mapper_;
	public Menu(Mapper mapper){
		mapper_ = mapper;
		JLabel jl = new JLabel();
		JPanel jp = new JPanel();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();
		jl.setIcon(new ImageIcon("src/Images/Menu.png"));
		jl.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e) {
				mapper_.getInfo_().setText(mapper_.getCity_().getInfos(), null);
			}
		});
		jl.setBounds(0, 0, 150, 78);
		jl.repaint();
		this.add(jl);
		JButton jbf = new JButton(new ImageIcon("src/Images/Farm.png"));
		jbf.setSize(20, 20);
		jbf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mapper_.setPointer("Farm");
			}
		});
		JButton jbf1 = new JButton(new ImageIcon("src/Images/Erase.png"));
		jbf1.setSize(20, 20);
		jbf1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mapper_.setPointer("Erase");
			}
		});
		JButton jbf2= new JButton(new ImageIcon("src/Images/HouseMini.png"));
		jbf2.setSize(20, 20);
		jbf2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mapper_.setPointer("House");
			}
		});
		JButton jbf3= new JButton(new ImageIcon("src/Images/RoadUD.png"));
		jbf3.setSize(20, 20);
		jbf3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mapper_.setPointer("Road");
			}
		});
		JButton jbf4 = new JButton(new ImageIcon("src/Images/AchitechtHouse.png"));
		jbf4.setSize(20, 20);
		jbf4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mapper_.setPointer("Archi");
			}
		});
		JButton jbf5= new JButton(new ImageIcon("src/Images/FireHouse.png"));
		jbf5.setSize(20, 20);
		jbf5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mapper_.setPointer("Fire");
			}
		});
		JButton jbf6= new JButton(new ImageIcon("src/Images/Puit.png"));
		jbf6.setSize(20, 20);
		jbf6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mapper_.setPointer("Puit");
			}
		});
		
		jp.add(jbf);
		jp1.add(jbf1);
		jp2.add(jbf2);
		jp3.add(jbf3);
		jp4.add(jbf4);
		jp5.add(jbf5);
		jp6.add(jbf6);
		
		jp.setBounds(0, 80, 30, 40);
		jp.repaint();
		
		Icon rollOverIcon = new ImageIcon("src/Images/FarmDescription.png"); // Icon for roll over (hovering effect)
		jbf.setRolloverIcon(rollOverIcon); // Set the icon attaching with the roll-over event
		this.add(jp);
		
		jp1.setBounds(30, 80, 30, 40);
		jp1.repaint();
		Icon rollOverIcon1 = new ImageIcon("src/Images/EraseDescription.png"); // Icon for roll over (hovering effect)
		jbf1.setRolloverIcon(rollOverIcon1);
		this.add(jp1);
		
		jp2.setBounds(60, 80, 30, 40);
		jp2.repaint();
		Icon rollOverIcon2 = new ImageIcon("src/Images/HouseDescription.png"); // Icon for roll over (hovering effect)
		jbf2.setRolloverIcon(rollOverIcon2);
		this.add(jp2);
		
		jp3.setBounds(90, 80, 30, 40);
		jp3.repaint();
		Icon rollOverIcon3 = new ImageIcon("src/Images/RoadDescription.png"); // Icon for roll over (hovering effect)
		jbf3.setRolloverIcon(rollOverIcon3);
		this.add(jp3);
		
		jp4.setBounds(0, 110, 30, 40);
		jp4.repaint();
		//Icon rollOverIcon4 = new ImageIcon("src/Images/RoadDescription.png"); // Icon for roll over (hovering effect)
		//jbf4.setRolloverIcon(rollOverIcon4);
		this.add(jp4);
		
		jp5.setBounds(30, 110, 30, 40);
		jp5.repaint();
		//Icon rollOverIcon5 = new ImageIcon("src/Images/RoadDescription.png"); // Icon for roll over (hovering effect)
		//jbf5.setRolloverIcon(rollOverIcon5);
		this.add(jp5);
		
		jp6.setBounds(60, 110, 30, 40);
		jp6.repaint();
		//Icon rollOverIcon6 = new ImageIcon("src/Images/RoadDescription.png"); // Icon for roll over (hovering effect)
		//jbf6.setRolloverIcon(rollOverIcon6);
		this.add(jp6);
		
		repaint();
		this.setSize(new Dimension(150, 600));
		this.setBounds(450, 0, 150, 600);
		this.setLayout(null);
	}
}
