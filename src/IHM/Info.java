package IHM;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import Maps.Mapper;

public class Info  extends JLabel{
	private static final long serialVersionUID = 1738458448174983418L;
	private JLabel name_;
	private JLabel img_;
	private Timers time_;
	public Info(Timers time){
		time_ = time;
		init();
		this.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e) {
				Info.this.setVisible(false);
				time_.startAnim();
				for(Component comp : Info.this.getComponents())
					Info.this.remove(comp);
			}
		});
		this.setPreferredSize(new Dimension(400, 500));
		this.setBounds(25, 25, 400, 500);
		this.setVisible(false);
	}
	public void init() {
		setIcon(new ImageIcon("src/Images/Info.png"));
		name_ = new JLabel();
		name_.setBounds(180, 40, 200, 20);
		img_ = new JLabel();
		img_.setBounds(180, 120, 40, 40);
		//JLabel description_ = new JLabel();
		JButton jbf = new JButton(new ImageIcon("src/Images/close.png"));
		jbf.setSize(20, 20);
		jbf.setBounds(380, 0, 20, 20);
		jbf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Info.this.setVisible(false);
				time_.startAnim();
				for(Component comp : Info.this.getComponents())
					Info.this.remove(comp);
			}
		});
		this.add(img_);
		this.add(name_);
		this.add(jbf);
	}
	public void setText(String str, ImageIcon img){
		init();
		time_.stopAnim();
		img_.setIcon(img);
		if(isListe(str))
			infoCreator(str);
		else	
			name_.setText(str);
		this.setVisible(true);
	}
	public boolean isListe(String str) {
		if(str.contains(","))
			return true;
		return false;
	}
	public void infoCreator(String str) {
		int margin = 20;
		name_.setText("");
		for(String st : str.split(","))
		{
			JLabel jl = new JLabel();
			jl.setText(st);
			jl.setBounds(100, margin, 200, 20);
			this.add(jl);
			margin = margin + 20;
		}
	}
}
