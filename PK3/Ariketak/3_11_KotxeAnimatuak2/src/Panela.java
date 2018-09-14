import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
// Timer Imports
import java.awt.Toolkit;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;

public class Panela extends JPanel implements ActionListener {
	private Image car1, car2, background, moto;
	private Timer timer;
	private int x1, x2, x3, y1 = 200, y2 = 220, y3 = 120;

	public void setX(int kotxea, int balioa) {
		if (kotxea == 1) {
			x1 = balioa;
		} else if (kotxea == 2) {
			x2 = balioa;
		} else {
			x3 = balioa;
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
				.getResource("wheelie.gif"));
		moto = ii4.getImage();
		this.setBackground(Color.white);

		timer = new Timer(15, this); // 15ms-ro actionPerformed metodoari
										// deitzen dio
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0, this);
		g.drawImage(moto, x3, y3, this);
		g.drawImage(car1, x1, y1, this);
		g.drawImage(car2, x2, y2, this);

		
	}

	public void actionPerformed(ActionEvent e) {
		repaint(); // panela bir-margotu (re-paint)
	}
}