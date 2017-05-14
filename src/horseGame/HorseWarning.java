package horseGame;

import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;



public class HorseWarning implements Observer {
	
	private static final int LIMIT = 300;
	private Horse horse;
	int strength;
	
	public HorseWarning(Horse horse){
		this.horse = horse;
	}
	
	@Override
	public void update() {
		 strength = horse.getStrength();
		 String str = "[WARNING!!!] LOW STRENGTH: "+strength+"!!!\n";
		if(  strength <LIMIT){
			System.out.println(str);
			GameFrame.statusLabel1.setBackground(Color.red);
		
			
			Border border = new BevelBorder(BevelBorder.RAISED);
			GameFrame.statusLabel1.setBorder(border);
			
		}
		
		
	}
	
	

}
