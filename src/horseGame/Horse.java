package horseGame;

import java.awt.Image;

import javax.swing.ImageIcon;


public class Horse extends Subject implements Runnable { //말 클래스 . 말의 위치와 말의 이동 간격을  가지며 
	//RunningStrategy추상 클래스에 따라 각각 다른 알고리즘 실행됨
	
	public static final int SIZE = 50;//이미지 크기
   public static final int INTERVAL  =10;
   private int x,y;
   private int xInterval, yInterval;
   private RunningStrategy runningStrategy;
   private ImageIcon icon  ;//= new ImageIcon("images/horse1.PNG");//파일로부터 이미지 로딩;
   private Image img ;//= icon.getImage();//순수 이미지 객체 추출;
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
      notifyObservers(); //데이터 변경 시 Subject 클래스의 notifyObservers 메소드를 호출함.
	
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
