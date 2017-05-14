package horseGame;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public abstract class Subject extends JLabel { //�߻�ȭ�� ���� ���� ��� ������
	private List<Observer> observers = new ArrayList<Observer>(); //�߻�ȭ�� �뺸 ��� ���
	
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
