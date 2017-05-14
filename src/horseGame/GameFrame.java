package horseGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

public class GameFrame extends JFrame {//GameFrame 프로그램 전체 프레임
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	public static  int warning=0;
	public int strengthLen1;
	public int strengthLen2;
	public int strengthLen3;
	private Field field;
	Font font = new Font("MD이솝",Font.PLAIN,30);
	JButton stopBtn ;
	public ImageIcon stopIcon;
	public ImageIcon playIcon;
	//pBar [] pBars;
	
	 //ImageIcon image = new ImageIcon("images/sky.PNG");
	public static JPanel horseStatus ;
	public static JLabel statusLabel1 = new JLabel();
	
	
	public GameFrame(Horse[] horse){
		super("Horse");
		setTitle("경주마 게임");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		for (int i = 0; i < horse.length; i++) {
			
			horse[i].play();
		}
		
		field = new Field(horse);
		field.setOpaque(true);
		field.setBackground(Color.yellow);
		Thread th = new Thread(field);
		th.start();
		//add(stopBtn,BorderLayout.NORTH);
		
		URL skyImgURL = GameFrame.class.getClassLoader().getResource("sky.PNG");
		ImageIcon skyIcon =new ImageIcon(skyImgURL);
		//Image skyImage = skyIcon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
		//skyIcon = new ImageIcon(skyImage);
		//ImageIcon skyImageIcon  = new ImageIcon("images/stop.PNG");
		
		/*
		URL stopImgURL = GameFrame.class.getClassLoader().getResource("stop.PNG");
		stopIcon =new ImageIcon(stopImgURL);
		Image stopImage = stopIcon.getImage().getScaledInstance(stopBtn.getWidth(), stopBtn.getHeight(), Image.SCALE_SMOOTH);
		stopIcon = new ImageIcon(stopImage);
		
		URL playImgURL = GameFrame.class.getClassLoader().getResource("play.PNG");
		playIcon =new ImageIcon(playImgURL);
		Image playImage = stopIcon.getImage().getScaledInstance(stopBtn.getWidth(), stopBtn.getHeight(), Image.SCALE_SMOOTH);
		playIcon = new ImageIcon(playImage);
		*/
		
		stopBtn = new JButton( new ImageIcon("images/stop.PNG"));
		stopBtn.setText("stop");
		stopBtn.setFont(font);
		stopBtn.setBackground(new Color(0xAFEEEE));
		Border border = new BevelBorder(SoftBevelBorder.RAISED);
		stopBtn.setBorder(border);
		stopBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 if( stopBtn.getText().equals("stop")){
				Field.status = false;
				
				//stopBtn = new JButton(playIcon));
				stopBtn.setIcon(new ImageIcon("images/play.PNG"));
				//stopBtn.setIcon(playIcon);
				stopBtn.setText("play");
				
				}
				
			
				else if( stopBtn.getText().equals("play")){
					stopBtn.setIcon(new ImageIcon("images/stop.PNG"));
					//stopBtn.setIcon(stopIcon);
					stopBtn.setText("stop");
					Field.status = true;
					Thread th = new Thread(field);
					th.start();
				}
			  
			  //Field.status = true;
			}
		});
		//add(Btn,BorderLayout.SOUTH);
		//this.pBars = pBars;
		strengthLen1 = horse[0].getStrength();
		statusLabel1.setOpaque(true);
		statusLabel1.setBounds(50,100,400,80);
		statusLabel1.setText("강도:"+strengthLen1);
		statusLabel1.setFont(font);
		statusLabel1.setBackground(Color.pink);
		statusLabel1.setBorder(border);
		
	horseStatus = new JPanel(){
			
			//ImageIcon icon = new ImageIcon("images/sky.PNG");
			public void paintComponent(Graphics g)
			
		{ 
				setOpaque(false);
				super.paintComponent(g);
				g.drawImage(skyIcon.getImage(),0, 0, null); 
				new ImageIcon("images/stop.PNG");
			}
			
			
		};
		horseStatus.add(statusLabel1);
		
	  
		
	strengthLen2 = horse[1].getStrength();
		
		
		strengthLen3 = horse[1].getStrength();
		
		//statusLabel.setText(statusStr);
		horseStatus.setLayout(null);
		horseStatus.setPreferredSize(new Dimension(WIDTH,300));
		//horseStatus.setBackground(Color.yellow);
		stopBtn.setBounds(150, 0, 200, 100);
		horseStatus.add(stopBtn);
		
		
	add(horseStatus,BorderLayout.NORTH);
		add(field,BorderLayout.CENTER);
		
		
		setSize(WIDTH,HEIGHT);
		setVisible(true);
    }
	

}
