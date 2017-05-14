package horseGame;

import java.awt.Image;

import javax.swing.ImageIcon;


public class Horse extends Subject implements Runnable { //�� Ŭ���� . ���� ��ġ�� ���� �̵� ������  ������ 
	//RunningStrategy�߻� Ŭ������ ���� ���� �ٸ� �˰��� �����
	
	public static final int SIZE = 50;//�̹��� ũ��
   public static final int INTERVAL  =10;
   private int x,y;
   private int xInterval, yInterval;
   private RunningStrategy runningStrategy;
   private ImageIcon icon  ;//= new ImageIcon("images/horse1.PNG");//���Ϸκ��� �̹��� �ε�;
   private Image img ;//= icon.getImage();//���� �̹��� ��ü ����;
   private int strength = 500;
   public Horse(){}
   public Horse(int x, int y,  ImageIcon icon,Image img){
	   
	   this.x = x;
	   this.y = y;
	   this.xInterval = this.yInterval = 0;
	   this.icon = icon;
	   this.img = this.icon.getImage();
   }
   
   public void setStrength(int s){
	   this.strength = s;
   }

public int getX() {
	return x;
}
public int getY() {
	return y;
}
public int getxInterval() {
	return xInterval;
}
public int getyInterval() {
	return yInterval;
}

public void setX(int x) {
	this.x = x;
}
public void setY(int y) {
	this.y = y;
}
   
public void setInterval(int xInterval, int yInterval){
	this.xInterval = xInterval;
	this.yInterval = yInterval;
			
}
   
public void setRunningStrategy(RunningStrategy runningStrategy){
	this.runningStrategy = runningStrategy;
}

public void play(){
	runningStrategy.play(this);
}
public void consume(int energy){
	strength -= energy;
      notifyObservers(); //������ ���� �� Subject Ŭ������ notifyObservers �޼ҵ带 ȣ����.
	
}
public int getStrength(){
	return strength;
}



public void run(){
	while (true) {
		x += xInterval;
		y += yInterval;

		if ((x < 0 && xInterval < 0) || x + Horse.SIZE > GameFrame.WIDTH - 15 && xInterval > 0) {
			xInterval = -xInterval;
		}
		if ((y < 0 && yInterval < 0) || y + Horse.SIZE > GameFrame.HEIGHT - 40 && yInterval > 0) {
			yInterval = -yInterval;
		}
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {}
	}
}


}
