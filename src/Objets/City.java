package Objets;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;

public class City {
	private String name_;
	private Dimension position_;
	private int moneyGlobal_;
	private int numberCitizen_;
	private int numberUnemploy_;
	private int numberNeeded_;
	private int numberPossible_;
	private int numberHouse_;
	private int politicStats_;
	private int satifyStats_;
	private int monumentStats_;
	private int sanityStats_;
	private int commercialStats_;
	private int religionStats_;
	private String religion_;
	private ArrayList<House> builds_;
	private ArrayList<Farm> farms_;
	
	//private ArrayList<Road> roads_;
	//
	//CommerceManager
	//PoliticsManger
	//etc..
	//Map
	//Player
	//TimeStamp since began
	public City(String name){
		name_ = name;
		builds_ = new ArrayList<House>();
		farms_ = new ArrayList<Farm>();
		numberCitizen_ = 0;
		moneyGlobal_ = 10000;
		numberHouse_ = 0;
	  numberUnemploy_ = 0;
	  numberNeeded_ = 0;
	  numberPossible_ = 0;
	  politicStats_ = 0;
	  satifyStats_ = 0;
	  monumentStats_ = 0;
	  sanityStats_ = 0;
	  commercialStats_ = 0;
	  religionStats_ = 0;
	  religion_ = "Orus";
	}
	public City(String name, ArrayList<House> builds, int numbCit, int money){
		name_ = name;
		builds_ = builds;
		numberHouse_ = builds.size();
		numberCitizen_ = numbCit;
		moneyGlobal_ = money;
	}
	public void goToWork() {
		JLabel jl = null;
		if(numberNeeded_ > 0 && numberUnemploy_ > 0)
		{
			for(Farm farm : farms_)
				if(farm.getWorker_() < 10)//&& priority
					jl = farm;
			for(House house : builds_)
				for(Citizen cit : house.getRenters_())
					if(cit.getType_() == 7)//&& priority
					{
						if(numberNeeded_ > 0 && numberUnemploy_ > 0)
						{
							cit.setWork_(jl);
							numberUnemploy_--;
							numberNeeded_--;
							cit.goingWork();
						}
					}
		}			
	}
	public void addHouse(House house){
		builds_.add(house);
		if(house.getLevel_() == 0)
			numberPossible_ = numberPossible_ + 9;
		numberHouse_++;
	}
	public void removeHouse(int index){
		builds_.remove(index);
		numberHouse_--;
	}
	public void addFarm(Farm farm) {
		farms_.add(farm);
		setNumberNeeded_(numberNeeded_ + 5);
	}
	public void removeFarm(int index) {
		farms_.remove(index);
		setNumberNeeded_(numberNeeded_ - 5);
	}
	public ArrayList<Farm> getFarms_() {
		return farms_;
	}
	public void setFarms_(ArrayList<Farm> farms_) {
		this.farms_ = farms_;
	}
	public String getName_() {
		return name_;
	}
	public void setName_(String name_) {
		this.name_ = name_;
	}
	public Dimension getPosition_() {
		return position_;
	}
	public void setPosition_(Dimension position_) {
		this.position_ = position_;
	}
	public int getMoneyGlobal_() {
		return moneyGlobal_;
	}
	public void setMoneyGlobal_(int moneyGlobal_) {
		this.moneyGlobal_ = moneyGlobal_;
	}
	public int getNumberCitizen_() {
		return numberCitizen_;
	}
	public void setNumberCitizen_(int numberCitizen_) {
		this.numberCitizen_ = numberCitizen_;
	}
	public void increaseCit() {
		numberCitizen_++;
		numberUnemploy_++;
	}
	public void decreaseCit() {
		numberCitizen_--;
		//decrease local citizen type
	}
	public int getNumberHouse_() {
		return numberHouse_;
	}
	public void setNumberHouse_(int numberHouse_) {
		this.numberHouse_ = numberHouse_;
	}
	public int getPoliticStats_() {
		return politicStats_;
	}
	public void setPoliticStats_(int politicStats_) {
		this.politicStats_ = politicStats_;
	}
	public int getSatifyStats_() {
		return satifyStats_;
	}
	public void setSatifyStats_(int satifyStats_) {
		this.satifyStats_ = satifyStats_;
	}
	public int getMonumentStats_() {
		return monumentStats_;
	}
	public void setMonumentStats_(int monumentStats_) {
		this.monumentStats_ = monumentStats_;
	}
	public int getSanityStats_() {
		return sanityStats_;
	}
	public void setSanityStats_(int sanityStats_) {
		this.sanityStats_ = sanityStats_;
	}
	public int getCommercialStats_() {
		return commercialStats_;
	}
	public void setCommercialStats_(int commercialStats_) {
		this.commercialStats_ = commercialStats_;
	}
	public int getReligionStats_() {
		return religionStats_;
	}
	public void setReligionStats_(int religionStats_) {
		this.religionStats_ = religionStats_;
	}
	public String getReligion_() {
		return religion_;
	}
	public void setReligion_(String religion_) {
		this.religion_ = religion_;
	}
	public ArrayList<House> getBuilds_() {
		return builds_;
	}
	public void setBuilds_(ArrayList<House> builds_) {
		this.builds_ = builds_;
	}
	public int getNumberUnemploy_() {
		return numberUnemploy_;
	}
	public void setNumberUnemploy_(int numberUnemploy_) {
		this.numberUnemploy_ = numberUnemploy_;
	}
	public int getNumberNeeded_() {
		return numberNeeded_;
	}
	public void setNumberNeeded_(int numberNeeded_) {
		this.numberNeeded_ = numberNeeded_;
	}
	public int getNumberPossible_() {
		return numberPossible_;
	}
	public void setNumberPossible_(int numberPossible_) {
		this.numberPossible_ = numberPossible_;
	}
	public String getInfos() {
		String str = "";
		str = ""+"Name : "+name_+","+"Treasure : "+moneyGlobal_+"Db"+","+"Citizen : "+numberCitizen_+","+"Unemployed : "+numberUnemploy_
				+","+"Needed : "+numberNeeded_+","+"Disponibility : "+numberPossible_+","+"Houses : "+numberHouse_
				+","+"Farms : "+farms_.size()+","+"Politics : "+politicStats_+","+"Satifaction : "+satifyStats_+","
				+"Monument : "+monumentStats_+","+"Sanity : "+sanityStats_+","+"Commercial : "+commercialStats_
				+","+"Religion : "+religionStats_+","+"Religion : "+religion_;
		return str;
	}
}
