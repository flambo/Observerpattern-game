package horseGame;

import java.awt.Color;

import javax.swing.JLabel;



public class HorseStrengthDisplay implements Observer {
	public static int cnt=0;
//public int cnt=0;
	private Horse horse;
	private int strength;
	public HorseStrengthDisplay(Horse horse){
		this.horse = horse;
	}
	@Override
	public void update() {
	    // static int cnt=0;
		 strength = horse.getStrength();
		 String str =" Ã¼·Â: "+strength+" "+ "\n"; cnt++;
		System.out.println(str);
		/*if(strength<350){
			GameFrame.statusLabel1.setBackground(Color.red);
		}*/
		if( cnt>=0 && cnt<=3)GameFrame.statusLabel1.setBackground(Color.pink);
		else if( cnt>3 && cnt<=6)GameFrame.statusLabel1.setBackground(new Color(0x8B5927));
		else if(cnt>6)GameFrame.statusLabel1.setBackground(Color.orange);
		GameFrame.statusLabel1.setBounds(50,100,strength-100,80); 
		GameFrame.statusLabel1.setText(str);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
	
}
