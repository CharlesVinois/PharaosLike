package Objets;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import IHM.Info;
import IHM.Timers;

public class House extends JLabel{
	private static final long serialVersionUID = 8049676051923223730L;
	private int level_;//0;base/1;normal/2;bien/3;cool/4;grande/5;luxe
	private Timers timer_; 
	private int cost_;
	private int numberPeople_;
	private int foodQuantity_;
	private int foodTime_;
	private int objectQuantity_;
	private int objectTime_;
	private int religionAccess_;
	private int religionTime_;
	private int roadAcces_;
	private int roadTime_;
	private int waterAccess_;
	private int waterTime_;
	private int index_;
	private int destructRisk_;
	private int destruckTime_;
	private int fireRisk_;
	private int fireTime_;
	private int sanityRisk_;
	private int sanityTime_;
	private ArrayList<Citizen> renters_;
	private Dimension position_;
	private ImageIcon img_;
	private City city_;
	private Info info_;
	
	public House(Timers time, int index, Dimension pos, City city, Info info){
		info_ = info;
		timer_ = time;
		city_ = city;
		cost_ = 10;
		level_ = 0;
		timer_ = time;
		numberPeople_ = 0;
		foodQuantity_ = 0;
		roadAcces_ = 0;
		index_ = index;
		position_ = pos;
		img_ = new ImageIcon("src/Images/HouseMini.png");
		setIcon(img_);
		renters_ = new ArrayList<Citizen>();
	}
	public void addPeople(Citizen people){
		if(level_ == 0 && numberPeople_ < 10)
		{
			numberPeople_++;
			people.setHome_(this);
			renters_.add(people);
		}
		if (level_ == 0 && numberPeople_ == 10)
		{
			level_ = 1;
		}
		else if(level_ == 1 && numberPeople_ < 20)
		{
			numberPeople_++;
			renters_.add(people);
		}
		else if (level_ == 1 && numberPeople_ == 20)
		{
			level_ = 2;
		}
		city_.increaseCit();
	}
	public void removePeople(int index){
		if(numberPeople_ > 0)
		{
			numberPeople_--;
			renters_.remove(index);	
		}
		if(level_ > 0 && numberPeople_ < (level_*10))
			level_--;
		city_.decreaseCit();
	}
	public int getLevel_() {
		return level_;
	}
	public void setLevel_(int level_) {
		this.level_ = level_;
	}
	public int getNumberPeople_() {
		return numberPeople_;
	}
	public void setNumberPeople_(int numberPeople_) {
		this.numberPeople_ = numberPeople_;
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
	public int getObjectQuantity_() {
		return objectQuantity_;
	}
	public void setObjectQuantity_(int objectQuantity_) {
		this.objectQuantity_ = objectQuantity_;
	}
	public int getObjectTime_() {
		return objectTime_;
	}
	public void setObjectTime_(int objectTime_) {
		this.objectTime_ = objectTime_;
	}
	public int getReligionAccess_() {
		return religionAccess_;
	}
	public void setReligionAccess_(int religionAccess_) {
		this.religionAccess_ = religionAccess_;
	}
	public int getReligionTime_() {
		return religionTime_;
	}
	public void setReligionTime_(int religionTime_) {
		this.religionTime_ = religionTime_;
	}
	public int getRoadAcces_() {
		return roadAcces_;
	}
	public void setRoadAcces_(int roadAcces_) {
		this.roadAcces_ = roadAcces_;
	}
	public int getRoadTime_() {
		return roadTime_;
	}
	public void setRoadTime_(int roadTime_) {
		this.roadTime_ = roadTime_;
	}
	public int getWaterAccess_() {
		return waterAccess_;
	}
	public void setWaterAccess_(int waterAccess_) {
		this.waterAccess_ = waterAccess_;
	}
	public int getWaterTime_() {
		return waterTime_;
	}
	public void setWaterTime_(int waterTime_) {
		this.waterTime_ = waterTime_;
	}
	public int getDestructRisk_() {
		return destructRisk_;
	}
	public void setDestructRisk_(int destructRisk_) {
		this.destructRisk_ = destructRisk_;
	}
	public int getDestruckTime_() {
		return destruckTime_;
	}
	public void setDestruckTime_(int destruckTime_) {
		this.destruckTime_ = destruckTime_;
	}
	public int getFireRisk_() {
		return fireRisk_;
	}
	public void setFireRisk_(int fireRisk_) {
		this.fireRisk_ = fireRisk_;
	}
	public int getFireTime_() {
		return fireTime_;
	}
	public void setFireTime_(int fireTime_) {
		this.fireTime_ = fireTime_;
	}
	public int getSanityRisk_() {
		return sanityRisk_;
	}
	public void setSanityRisk_(int sanityRisk_) {
		this.sanityRisk_ = sanityRisk_;
	}
	public int getSanityTime_() {
		return sanityTime_;
	}
	public void setSanityTime_(int sanityTime_) {
		this.sanityTime_ = sanityTime_;
	}
	public ArrayList<Citizen> getRenters_() {
		return renters_;
	}
	public void setRenters_(ArrayList<Citizen> renters_) {
		this.renters_ = renters_;
	}
	public ImageIcon getImg_() {
		return img_;
	}
	public void setImg_(ImageIcon img_) {
		this.img_ = img_;
	}
	public Dimension getPosition_() {
		return position_;
	}
	public void setPosition_(Dimension position_) {
		this.position_ = position_;
	}
	public int getCost_() {
		return cost_;
	}
	public void setCost_(int cost_) {
		this.cost_ = cost_;
	}
	public String getInfos() {
		String str = "";
		str = ""+"Level : "+level_+","+"Number : "+index_+","+"Cost : "+cost_+","
		+"Number people : "+numberPeople_+","+"Food : "+foodQuantity_+","+"Objects : "+objectQuantity_+","
		+"Religion : "+religionAccess_+"%"+","+"Road : "+roadAcces_+"%"+","+"Water : "+waterAccess_+"%";
		return str;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
