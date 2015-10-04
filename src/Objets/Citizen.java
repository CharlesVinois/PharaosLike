package Objets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Citizen extends JLabel{
	private static final long serialVersionUID = 8158388353032137743L;
	private int index_;
	private int type_;//0;immigrant//1;leaver//2;worker//3;farmer//4;architect/5;fireguard//6;transporter//7;chomer
	private int priorityWork_;
	private House home_;
	private Dimension position_;
	private Dimension destination_;
	private int ressourcesOwned_;
	private ImageIcon img_;
	private ArrayList<ImageIcon> anim_;
	private boolean haveJob_;
	public boolean isVisible_;
	private JLabel work_;
	
	public Citizen(Dimension pos, int index, House hs){
		isVisible_ = true;
		home_ = hs;
		img_ = new ImageIcon("src/Images/Caravaner.png");
		index_ = index;
		priorityWork_ = index;
		type_ = 0;
		position_ = pos;
		ressourcesOwned_ = 0;
		haveJob_ = false;
		repaint();
		this.setBounds((int) position_.getWidth(), (int) position_.getHeight(), 30, 30);
		goingHome();
		this.setImg(img_);
	}
	public void move(){
		if(this.getPosition_().getHeight() < (this.getDestination_().getHeight()))
		{
			this.setVisible(true);
			isVisible_ = true;
			this.setBounds((int) this.getPosition_().getWidth(), (int) this.getPosition_().getHeight() + 10, 30, 30);
			this.setPosition_(new Dimension((int) this.getPosition_().getWidth(), (int) this.getPosition_().getHeight() + 10));
		}
		else if(this.getPosition_().getHeight() > (this.getDestination_().getHeight())){
			this.setVisible(true);
			isVisible_ = true;
			this.setBounds((int) this.getPosition_().getWidth(), (int) this.getPosition_().getHeight() - 10, 30, 30);
			this.setPosition_(new Dimension((int) this.getPosition_().getWidth(), (int) this.getPosition_().getHeight() - 10));
		}
		if(this.getPosition_().getWidth() < (this.getDestination_().getWidth()))
		{
			this.setVisible(true);
			isVisible_ = true;
			this.setBounds((int) this.getPosition_().getWidth() + 10, (int) this.getPosition_().getHeight(), 30, 30);
			this.setPosition_(new Dimension((int) this.getPosition_().getWidth() + 10, (int) this.getPosition_().getHeight()));
		}
		else if(this.getPosition_().getWidth() > (this.getDestination_().getWidth())){
			this.setVisible(true);
			isVisible_ = true;
			this.setBounds((int) this.getPosition_().getWidth() - 10, (int) this.getPosition_().getHeight(), 30, 30);
			this.setPosition_(new Dimension((int) this.getPosition_().getWidth() - 10, (int) this.getPosition_().getHeight()));
		}
		if(this.getPosition_().getWidth() == this.getDestination_().getWidth() && this.getPosition_().getHeight() == this.getDestination_().getHeight() && isVisible_)
		{
			if(type_ == 0)
			{
				home_.addPeople(this);
				this.setType_(7);
			}
			else if(type_ == 7)
				((Farm) work_).increaseWorker();
			this.setVisible(false);
			isVisible_ = false;
		}
	}
	public void setImg(ImageIcon img)
	{
		img_=img;
		setSize(img_.getIconWidth(), img_.getIconHeight());
		BufferedImage bi = new BufferedImage( img_.getIconWidth(), img_.getIconHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		img_.paintIcon(null, g, 0,0);
		g.dispose();
		img_ =new ImageIcon(makeColorTransparent(bi, new Color(bi.getRGB(0, 0))));
		setIcon(img_);

	}
	public static Image makeColorTransparent(final BufferedImage im, final Color color)  
	{  
      final ImageFilter filter = new RGBImageFilter()  
      {  
         public int markerRGB = color.getRGB() | 0xFFFFFFFF;
         public final int filterRGB(final int x, final int y, final int rgb)  
         {
            if ((rgb | 0xFF000000) == markerRGB)
               return 0x00FFFFFF & rgb;
            else
               return rgb;
         }
      };
      final ImageProducer ip = new FilteredImageSource(im.getSource(), filter);  
      return Toolkit.getDefaultToolkit().createImage(ip);  
   }
	public void goingHome(){
		if(position_.getWidth() != home_.getPosition_().getWidth()*30 && position_.getHeight() != home_.getPosition_().getHeight()*30)
			destination_ = new Dimension(((int) home_.getPosition_().getWidth())*30, ((int) home_.getPosition_().getHeight())*30 +20);
	}
	public void goingWork(){
		if(((Farm) work_).getFoodQuantity_() >= 0)
		{
			Farm farm = ((Farm) work_);
			if(position_.getWidth() != farm.getPos_().getWidth()*30 && position_.getHeight() != farm.getPos_().getHeight()*30)
				destination_ = new Dimension(((int) farm.getPos_().getWidth())*30, ((int) farm.getPos_().getHeight())*30 +20);
		}
	}
	public int getType_() {
		return type_;
	}
	public void setType_(int type_) {
		this.type_ = type_;
	}
	public House getHome_() {
		return home_;
	}
	public void setHome_(House home_) {
		this.home_ = home_;
	}
	public Dimension getPosition_() {
		return position_;
	}
	public void setPosition_(Dimension position_) {
		this.position_ = position_;
	}
	public int getRessourcesOwned_() {
		return ressourcesOwned_;
	}
	public void setRessourcesOwned_(int ressourcesOwned_) {
		this.ressourcesOwned_ = ressourcesOwned_;
	}
	public boolean isHaveJob_() {
		return haveJob_;
	}
	public void setHaveJob_(boolean haveJob_) {
		this.haveJob_ = haveJob_;
	}
	public Dimension getDestination_() {
		return destination_;
	}
	public void setDestination_(Dimension destination_) {
		this.destination_ = destination_;
	}
	public int getPriorityWork_() {
		return priorityWork_;
	}
	public void setPriorityWork_(int priorityWork_) {
		this.priorityWork_ = priorityWork_;
	}
	public boolean isVisible_() {
		return isVisible_;
	}
	public void setVisible_(boolean isVisible_) {
		this.isVisible_ = isVisible_;
	}
	public JLabel getWork_() {
		return work_;
	}
	public void setWork_(JLabel work_) {
		this.work_ = work_;
	}
}
