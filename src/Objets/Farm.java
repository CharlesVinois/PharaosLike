package Objets;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import IHM.Timers;

public class Farm  extends JLabel{
	private static final long serialVersionUID = 5986162053344201417L;
	private Dimension pos_;
	private Timers time_;
	private int index_;
	private int level_;
	private int priorityWorker_;
	private int worker_;
	private int maturity_;
	private int ferility_;
	private int foodQuantity_;
	private int foodTime_;
	private int cost_;
	private ImageIcon img_;
	private City city_;
	public Farm(Timers time, int index, Dimension pos, City city){
		index_ = index;
		time_ = time;
		level_ = 0;
		pos_ = pos;
		worker_ = 0;
		maturity_ = 0;
		ferility_ = 100;
		foodQuantity_ = 0;
		foodTime_ = 0;
		cost_ = 20;
		img_ = new ImageIcon("src/Images/Farm.png");
		setIcon(img_);
		city_ = city;
	}
	public Dimension getPos_() {
		return pos_;
	}
	public void setPos_(Dimension pos_) {
		this.pos_ = pos_;
	}
	public int getLevel_() {
		return level_;
	}
	public void setLevel_(int level_) {
		this.level_ = level_;
	}
	public int getWorker_() {
		return worker_;
	}
	public void setWorker_(int worker_) {
		this.worker_ = worker_;
	}
	public void increaseWorker() {
		if(worker_ < 5)
			worker_++;
	}
	public void decreaseWorker() {
		if(worker_ > 0)
			worker_--;
	}
	public int getMaturity_() {
		return maturity_;
	}
	public void setMaturity_(int maturity_) {
		this.maturity_ = maturity_;
	}
	public int getFerility_() {
		return ferility_;
	}
	public void setFerility_(int ferility_) {
		this.ferility_ = ferility_;
	}
	public int getFoodQuantity_() {
		return foodQuantity_;
	}
	public void setFoodQuantity_(int foodQuantity_) {
		this.foodQuantity_ = foodQuantity_;
	}
	public int getFoodTime_() {
		return foodTime_;
	}
	public void setFoodTime_(int foodTime_) {
		this.foodTime_ = foodTime_;
	}
	public ImageIcon getImg_() {
		return img_;
	}
	public void setImg_(ImageIcon img_) {
		this.img_ = img_;
	}
	public City getCity_() {
		return city_;
	}
	public void setCity_(City city_) {
		this.city_ = city_;
	}
	public int getCost_() {
		return cost_;
	}
	public void setCost_(int cost_) {
		this.cost_ = cost_;
	}
	public String getInfos() {
		String str = ""+"Level : "+level_+","+"Numer : "+index_+","
				+"Cost : "+cost_+","+"Worker : "+worker_+","+"Maturity : "
				+maturity_+"%"+","+"Fertility : "+ferility_+"%"+","+"FoodQuant : "+foodQuantity_;
		return str;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
