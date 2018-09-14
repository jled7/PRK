import java.awt.Font;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
// Timer Imports
import java.awt.Toolkit;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panela extends JPanel implements ActionListener, KeyListener{
	private Image car1, car2, background, car3, car4;
	private Timer timer;
	private int x1 = 20, x2, x3, x4, y1 = 300, y2 = 220, y3 = 120, y4=30, xb;
	private int puntuacion = 0;
	public boolean stillPlaying = true;

	public void setX(int kotxea, int balioa) {
		if (kotxea == 4) {
			x4 = balioa;
		} else if (kotxea == 2) {
			x2 = balioa;
		} else if (kotxea == 3) {
			x3 = balioa;
		}
	}
	public void setY(int kotxea, int balioa) {
		if (kotxea == 4) {
			y4 = balioa;
		} else if (kotxea == 2) {
			y2 = balioa;
		} else if (kotxea == 3) {
			y3 = balioa;
		}
	}

	public Panela() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource("kotxe1.png"));
		car1 = ii.getImage();
		ImageIcon ii2 = new ImageIcon(this.getClass().getResource("kotxe2.png"));
		car2 = ii2.getImage();
		ImageIcon ii3 = new ImageIcon(this.getClass().getResource(
				"background.jpg"));
		background = ii3.getImage();
		ImageIcon ii4 = new ImageIcon(this.getClass()
				.getResource("kotxe3.png"));
		car3 = ii4.getImage();
		ImageIcon ii5 = new ImageIcon(this.getClass()
				.getResource("kotxe4.png"));
		car4 = ii5.getImage();
		this.setBackground(Color.white);
		timer = new Timer(15, this); // 15ms-ro actionPerformed metodoari
										// deitzen dio
		timer.start();
		
		this.addKeyListener(this);
	}

	public void paint(Graphics g) {
		super.paint(g);
		if(stillPlaying) {
			g.drawImage(background, xb, 0, this);
			g.drawImage(car3, x3, y3, this);
			g.drawImage(car1, x1, y1, this);
			g.drawImage(car2, x2, y2, this);
			g.drawImage(car4, x4, y4, this);
			g.setColor(Color.RED);
			g.setFont(new Font("Times New Roman", Font.BOLD, 12));
			g.drawString("Puntuacion: " + puntuacion, 10,20);
		}
		if(!stillPlaying) {
			g.drawRect(0, 0, 600, 600);
			g.setFont(new Font("Times New Roman", Font.PLAIN, 70));
			g.setColor(Color.BLACK);
			g.drawString("GAME OVER", 90, 250);
		}
	}

	public void actionPerformed(ActionEvent e) {
		repaint(); // panela bir-margotu (re-paint)
		if(stillPlaying) {
			xb--;
			puntuacion++;
		}	
		if(xb < -625) {
			xb = 0;
		}
		
	}

	public void keyPressed(KeyEvent e) {
		if(stillPlaying) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				y1-=5;
				break;
			case KeyEvent.VK_S:
				y1+=5;
				break;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		
		
	}
	public void checkCollision(int kotxea) {
		Rectangle rec = new Rectangle(x1, y1+35, 120, 60);
		Rectangle rec2;
		if(kotxea == 2) {
			rec2 = new Rectangle(x2, y2+35, 120, 60);
			if(rec.intersects(rec2)) {
				stillPlaying = false;
			}
			
		}
		if(kotxea == 3) {
			rec2 = new Rectangle(x3, y3+35, 120, 60);
			if(rec.intersects(rec2)) {
				stillPlaying = false;
			}
			
		}
		if(kotxea == 4) {
			rec2 = new Rectangle(x4, y4+35, 120, 60);
			if(rec.intersects(rec2)) {
				stillPlaying = false;
			}
			
		}
		
	}
}