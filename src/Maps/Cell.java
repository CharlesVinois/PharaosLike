package Maps;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import IHM.Info;
import Objets.Farm;
import Objets.House;

public class Cell extends JLabel{
	private static final long serialVersionUID = 5642206584386104754L;
	private String typeLocal_;//sand/grass/water/road/gravas/house/farm/road/
	private String typeBuild_;
	private Dimension size_;
	private Dimension pos_;
	private int orientation_;//0:up/1:left/2:down/3:right
	private ImageIcon imageLocal_;
	private ImageIcon imageBuild_;
	private Boolean isWalkable_;
	private Info info_;
	private Mapper map_;
	//private Object //~=this.type
	public Cell(Info info, Mapper map, Dimension pos){
		pos_ = pos;
		map_ = map;
		info_ = info;
		typeLocal_="sand";
		typeBuild_="sand";
		size_ = new Dimension(30, 30);
		orientation_ = 0;
		imageLocal_ = new ImageIcon("src/Images/Solp.png");
		//imageBuild_ = new ImageIcon();
		isWalkable_ = true;
		setPreferredSize(size_);
		update();
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				//pop up type et possibilitées
			}
			public void mouseReleased(MouseEvent e) {
				if(SwingUtilities.isLeftMouseButton(e))
					setObject();
				else if(SwingUtilities.isRightMouseButton(e))
					setInfos(typeLocal_);
			}
		});
	}
	public void setInfos(String str) {
		if(str == "house")
		{
			for(House hous : map_.getCity_().getBuilds_())
				info_.setText(typeLocal_+","+hous.getInfos(), imageLocal_);
		}
		else if(str == "farm")
		{
			for(Farm farm : map_.getCity_().getFarms_())
				info_.setText(typeLocal_+","+farm.getInfos(), imageLocal_);
			System.out.println("toto");
			
		}
		else
			info_.setText(typeLocal_, imageLocal_);
			//map_.getMapLocal_().get((int) pos_.getWidth()).get((int) pos_.getHeight()).getIn
	}
	public Cell(Info info, ImageIcon img, String type, Mapper map, Dimension pos){
		pos_ = pos;
		map_ = map;
		info_ = info;
		typeLocal_ = type;
		typeBuild_ = type;
		size_ = new Dimension(30, 30);
		orientation_ = 0;
		imageLocal_ = img;
		isWalkable_ = true;
		setPreferredSize(size_);
		update();
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				//pop up type et possibilitées
			}	
			public void mouseReleased(MouseEvent e) {
				if(SwingUtilities.isLeftMouseButton(e))
					setObject();
				else if(SwingUtilities.isRightMouseButton(e))
					setInfos(typeLocal_);
			}
		});
	}
	public void lookAround(){
		if(typeLocal_ == "road")
		{
			if(map_.getMapLocal_().get((int) pos_.getWidth()).get((int) pos_.getHeight()+1).getType_() == typeLocal_ &&
				map_.getMapLocal_().get((int) pos_.getWidth()).get((int) pos_.getHeight()-1).getType_() == typeLocal_ &&
				map_.getMapLocal_().get((int) pos_.getWidth()+1).get((int) pos_.getHeight()).getType_() == typeLocal_ &&
				map_.getMapLocal_().get((int) pos_.getWidth()-1).get((int) pos_.getHeight()).getType_() == typeLocal_)
				System.out.println("gg");
		}
		
	}
	public void setObject(){	
		if(typeLocal_ != typeBuild_)
		{
			imageLocal_ = imageBuild_;
			typeLocal_ = typeBuild_;
			map_.creatObject(typeLocal_, pos_);
		}
		update();
	}
	public void update(){
		this.setIcon(imageLocal_);
		repaint();
	}
	public String getType_() {
		return typeLocal_;
	}
	public void setType_(String type_) {
		this.typeLocal_ = type_;
	}
	public Dimension getSize_() {
		return size_;
	}
	public void setSize_(Dimension size_) {
		this.size_ = size_;
	}
	public int getOrientation_() {
		return orientation_;
	}
	public void setOrientation_(int orientation_) {
		this.orientation_ = orientation_;
	}
	public ImageIcon getImageLocal_() {
		return imageLocal_;
	}
	public void notify(ImageIcon imageLocal, String type) {
		this.typeBuild_ = type;
		this.imageBuild_ = imageLocal;
	}
	public Boolean getIsWalkable_() {
		return isWalkable_;
	}
	public void setIsWalkable_(Boolean isWalkable_) {
		this.isWalkable_ = isWalkable_;
	}
}
