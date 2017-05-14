package horseGame;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;




public class Main {
	private static final int INIT_LOCATION[] = {20, 100, 180};
	public static void main(String[] args) {
		
		//ImageIcon icon  = new ImageIcon("images/horse1.PNG");//파일로부터 이미지 로딩;
		//Image img = icon.getImage();//순수 이미지 객체 추출;
		
		ImageIcon[]icons = new ImageIcon[3];
		icons[0] = new ImageIcon("images/horse1.PNG");
		icons[1] = new ImageIcon("images/horse2.PNG");
		icons[2] = new ImageIcon("images/horse3.PNG");
		Image[] imgs = new Image[3];
	 for(int i=0;i<icons.length;i++){
		 imgs[i] = icons[i].getImage();
	 }
	 
	 
	
	
		Horse horse[] = new Horse[3];
		for (int i = 0; i < horse.length; i++) {
			horse[i] = new Horse(INIT_LOCATION[i], INIT_LOCATION[i],icons[i],imgs[i]);
			//horse[i].start();
			Thread th =  new Thread(horse[i]);
			th.start();
		}

		//VerticalRunStrategy
		//HorizontalRunStrategy
		//horse[0].setRunningStrategy(new VerticalRunStrategy());
	      horse[0].setRunningStrategy(new HorizontalRunStrategy());
		
	  
		//horse[1].setRunningStrategy(new VerticalRunStrategy());
		horse[1].setRunningStrategy(new HorizontalRunStrategy());
	
       //horse[1].setStrength(200);
		//horse[2].setRunningStrategy(new VerticalRunStrategy());
		horse[2].setRunningStrategy(new HorizontalRunStrategy());
		 //horse[2].setStrength(300);
		 
		 //String statusStr = horse[0].get
		GameFrame g = new GameFrame(horse);
		
		
	
 		
      for( int i=0;i<horse.length;i++){
    	 
        
  		Observer horseStrengthDisplay =new HorseStrengthDisplay(horse[i]);
  		Observer horseWarning  =new HorseWarning(horse[i]);
  		
  		
  		//horseStrengthDisplay 옵서버를 Horse에 설정함.
  		horse[i].attach(horseStrengthDisplay);
  		
  		
  		//horseWarning 옵서버 Horse에 설정함.
  		horse[i].attach(horseWarning);
  	
    	  
      }//end of for
     
      
//      if( horse[0].getStrength()<350){
//    	  GameFrame.statusLabel1.setBackground(Color.red);
//      }
//      else{
//    	 // GameFrame.statusLabel1.setOpaque(true);
//  		GameFrame.statusLabel1.setBackground(Color.pink);
//      }
      
      horse[0].consume(20); 
      horse[0].consume(50); 
      horse[0].consume(15);
     
      System.out.println("--------------------------------------------");

    /*  if( horse[0].getStrength()<350){
    	  GameFrame.statusLabel1.setBackground(Color.red);
      }
      else{
    	 // GameFrame.statusLabel1.setOpaque(true);
    	  GameFrame.statusLabel1.setBackground(new Color(0x8B5927));
      }*/
      horse[1].consume(80); 
      horse[1].consume(40);
      horse[1].consume(30);
     
      System.out.println("--------------------------------------------");

      /*if( horse[0].getStrength()<350){
    	  GameFrame.statusLabel1.setBackground(Color.red);
      }
      else{
    	  //GameFrame.statusLabel1.setOpaque(true);
    	  GameFrame.statusLabel1.setBackground(Color.orange);
      }*/
      horse[2].consume(120);
      horse[2].consume(70);
      horse[2].consume(45);
		

	}

}
