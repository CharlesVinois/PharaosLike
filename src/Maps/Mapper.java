package Maps;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import IHM.Info;
import IHM.MenuBar;
import IHM.Timers;
import Objets.Citizen;
import Objets.City;
import Objets.Farm;
import Objets.House;

public class Mapper extends JPanel{
	private static final long serialVersionUID = 3565977482626287182L;
	private String name_;
	private Dimension sizeLocal_;
	private ArrayList<ArrayList<Cell>> mapLocal_;
	private int difficulty_;
	private City city_;
	private Timers timer_;
	private Info info_;
	private JPanel map_;
	private MenuBar mBar_;
	private int local_cit_;
	//private ArrayList<Decors>;
	//private ArrayList<Animals>;
	//private ArrayList<interactiveObject>//ex:gold, silver and bronze mine/wood/argile
	//private ArrayList<Gods>;
	//private ArrayList<>
	public Mapper(){
		local_cit_ = 0;
		map_ = new JPanel();
		name_ = "test";
		city_ = new City(name_);
		sizeLocal_ = new Dimension(450, 580);
		map_.setSize(sizeLocal_);
		map_.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		map_.setBounds(0, 20, 450, 580);
		mapLocal_ = new ArrayList<ArrayList<Cell>>();
		difficulty_ = 0;
		timer_ = new Timers(this);
		info_ = new Info(timer_);
		mBar_ = new MenuBar(this);
		mBar_.setBounds(0, 0, 450, 20);
		this.add(mBar_);
		int k = (int)(Math.random() * (20-1)+1);
		for(int i = 0;i < 18;i++)
		{	
			ArrayList<Cell> ace = new ArrayList<Cell>();
			for(int j = 0;j < 15;j++)
			{
				Cell ce = new Cell(info_, this, new Dimension(j, i));
				if(i == k || i == k+1 || i == k-1 || i == k+15 || i == k-15)
					ce = new Cell(info_, new ImageIcon("src/Images/Grass.png"), "grass", this, new Dimension(j, i));
				ace.add(ce);
				map_.add(ce);
			}
			mapLocal_.add(ace);
		}
		this.add(info_);
		this.add(map_);
		refresh();
		this.setLayout(null);
		this.setSize(sizeLocal_);
		timer_.startAnim();
	}
	
	public void setPointer(String type){
		for(int i = 0;i < 18;i++)
		{	
			for(int j = 0;j < 15;j++)
			{
				if(type == "Farm" && mapLocal_.get(i).get(j).getType_() == "grass")
					mapLocal_.get(i).get(j).notify(new ImageIcon("src/Images/Farm.png"), "farm");
				else if(type == "Erase")
					mapLocal_.get(i).get(j).notify(new ImageIcon("src/Images/Solp.png"), "sand");
				else if(type == "Road" && mapLocal_.get(i).get(j).getType_() != "roadu")
					mapLocal_.get(i).get(j).notify(new ImageIcon("src/Images/RoadUD.png"), "roadu");
				else if(type == "Road" && mapLocal_.get(i).get(j).getType_() == "roadu")
					mapLocal_.get(i).get(j).notify(new ImageIcon("src/Images/RoadRL.png"), "roadr");
				else if(type == "House")
					mapLocal_.get(i).get(j).notify(new ImageIcon("src/Images/HouseMini.png"), "house");
				else if(type == "Archi")
					mapLocal_.get(i).get(j).notify(new ImageIcon("src/Images/AchitechtHouse.png"), "achiH");
				else if(type == "Fire")
					mapLocal_.get(i).get(j).notify(new ImageIcon("src/Images/FireHouse.png"), "fireH");
				else if(type == "Puit")
					mapLocal_.get(i).get(j).notify(new ImageIcon("src/Images/Puit.png"), "puit");
			}
		}
	}
	public void creatObject(String type, Dimension pos){
		if(type == "house")
		{
			House h1 = new House(timer_, city_.getBuilds_().size()+1, new Dimension((int) pos.getWidth(), (int) pos.getHeight()), city_, info_);
			city_.addHouse(h1);
			city_.setMoneyGlobal_(city_.getMoneyGlobal_()-h1.getCost_());
			local_cit_++;
			Citizen cit1 = new Citizen(new Dimension(0, 20), local_cit_, h1);
			//cit1.setBounds(40, 40, 20, 20);
			//h1.addPeople(cit1);
			this.add(cit1, 2);
			//timer_.setCitizen(cit1);
			timer_.addCitizen(cit1);
			info_.setText("People are comming from the top", new ImageIcon("src/Images/Caravane1.png"));
		}
		else if (type == "farm")
		{
			Farm fa1 = new Farm(timer_, city_.getFarms_().size()+1, new Dimension((int) pos.getWidth(), (int) pos.getHeight()), city_);
			city_.addFarm(fa1);
			city_.setMoneyGlobal_(city_.getMoneyGlobal_()-fa1.getCost_());
			info_.setText("You need people !", new ImageIcon("src/Images/Caravane1.png"));
		}
		else if (type == "road")
		{
			
		}
		//else if (type == "")
			
		//else if (type == "")
			
	}
	public void refresh(){
		map_.repaint();
		mBar_.refresh();
		validate();
		repaint();
	}
	public City getCity_() {
		return city_;
	}
	public void setCity_(City city_) {
		this.city_ = city_;
	}
	public Timers getTimer_() {
		return timer_;
	}
	public void setTimer_(Timers timer_) {
		this.timer_ = timer_;
	}
	public String getName_() {
		return name_;
	}
	public void setName_(String name_) {
		this.name_ = name_;
	}
	public Dimension getSizeLocal_() {
		return sizeLocal_;
	}
	public void setSizeLocal_(Dimension sizeLocal_) {
		this.sizeLocal_ = sizeLocal_;
	}
	public ArrayList<ArrayList<Cell>> getMapLocal_() {
		return mapLocal_;
	}
	public void setMapLocal_(ArrayList<ArrayList<Cell>> mapLocal_) {
		this.mapLocal_ = mapLocal_;
	}
	public int getDifficulty_() {
		return difficulty_;
	}
	public void setDifficulty_(int difficulty_) {
		this.difficulty_ = difficulty_;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Info getInfo_() {
		return info_;
	}
	public void setInfo_(Info info_) {
		this.info_ = info_;
	}
	public JPanel getMap_() {
		return map_;
	}
	public MenuBar getmBar_() {
		return mBar_;
	}
	public int getLocal_cit_() {
		return local_cit_;
	}
}
