package horseGame;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Field extends JPanel implements Runnable {
	//�� �׸��� ���� �����̴� Ŭ���� �ʴ� 30��paint�Լ��� �� �׸� �ѷ���
public static boolean status=true;
	private static final long serialVersionUID = 1L;
	private Horse[] horse;
	private Image bImage;
	/*ImageIcon grassIcon  = new ImageIcon("images/grass.PNG");//���Ϸκ��� �̹��� �ε�;
	Image grassImg = grassIcon.getImage();//���� �̹��� ��ü ����;
*/	
	URL grassImgURL = Field.class.getClassLoader().getResource("grass.PNG");
	ImageIcon grassIcon =new ImageIcon(grassImgURL);
	Image grassImage = grassIcon.getImage();
	
	/*ImageIcon icon  = new ImageIcon("images/horse1.PNG");//���Ϸκ��� �̹��� �ε�;
	Image img = icon.getImage();//���� �̹��� ��ü ����;
	*/
	URL h1ImgURL = Field.class.getClassLoader().getResource("horse1.PNG");
	ImageIcon h1Icon =new ImageIcon(h1ImgURL);
	Image h1Image = h1Icon.getImage();
	
	
	
	/*
	ImageIcon icon2  = new ImageIcon("images/horse2.PNG");//���Ϸκ��� �̹��� �ε�;
	Image img2 = icon2.getImage();//���� �̹��� ��ü ����;	
*/	
	
	URL h2ImgURL = Field.class.getClassLoader().getResource("horse2.PNG");
	ImageIcon h2Icon =new ImageIcon(h2ImgURL);
	Image h2Image = h2Icon.getImage();
	
	/*ImageIcon icon3  = new ImageIcon("images/horse3.PNG");//���Ϸκ��� �̹��� �ε�;
	Image img3 = icon3.getImage();//���� �̹��� ��ü ����;
*/	 
	
	URL h3ImgURL = Field.class.getClassLoader().getResource("horse3.PNG");
	ImageIcon h3Icon =new ImageIcon(h3ImgURL);
	Image h3Image = h3Icon.getImage();
	
	
	
	public Field(Horse [] horse) {
		 
		
		  
		 //this.icon = new ImageIcon("images/horse1.PNG");//���Ϸκ��� �̹��� �ε�
			//this.img = icon.getImage();//���� �̹��� ��ü ����
		 this.horse = horse;
		
		 setLayout(new FlowLayout());
		 
	}
	 
	/* public void paintComponent(Graphics g){
		ImageIcon grassIcon  = new ImageIcon("images/grass.PNG");//���Ϸκ��� �̹��� �ε�;
			Image grassImg = grassIcon.getImage();//���� �̹��� ��ü ����;
		 g.drawImage(grassImg, this.getWidth(), this.getHeight(), this);
		 
	 }*/
	 public void paint(Graphics g){
		 g.clearRect(0, 0,GameFrame.WIDTH, GameFrame.HEIGHT);
		
		 g.drawImage(grassImage,0,0,GameFrame.WIDTH, GameFrame.HEIGHT, this);
		 g.drawImage(h1Image, horse[0].getX(), horse[0].getY(), 100,100,this);
		 g.drawImage(h2Image, horse[1].getX(), horse[1].getY(), 100,100,this);
		 g.drawImage(h3Image, horse[2].getX(), horse[2].getY(), 100,100,this);
		 
	 }
	@Override
	public void run() {
		while(status){
			repaint();
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}

	}

}
