package horseGame;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public abstract class Subject extends JLabel { //추상화된 변경 관심 대상 데이터
	private List<Observer> observers = new ArrayList<Observer>(); //추상화된 통보 대상 목록
	
	public void attach(Observer observer){
		observers.add(observer);
	}
	public void detach(Observer observer){
		observers.remove(observer);
	}
	
	public void notifyObservers(){
		
		for(Observer o: observers){
			o.update();
			
		}
		
	}
	
	

}
