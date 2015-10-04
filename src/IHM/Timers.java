package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import Maps.Mapper;
import Objets.Citizen;

public class Timers implements ActionListener{
	private Timer dec_;
	private Mapper map_;
	private int count_;
	private Citizen cit_;
	private ArrayList<Citizen> listCit_;
	public Timers(Mapper map){
		listCit_ = new ArrayList<Citizen>();
		count_ = 0;
		map_ = map;
		dec_=new Timer(200, this);
		dec_.start();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Timer tim=(Timer) arg0.getSource();
		map_.getCity_().goToWork();
		if(listCit_.size() != 0)
			syncCitizen();
		map_.refresh();
		count_++;
	}
	public void stopAnim(){
		dec_.stop();
	}
	public void startAnim(){
		dec_.start();
	}
	public int getTime(){
		return count_;
	}
	public void syncCitizen(){
		for(final Citizen x: listCit_) {
			x.move();
		}
	}
	public void addCitizen(Citizen cit) {
		listCit_.add(cit);
	}
}